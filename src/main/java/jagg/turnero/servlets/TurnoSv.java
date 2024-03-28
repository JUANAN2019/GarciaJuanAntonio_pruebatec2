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

//Se recuperan los datos de los turnos, bien sean todos, en espera o atendidos y se envian al front 
//dependiendo del estado del turno y de la fecha se utiliza un metodo u otro para traerlos
@WebServlet(name = "TurnoSv", urlPatterns = { "/TurnoSv" })
public class TurnoSv extends HttpServlet {

    Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estadoStr = request.getParameter("estado");
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        List<Turno> listaTurnos;

        if (estadoStr.isEmpty()) {
            listaTurnos = control.traerTurnosFecha(fecha);
        } else {
            Boolean estadoTramite = Boolean.parseBoolean(estadoStr);
            listaTurnos = control.traerTurnosFechaEstado(fecha, estadoTramite);
        }
        try {
            request.setAttribute("turnos", listaTurnos);
            request.getRequestDispatcher("turnos.jsp").forward(request, response);
        } catch (TextFormat.ParseException ex) {
            Logger.getLogger(TurnoSv.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Se saca un nuevo turno comprobando que el ciudadano existe
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        String tramite = request.getParameter("tramite");

        try {
            Long id = Long.parseLong(request.getParameter("id"));
            Ciudadano ciudadano = control.traerCiudadano(id);

            if (ciudadano != null) {
                Turno turno = new Turno();
                turno.setFecha(fecha);
                turno.setTramite(tramite);
                control.crearTurno(turno, id);
                request.setAttribute("mensaje", "Ha sacado su turno correctamente");
                request.getRequestDispatcher("sacarTurno.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "No existe un ciudadano con el Id "+id);
                request.getRequestDispatcher("sacarTurno.jsp").forward(request, response);
            }
        } catch (NumberFormatException ex) {
            request.setAttribute("mensaje", "El ID del ciudadano debe ser un número");
            request.getRequestDispatcher("sacarTurno.jsp").forward(request, response);
        }catch (TextFormat.ParseException ex) {
            request.setAttribute("mensaje", "El ID del turno debe ser un número");
            request.getRequestDispatcher("sacarTurno.jsp.jsp").forward(request, response);
            Logger.getLogger(TurnoSv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
