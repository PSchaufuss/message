// Repository-klassen fungerer som et datalager i hukommelsen.
// Den opretter 3 beskeder ved opstart og returnerer dem via en metode

package com.example.message.repository;

import com.example.message.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository
{
    private final List<Message> messages = new ArrayList<>();
    private int messageId = 1;

    public MessageRepository()
    {
        populateMessages();
    }

    private void populateMessages()
    {
        while (messageId <= 3)
        {
            messages.add(new Message(messageId, "Velkommen til " + messageId + ". Semester!"));
            messageId++;
        }
    }

    public List<Message> getAllMessages()
    {
        return messages;
    }

    public Message findMessageById(int id)
    {
        return messages.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Message addMessage(Message message)
    {
        Message newMessage = new Message(messageId, message.getContent());
        messages.add(newMessage);
        messageId++;
        return newMessage;
    }


}
