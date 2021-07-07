package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository {

    Message save(Message message);

    List<Message> saveAll(List<Message> messages);

    List<Message> findAll();

    List<Message> findAll(List<String> ids);

    Message findOne(String id);

    long count();

    long delete(String id);

    long delete(List<String> ids);

    long deleteAll();

    Message update(Message message);

    long update(List<Message> messages);

}
