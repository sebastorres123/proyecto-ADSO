
package com.mycompany.proyectoadso;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "recibirdatos", urlPatterns = {"/recibirdatos"})
public class recibirdatos extends HttpServlet {

    @SuppressWarnings("CallToPrintStackTrace")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String usuarioDB = "root";
        String passwordDB = "";
        String url = "jdbc:mysql://localhost:3306/adso";
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuarioDB, passwordDB);

            String query = "SELECT * FROM usuarios WHERE nombre=? and contraseña=?";
            ps = conexion.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                request.setAttribute("usuarios", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("panel.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("mensajeError", "usuario o contraseña incorrecta :(");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver");
            request.setAttribute("mensajeError", "error al conectar con la base de datos");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(recibirdatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(recibirdatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
