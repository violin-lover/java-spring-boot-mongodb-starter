package com.mongodb.starter.repositories;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.starter.models.Message;
import org.bson.BsonDocument;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.ReturnDocument.AFTER;

@Repository
public class MongoDBMessageRepository implements MessageRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
    private final MongoClient client;
    private MongoCollection<Message> messageCollection;

    public MongoDBMessageRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        messageCollection = client.getDatabase("Jess").getCollection("messages", Message.class);
    }

    @Override
    public Message save(Message message) {
        message.setId(new ObjectId());
        messageCollection.insertOne(message);
        return message;
    }

    @Override
    public List<Message> saveAll(List<Message> messages) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                messages.forEach(p -> p.setId(new ObjectId()));
                messageCollection.insertMany(clientSession, messages);
                return messages;
            }, txnOptions);
        }
    }

    @Override
    public List<Message> findAll() {
        return messageCollection.find().into(new ArrayList<>());
    }

    @Override
    public List<Message> findAll(List<String> ids) {
        return messageCollection.find(in("_id", mapToObjectIds(ids))).into(new ArrayList<>());
    }

    @Override
    public Message findOne(String id) {
        return messageCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public long count() {
        return messageCollection.countDocuments();
    }

    @Override
    public long delete(String id) {
        return messageCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    @Override
    public long delete(List<String> ids) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(
                    () -> messageCollection.deleteMany(clientSession, in("_id", mapToObjectIds(ids))).getDeletedCount(),
                    txnOptions);
        }
    }

    @Override
    public long deleteAll() {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(
                    () -> messageCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }
    }

    @Override
    public Message update(Message message) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return messageCollection.findOneAndReplace(eq("_id", message.getId()), message, options);
    }

    @Override
    public long update(List<Message> messages) {
        List<ReplaceOneModel<Message>> writes = messages.stream()
                                                 .map(p -> new ReplaceOneModel<>(eq("_id", p.getId()), p))
                                                 .collect(Collectors.toList());
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(
                    () -> messageCollection.bulkWrite(clientSession, writes).getModifiedCount(), txnOptions);
        }
    }

    private List<ObjectId> mapToObjectIds(List<String> ids) {
        return ids.stream().map(ObjectId::new).collect(Collectors.toList());
    }
}
