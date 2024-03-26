package jagg.turnero.persistencia;

import jagg.turnero.logica.Turno;
import jagg.turnero.logica.Ciudadano;
import jagg.turnero.persistencia.exceptions.NonexistentEntityException;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    TurnoJpaController turnoJPA = new TurnoJpaController();
    CiudadanoJpaController ciudadanoJPA = new CiudadanoJpaController();

    public void crearTurno (Turno turno) {
        turnoJPA.create(turno);
    }

    public void eliminarTurno (Long id) {
        try {
            turnoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Turno traerTurno(long id){
        return turnoJPA.findTurno(id);
    }
    public List<Turno> traerTurnos () {
        return turnoJPA.findTurnoEntities();
    }
    public List<Turno> traerTurnosFechaEstado (LocalDate fecha, Boolean estadoTramite) {
         return turnoJPA.findTurnoEntitiesFechaEstado(fecha, estadoTramite);
        

    }

    public void editarTurno (Turno turno) {
        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void crearCiudadano (Ciudadano ciudadano) {
        ciudadanoJPA.create(ciudadano);
    }

    public void eliminarCiudadano (Long id) {
        try {
            ciudadanoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Ciudadano> traerCiudadanos () {
        return ciudadanoJPA.findCiudadanoEntities();
    }

    public void editarCiudadano (Ciudadano ciudadano) {
        try {
            ciudadanoJPA.edit(ciudadano);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Ciudadano obtenerCiudadano(Long id){
        return ciudadanoJPA.findCiudadano(id);
    }

}
