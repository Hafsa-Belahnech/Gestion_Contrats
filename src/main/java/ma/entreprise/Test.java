package ma.entreprise;

import ma.entreprise.util.HibernateUtil;

public class Test {
    public static void main(String[] args) {

        try {
            // L'appel au Singleton suffit à déclencher la génération des tables
            HibernateUtil.getSessionFactory();
            System.out.println("Succès : La base de données et les tables (Assurance, Client, Contrat) ont été générées.");
        } catch (Exception e) {
            System.err.println("Erreur lors de la génération : " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Toujours fermer la session factory à la fin du test
            HibernateUtil.shutdown();
        }
    }
}
