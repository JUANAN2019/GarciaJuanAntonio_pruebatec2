package jagg.turnero.logica;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate fecha;
    private String tramite;
    private boolean estadoTramite;


    @ManyToOne
    @JoinColumn(name = "ciudadano_id")
    private Ciudadano ciudadano;
    public Turno() {
    }

    public Turno(LocalDate fecha, String tramite, Ciudadano ciudadano) {
        this.fecha = fecha;
        this.tramite = tramite;
        this.estadoTramite = false;
        this.ciudadano = ciudadano;
        
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public boolean isEstadoTramite() {
        return estadoTramite;
    }

    public void setEstadoTramite(boolean estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    @Override
    public String toString() {
        return "Turno{" + "id=" + id + ", fecha=" + fecha + ", tramite=" + tramite + ", estadoTramite=" + estadoTramite + ", ciudadano=" + ciudadano + '}';
    }

    
}
