package org.example.todolist.dao;

import org.example.todolist.model.ToDo;

import java.sql.SQLException;
import java.util.List;

public interface ToDoDAO {
    void insertToDo(ToDo toDo) throws SQLException;
    ToDo selectToDo(int toDoId) throws SQLException;
    List<ToDo> selectAllToDos() throws SQLException;
    boolean deleteTodo(int id) throws SQLException;
    boolean updateTodo(ToDo todo) throws SQLException;
}
