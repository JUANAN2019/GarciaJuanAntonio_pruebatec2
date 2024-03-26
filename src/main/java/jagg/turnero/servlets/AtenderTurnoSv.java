/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jagg.turnero.servlets;

import com.google.protobuf.TextFormat;
import jagg.turnero.logica.Controladora;
import jagg.turnero.logica.Turno;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JUNAN
 */
@WebServlet(name = "AtenderTurnoSv", urlPatterns = {"/AtenderTurnoSv"})
public class AtenderTurnoSv extends HttpServlet {

    Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("idAtender");
        try {
            Turno turnoEdit = control.traerTurno(Long.parseLong(id));
            turnoEdit.setEstadoTramite(true);
            control.editarTurno(turnoEdit);
            request.getRequestDispatcher("index.jsp").forward(request, response);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (TextFormat.ParseException ex) {
            Logger.getLogger(TurnoSv.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
