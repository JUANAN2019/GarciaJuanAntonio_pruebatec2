/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jagg.turnero.servlets;

import jagg.turnero.logica.Ciudadano;
import jagg.turnero.logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JUNAN
 */
@WebServlet(name = "CiudadanoSv", urlPatterns = {"/CiudadanoSv"})
public class CiudadanoSv extends HttpServlet {
    private List<Ciudadano> listaCiudadanos = new ArrayList<>();
   private Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
          System.out.println("estoy en dopost");
       String nombre = request.getParameter("nombre");
       String apellidos = request.getParameter("apellidos");
       String dni = request.getParameter("dni");
       String telefono = request.getParameter("telefono");
       String email = request.getParameter("email");
       
       Ciudadano ciudadano = new Ciudadano();
       ciudadano.setNombre(nombre);
       ciudadano.setApellidos(apellidos);
       ciudadano.setDni(dni);
       ciudadano.setTelefono(telefono);
       ciudadano.setEmail(email);
       listaCiudadanos.add(ciudadano);

       control.crearCiudadano(ciudadano);


       response.sendRedirect("index.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
