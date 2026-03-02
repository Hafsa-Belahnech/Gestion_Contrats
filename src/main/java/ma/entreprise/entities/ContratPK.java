package ma.entreprise.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ContratPK  implements Serializable {
    private int client;
    private int assurance;

    public ContratPK(){
    }

    public  ContratPK(int client, int assurance){
        this.client = client;
        this.assurance = assurance;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getAssurance() {
        return assurance;
    }

    public void setAssurance(int assurance) {
        this.assurance = assurance;
    }
}
