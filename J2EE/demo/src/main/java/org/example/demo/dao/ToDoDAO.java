package org.example.demo.dao;

import org.example.demo.model.ToDo;

import java.sql.SQLException;
import java.util.List;

public interface ToDoDAO {
    void insertToDo(ToDo toDo) throws SQLException, ClassNotFoundException;
    ToDo selectToDo(int toDoId) throws SQLException, ClassNotFoundException;
    List<ToDo> selectAllToDos() throws SQLException, ClassNotFoundException;
    boolean deleteTodo(int id) throws SQLException, ClassNotFoundException;
    boolean updateTodo(ToDo todo) throws SQLException, ClassNotFoundException;
}
