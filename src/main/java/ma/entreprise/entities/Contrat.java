package ma.entreprise.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Contrat implements Serializable {
    @EmbeddedId
    private ContratPK pK;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Enumerated(EnumType.ORDINAL)
    private Statut statutOrdinal;

    @Enumerated(EnumType.STRING)
    private Statut statutString;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client", referencedColumnName = "id", insertable = false, updatable = false)
    private Client client;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assurance", referencedColumnName = "id", insertable = false, updatable = false)
    private Assurance assurance;


    //public Contrat(){}


    public Contrat(Date dateDebut, Date dateFin, Assurance assurance, Client client){

        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.assurance = assurance;
        this.client = client;
        pK = new ContratPK(assurance.getId(), client.getId());

    }

    public ContratPK getpK() {
        return pK;
    }

    public void setpK(ContratPK pK) {
        this.pK = pK;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public Statut getStatutOrdinal() {
        return statutOrdinal;
    }

    public void setStatutOrdinal(Statut statutOrdinal) {
        this.statutOrdinal = statutOrdinal;
    }

    public Statut getStatutString() {
        return statutString;
    }

    public void setStatutString(Statut statutString) {
        this.statutString = statutString;
    }
}

