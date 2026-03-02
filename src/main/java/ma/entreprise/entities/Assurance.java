package ma.entreprise.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Assurance {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String type;
        private Double montant;
        private String couverture;



        @OneToMany(mappedBy = "assurance", fetch = FetchType.EAGER)
        private List<Contrat> contrats;

        //Constructeur sans paramètres requis par JPA
        public Assurance(){
        }

        //Constructeur avec paramètres
        public Assurance( String type, Double montant, String couverture){
            this.type = type;
            this.montant = montant;
            this.couverture = couverture;

        }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getCouverture() {
        return couverture;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

}
