package ma.entreprise;

import ma.entreprise.util.HibernateUtil;

public class Test {
    public static void main(String[] args) {

        try {
            HibernateUtil.getSessionFactory();
            System.out.println("Succès : La base de données et les tables (Assurance, Client, Contrat) ont été générées.");
        } catch (Exception e) {
            System.err.println("Erreur lors de la génération : " + e.getMessage());
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
