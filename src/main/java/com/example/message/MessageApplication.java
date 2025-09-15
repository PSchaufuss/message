package com.example.message;

import com.example.message.model.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessageApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MessageApplication.class, args);
    }

    public static Message findMessageById(int id, String caps)
    {
        // Jeg slår op i repository via mine pakker
        com.example.message.repository.MessageRepository repo = new com.example.message.repository.MessageRepository();
        Message found = repo.findMessageById(id);

        // Sørger for at den returnerer null, hvis ikke id'et kan findes, og at det bliver store bogstaver, hvis 'caps' indgår i søgningen
        if (found == null) {return null;}

        if (caps != null && caps.equalsIgnoreCase("yes"))
        {
            return new Message(found.getId(), found.getContent().toUpperCase());
        }
        return found;
    }
}
