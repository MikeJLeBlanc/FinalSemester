package org.example.demo.model;

public class ToDo {
    private int id;
    private String title;
    private String username;
    private String description;

    public ToDo(String title, String username, String description) {
        this.title = title;
        this.username = username;
        this.description = description;
    }

    public ToDo(int id, String title, String username, String description) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}
}
