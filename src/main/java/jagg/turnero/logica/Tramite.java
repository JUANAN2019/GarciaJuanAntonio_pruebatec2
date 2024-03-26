package jagg.turnero.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tramite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tramite;
    private Boolean tramiteEstado;

    @ManyToOne
    @JoinColumn(name = "turno_id")
    private Turno turno;

    public Tramite() {
    }

    public Tramite(String tramite, Boolean tramiteEstado, Turno turno) {
        this.tramite = tramite;
        this.tramiteEstado = tramiteEstado;
        this.turno = turno;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public Boolean getTramiteEstado() {
        return tramiteEstado;
    }

    public void setTramiteEstado(Boolean tramiteEstado) {
        this.tramiteEstado = tramiteEstado;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    
    
}
