package org.example.todolist.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.todolist.dao.ToDoDAO;
import org.example.todolist.model.ToDo;
import org.example.todolist.utility.CRUD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class TodoController extends HttpServlet {
    private ToDoDAO todoDAO;

    @Override
    public void init() throws ServletException {todoDAO = new CRUD();}

    private void showNewForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("todo/todo-form.jsp");
        dispatcher.forward(req, res);
    }

    private void insertTodo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        String title = req.getParameter("title");
        String username = req.getParameter("username");
        String description = req.getParameter("description");

        ToDo newTodo = new ToDo(title, username, description);
        todoDAO.insertToDo(newTodo);

        res.sendRedirect("list");
    }

    protected void deleteTodo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        todoDAO.deleteTodo(id);
        res.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        ToDo existingToDo = todoDAO.selectToDo(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("todo/todo-form.jsp");
        req.setAttribute("todo", existingToDo);
        dispatcher.forward(req, res);
    }

    protected void updateTodo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));

        String title = req.getParameter("title");
        String username = req.getParameter("username");
        String description = req.getParameter("description");

        ToDo updateToDo = new ToDo(id, title, username, description);

        todoDAO.updateTodo(updateToDo);

        res.sendRedirect("list");
    }

    protected void listTodo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        List<ToDo> toDos = todoDAO.selectAllToDos();
        req.setAttribute("listTodo", toDos);
        RequestDispatcher dispatcher = req.getRequestDispatcher("todo/todo-list.jsp");
        dispatcher.forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertTodo(request, response);
                    break;
                case "/delete":
                    deleteTodo(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateTodo(request, response);
                    break;
                case "/list":
                    listTodo(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
