
package jagg.turnero.servlets;

import com.google.protobuf.TextFormat;

import jagg.turnero.logica.Ciudadano;
import jagg.turnero.logica.Controladora;
import jagg.turnero.logica.Turno;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TurnoSv", urlPatterns = { "/TurnoSv" })
public class TurnoSv extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estadoStr = request.getParameter("estado");
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));

        // Check if estadoStr is empty and assign null to estadoTramite if so
        // Boolean estadoTramite = estadoStr == null || estadoStr.isEmpty() ? null : Boolean.parseBoolean(estadoStr);
        List<Turno> listaTurnos;
       if(estadoStr.isEmpty()){
            listaTurnos = control.traerTurnosFecha(fecha);
       }else{
            Boolean estadoTramite = Boolean.parseBoolean(estadoStr);
            listaTurnos = control.traerTurnosFechaEstado(fecha, estadoTramite);
       }
       

        try {
            request.setAttribute("turnos", listaTurnos);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (TextFormat.ParseException ex) {
            Logger.getLogger(TurnoSv.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {

    //     LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
    //     String tramite = request.getParameter("tramite");
    //     Long id = Long.parseLong(request.getParameter("id"));
    //     Ciudadano ciudadano = control.traerCiudadano(id);

    //     try {
    //         Turno turno = new Turno();
    //         turno.setFecha(fecha);
    //         turno.setTramite(tramite);
    //         control.crearTurno(turno, Long.parseLong(id));

    //         request.getRequestDispatcher("index.jsp").forward(request, response);
    //     } catch (TextFormat.ParseException ex) {
    //         Logger.getLogger(TurnoSv.class.getName()).log(Level.SEVERE, null, ex);
    //     }

    // }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
    String tramite = request.getParameter("tramite");
    //Long id = Long.parseLong(request.getParameter("id"));

    try {
        Long id = Long.parseLong(request.getParameter("id"));
        Ciudadano ciudadano = control.traerCiudadano(id);

        if (ciudadano != null) {
            Turno turno = new Turno();
            turno.setFecha(fecha);
            turno.setTramite(tramite);
            control.crearTurno(turno, id);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "error");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    } catch (TextFormat.ParseException ex) {
        Logger.getLogger(TurnoSv.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Cerrar la conexión a la base de datos
    }
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
