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

@WebServlet(name = "CiudadanoSv", urlPatterns = { "/CiudadanoSv" })
public class CiudadanoSv extends HttpServlet {
    private List<Ciudadano> listaCiudadanos = new ArrayList<>();
    private Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    //Creo un ciudadano con los datos proporcionados desde el front
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        request.setAttribute("mensaje", "Se ha registrado correctamente " );
        request.getRequestDispatcher("registrarCiudadano.jsp").forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
