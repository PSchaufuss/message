// Dene klasse repræsenterer en besked med ID og Content
package com.example.message.model;

public class Message
{
    private int id;
    private String content;

    public Message(int id, String content)
    {
        this.id = id;
        this.content = content;
    }

    public int getId()
    {
        return id;
    }

    public String getContent()
    {
        return content;
    }
}
