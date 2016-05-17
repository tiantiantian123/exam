package action;

import model.Supply;
import util.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/supply")
public class SupplyAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("add")) {
            add(req, resp);
        }
        if (action.equals("queryAll")) {
            queryAll(req, resp);
        }
        if (action.equals("search")) {
            search(req, resp);
        }
        if (action.equals("update")) {
            update(req, resp);
        }
        if (action.equals("remove")) {
            remove(req, resp);
        }
    }

    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Connection connection = DB.getConnection();
        if (connection == null) {
            return;
        }
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM goods.supply WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Supply supply = new Supply(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("addr"), resultSet.getString("linkman"), resultSet.getString("materials"),
                    resultSet.getString("tel"));
            req.getSession().setAttribute("supply", supply);
            resp.sendRedirect("/edit.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(resultSet, preparedStatement, connection);
        }
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String addr = req.getParameter("addr");
        String linkman = req.getParameter("linkman");
        String materials = req.getParameter("materials");
        String tel = req.getParameter("tel");

        Connection connection = DB.getConnection();
        if (connection == null) {
            return;
        }
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE goods.supply SET name = ?, addr = ?, linkman = ?, materials = ? , tel = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, addr);
            preparedStatement.setString(3, linkman);
            preparedStatement.setString(4, materials);
            preparedStatement.setString(5, tel);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            resp.sendRedirect("/supply?action=queryAll");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(null, preparedStatement, connection);
        }
    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Connection connection = DB.getConnection();
        if (connection == null) {
            return;
        }
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM goods.supply WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            resp.sendRedirect("/supply?action=queryAll");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(null, preparedStatement, connection);
        }
    }

    protected void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = DB.getConnection();
        if (connection == null) {
            return;
        }
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM goods.supply";

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            List<Supply> supplies = new ArrayList<>();
            while (resultSet.next()) {
                Supply supply = new Supply(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("addr"), resultSet.getString("linkman"), resultSet.getString("materials"),
                        resultSet.getString("tel"));
                supplies.add(supply);
            }
            req.getSession().setAttribute("supplies", supplies);
            resp.sendRedirect("/supply.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(resultSet, preparedStatement, connection);
        }
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String addr = req.getParameter("addr");
        String linkman = req.getParameter("linkman");
        String materials = req.getParameter("materials");
        String tel = req.getParameter("tel");

        Connection connection = DB.getConnection();
        if (connection == null) {
            return;
        }
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO goods.supply VALUES (NULL, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, addr);
            preparedStatement.setString(3, linkman);
            preparedStatement.setString(4, materials);
            preparedStatement.setString(5, tel);
            preparedStatement.executeUpdate();

            resp.sendRedirect("/supply?action=queryAll");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(null, preparedStatement, connection);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}