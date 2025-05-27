package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.json.JSONObject;

public class UserRegistration extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "29344";

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("application/json;charset=UTF-8"); // IMPORTANT

    JSONObject json = new JSONObject();

    try (PrintWriter out = response.getWriter()) {
        String name = request.getParameter("user_name");
        String email = request.getParameter("user_email");
        String pass = request.getParameter("user_password");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, pass);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            json.put("status", "success");
            json.put("message", "User registered successfully!");
        } else {
            json.put("status", "failed");
            json.put("message", "Failed to register user.");
        }

        out.print(json.toString()); // ✅ Write JSON response
        out.flush();
    } catch (Exception e) {
        try (PrintWriter out = response.getWriter()) {
            json.put("status", "error");
            json.put("message", "Exception: " + e.getMessage());
            out.print(json.toString());
            out.flush();
        }
    }
}



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "User registration servlet";
    }
}
