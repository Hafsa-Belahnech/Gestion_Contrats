package ma.entreprise;

import ma.entreprise.entities.Assurance;
import ma.entreprise.service.AssuranceService;
import ma.entreprise.service.ClientService;
import ma.entreprise.service.ContratService;

public class TestAssurance {

    public static void main(String[] args) {
       AssuranceService as = new AssuranceService();
       ContratService cs = new ContratService();
       ClientService cl = new ClientService();


        // 2. Test des méthodes demandées
        try {
            System.out.println("--- Démarrage des tests ---");

            // a. Trouver une assurance par son type
            String TypeRecherche = "Confirmée";
            Assurance a = as.findByType(TypeRecherche); // Nom de méthode à adapter
            System.out.println("Assurance trouvée (Type " + TypeRecherche + ") : " + (a != null ? a.getType() : "Confirmée"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

