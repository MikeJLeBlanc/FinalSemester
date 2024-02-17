package org.example.todolist.utility;

import org.example.todolist.dao.ToDoDAO;
import org.example.todolist.model.ToDo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUD implements ToDoDAO {

    private static final String insert = "INSERT INTO todos (title, username, description, target_date,  is_done) VALUES (?, ?, ?, ?, ?)";
    private static final String selectByID = "select * from todos where id = ?";
    private static final String selectAll = "select * from todos";
    private static final String deleteByID = "delete from todos where id = ?";
    private static final String updateToDo = "update todos set title = ?, username= ?, description =?, target_date =?, is_done = ? where id = ?";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    @Override
    public void insertToDo(ToDo toDo) throws SQLException {
        connection = SQLConnection.getConnection();
        preparedStatement = connection.prepareStatement(insert);
        try {
            preparedStatement.setString(1, toDo.getTitle());
            preparedStatement.setString(2, toDo.getUsername());
            preparedStatement.setString(1, toDo.getDescription());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    @Override
    public ToDo selectToDo(int toDoId) throws SQLException {
        connection = SQLConnection.getConnection();
        preparedStatement = connection.prepareStatement(selectByID);

        ToDo toDo = null;
        try {
            preparedStatement.setInt(1, toDoId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String username = rs.getString("username");
                String description = rs.getString("description");

                toDo = new ToDo(title, username, description);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        }

        return toDo;
    }

    @Override
    public List<ToDo> selectAllToDos() throws SQLException {
        List <ToDo> toDos = new ArrayList<>();

        try{
            connection = SQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(selectAll);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String username = rs.getString("username");
                String description = rs.getString("description");

                toDos.add(new ToDo(id, title, username, description));
            }
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return toDos;
    }

    @Override
    public boolean deleteTodo(int id) throws SQLException {
        boolean isDeleted = false;

        try {
            connection = SQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(deleteByID);
            preparedStatement.setInt(1, id);
            isDeleted = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return isDeleted;
    }

    @Override
    public boolean updateTodo(ToDo todo) throws SQLException {
        boolean isUpdated = false;

        try {
            connection = SQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(updateToDo);
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getUsername());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setInt(6, todo.getId());

            isUpdated = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return isUpdated;
    }
}
