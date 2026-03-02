package ma.entreprise;


import ma.entreprise.entities.Assurance;
import ma.entreprise.entities.Client;
import ma.entreprise.entities.Contrat;
import ma.entreprise.service.AssuranceService;
import ma.entreprise.service.ClientService;
import ma.entreprise.service.ContratService;

import java.util.Date;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {

        AssuranceService as = new AssuranceService();
        ContratService cs = new ContratService();
        ClientService cl = new ClientService();


        // 2. Test des méthodes demandées
        try {
            System.out.println("--- Démarrage des tests ---");


            String clientRecherche = "978123";
            Client l = cl.findByCin(clientRecherche);
            System.out.println("Client trouvé (CIN " + clientRecherche + ") : " + (l != null ? l.getCin() : "Celui ci"));

             //Afficher les contrats d’un client (par CIN) ;
             if (cl != null) {
             List<Contrat> contratsClient = cl.findByCin(clientRecherche);
             System.out.println("Contrat du client " + cl.findByCin() + " : " + contratsClient.size());
             }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



