package org.example.todolist.model;

import org.example.todolist.utility.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ToDo
{
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)(id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ToDo other = (ToDo) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
