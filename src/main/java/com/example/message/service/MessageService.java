// Service-laget indeholder forretningslogik og kalder repository-klassen.
// Repository injiceres via konstruktøren (dependency injection).

package com.example.message.service;

import com.example.message.model.Message;
import com.example.message.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService
{
    private final MessageRepository repository;

    public MessageService(MessageRepository repository)
    {
        this.repository = repository;
    }

    public List<Message> getMessages()
    {
        return repository.getAllMessages();
    }

    public Message addMessage(Message message) {
        return repository.addMessage(message);
    }


}
