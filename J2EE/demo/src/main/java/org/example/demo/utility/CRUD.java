package org.example.demo.utility;

import org.example.demo.dao.ToDoDAO;
import org.example.demo.model.ToDo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUD implements ToDoDAO {

    private static final String insert = "INSERT INTO todos (title, username, description) VALUES (?, ?, ?)";
    private static final String selectByID = "select * from todos where id = ?";
    private static final String selectAll = "select * from todos";
    private static final String deleteByID = "delete from todos where id = ?";
    private static final String updateToDo = "update todos set title = ?, username= ?, description =? where id = ?";

    @Override
    public void insertToDo(ToDo toDo) throws SQLException, ClassNotFoundException {
        Connection connection = SQLConnection.getConnection();
        try (connection; PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, toDo.getTitle());
            preparedStatement.setString(2, toDo.getUsername());
            preparedStatement.setString(3, toDo.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error in CRUD/insert: " + e.getMessage());
        }
    }

    @Override
    public ToDo selectToDo(int toDoId) throws SQLException, ClassNotFoundException {
        Connection connection = SQLConnection.getConnection();
        ToDo toDo = null;

        try (connection; PreparedStatement preparedStatement = connection.prepareStatement(selectByID)) {
            preparedStatement.setInt(1, toDoId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                String username = rs.getString("username");
                String description = rs.getString("description");

                toDo = new ToDo(title, username, description);
            }
        } catch (Exception e) {
            System.out.println("Error in CRUD select single ToDo: " + e.getMessage());
        }

        return toDo;
    }

    @Override
    public List<ToDo> selectAllToDos() throws SQLException, ClassNotFoundException {
        List <ToDo> toDos = new ArrayList<>();
        Connection connection = SQLConnection.getConnection();

        try (connection; PreparedStatement preparedStatement = connection.prepareStatement(selectAll)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String username = rs.getString("username");
                String description = rs.getString("description");

                toDos.add(new ToDo(id, title, username, description));
            }
        } catch (Exception e) {
            System.out.println("Error in CRUD get all todos: " + e.getMessage());
        }

        return toDos;
    }

    @Override
    public boolean deleteTodo(int id) throws SQLException, ClassNotFoundException {
        boolean isDeleted = false;
        Connection connection = SQLConnection.getConnection();

        try (connection; PreparedStatement preparedStatement = connection.prepareStatement(deleteByID)) {

            preparedStatement.setInt(1, id);
            isDeleted = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error in todo crud delete: " + e.getMessage());
        }

        return isDeleted;
    }

    @Override
    public boolean updateTodo(ToDo todo) throws SQLException, ClassNotFoundException {
        boolean isUpdated = false;
        Connection connection = SQLConnection.getConnection();

        try (connection; PreparedStatement preparedStatement = connection.prepareStatement(updateToDo)) {

            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getUsername());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setInt(4, todo.getId());

            isUpdated = preparedStatement.executeUpdate() > 0;

            int x = 0;
        } catch (Exception e) {
            System.out.println("Error in crud update todo: " + e.getMessage());
        }

        return isUpdated;
    }
}
