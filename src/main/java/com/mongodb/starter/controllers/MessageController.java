package com.mongodb.starter.controllers;

import com.mongodb.starter.models.Message;
import com.mongodb.starter.repositories.MessageRepository;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;


/*
@PutMapping - to edit message
@GetMapping - to get message to client
@PostMapping - to post message */

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageRepository messageRepository;
    public MessageController(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    } 

    /*private final static Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }*/

    //-------------------------//

    @PostMapping("message")
    @ResponseStatus(HttpStatus.CREATED)
    public Message postMessage(@RequestBody Message message){
        return messageRepository.save(message);
    }

    @PostMapping("messages")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Message> postPersons(@RequestBody List<Message> messages) {
        return messageRepository.saveAll(messages);
    }

    @GetMapping("messages")
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("message/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable String id) {
        Message message = messageRepository.findOne(id);
        if (message == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(message);
    }

    @GetMapping("messages/{ids}")
    public List<Message> getMessages(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return messageRepository.findAll(listIds);
    }

    @GetMapping("messages/count")
    public Long getCount() {
        return messageRepository.count();
    }

    @DeleteMapping("message/{id}")
    public Long deleteMessage(@PathVariable String id) {
        return messageRepository.delete(id);
    }

    @DeleteMapping("messages/{ids}")
    public Long deleteMessages(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return messageRepository.delete(listIds);
    }

    @DeleteMapping("messages")
    public Long deleteMessages() {
        return messageRepository.deleteAll();
    }

    @PutMapping("message")
    public Message putMessage(@RequestBody Message message) {
        return messageRepository.update(message);
    }

    @PutMapping("messages")
    public Long putMessage(@RequestBody List<Message> messages) {
        return messageRepository.update(messages);
    }

}
