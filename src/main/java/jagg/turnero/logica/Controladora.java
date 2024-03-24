package jagg.turnero.logica;

import jagg.turnero.persistencia.ControladoraPersistencia;
import jagg.turnero.persistencia.exceptions.NonexistentEntityException;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controladora  {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearTurno (Turno turno, Long idCiudadano) {

        Ciudadano ciudadano = controlPersis.obtenerCiudadano(idCiudadano);
        turno.setCiudadano(ciudadano);
        controlPersis.crearTurno(turno);
    }

    public void eliminarTurno (Long id) {
            controlPersis.eliminarTurno(id);
    }

    public List<Turno> traerTurnos () {
        return controlPersis.traerTurnos();
    }

    public void editarTurno (Turno turno) {
        try {
            controlPersis.editarTurno(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void crearCiudadano (Ciudadano ciudadano) {
        controlPersis.crearCiudadano(ciudadano);
    }

    public void eliminarCiudadano (Long id) {
        controlPersis.eliminarCiudadano(id);
    }

    public List<Ciudadano> traerCiudadanos () {
        return controlPersis.traerCiudadanos();
    }

    public void editarCiudadano (Ciudadano ciudadano) {
        try {
            controlPersis.editarCiudadano(ciudadano);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}