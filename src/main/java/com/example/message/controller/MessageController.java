// Controller-klassen håndterer HTTP-anmodninger fra klienten.
// Den bruger @Controller i stedet for @RestController og returnerer data via ResponseEntity.
package com.example.message.controller;

import com.example.message.MessageApplication;
import com.example.message.model.Message;
import com.example.message.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("message")
public class MessageController
{
    private final MessageService service;

    public MessageController(MessageService messageService)
    {
        this.service = messageService;
    }

    @GetMapping()
    public ResponseEntity<List<Message>> getMessages()
    {
        List<Message> messages = service.getMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int id, @RequestParam(required = false) String caps)
    {
        Message msg = MessageApplication.findMessageById(id, caps);
        if (msg == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Message> addMessage(@RequestBody Message message)
    {
        Message addMessage = service.addMessage(message);
        return new ResponseEntity<>(addMessage, HttpStatus.CREATED);
    }



}
