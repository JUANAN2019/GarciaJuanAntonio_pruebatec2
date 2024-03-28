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
 * Servlet para atender los turnos que estan en espera se hace por POST y
 * cambiar el estado en BBDD
 * 
 */
@WebServlet(name = "AtenderTurnoSv", urlPatterns = { "/AtenderTurnoSv" })
public class AtenderTurnoSv extends HttpServlet {

    Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // comprueba que el turno existe y que no esta atendido previamente si es asi lo atiende y verifica que se ha
    // introducido un numero enviando la respuesta apropiada al front, capturando las posibles excepciones.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("idAtender"));
            Turno turnoEdit = control.traerTurno(id);
            if (turnoEdit != null) {
                if (!turnoEdit.isEstadoTramite()) { 
                    turnoEdit.setEstadoTramite(true);
                    control.editarTurno(turnoEdit);
                    request.setAttribute("mensaje", "El turno con el Id " + id + " habia sido atendido.");
                } else {
                    request.setAttribute("mensaje", "El turno con el Id " + id + " ya ha sido atendido.");
                }
                request.getRequestDispatcher("turnos.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "No existe turno con el ID: " + id);
                request.getRequestDispatcher("turnos.jsp").forward(request, response);
            }
        } catch (NumberFormatException ex) {
            request.setAttribute("mensaje", "El ID del turno debe ser un número");
            request.getRequestDispatcher("turnos.jsp").forward(request, response);
        } catch (TextFormat.ParseException ex) {
            Logger.getLogger(TurnoSv.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
