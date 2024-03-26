
package jagg.turnero.servlets;

import com.google.protobuf.TextFormat;
import jagg.turnero.logica.Ciudadano;
import jagg.turnero.logica.Controladora;
import jagg.turnero.logica.Turno;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
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
@WebServlet(name = "TurnoSv", urlPatterns = {"/TurnoSv"})
public class TurnoSv extends HttpServlet {

    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        Boolean estadoTramite = Boolean.parseBoolean(request.getParameter("estado"));
        
        List<Turno> listaTurnos = control.traerTurnosFecha(fecha, estadoTramite);
        request.setAttribute("turnos", listaTurnos);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        String tramite = request.getParameter("tramite");
        String  id = request.getParameter("id");
        try{
            Turno turno = new Turno();
            turno.setFecha(fecha);
            turno.setTramite(tramite);
            control.crearTurno(turno, Long.parseLong(id));

            request.getRequestDispatcher("index.jsp").forward(request,response);
        }catch (TextFormat.ParseException ex){
            Logger.getLogger(TurnoSv.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
