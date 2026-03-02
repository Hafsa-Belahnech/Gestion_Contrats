package ma.entreprise.service;

import ma.entreprise.entities.Assurance;
import ma.entreprise.entities.Client;
import ma.entreprise.entities.Contrat;
import ma.entreprise.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class ContratService extends AbstractFacade<Contrat> {

    public ContratService() {
        super(Contrat.class);
    }


    //Afficher les contrats associés à une assurance (par type) ;
    public List<Contrat> findByAssurance(Assurance a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Contrat> contrats = session.createQuery("from Contrat tp where tp.assurance = :a")
                .setParameter("a", a)
                .list();
        session.close();
        return contrats;
    }

    //Afficher les contrats d’un client (par CIN)
    public List<Contrat> findByClient(Client cl) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Contrat> contrats = session.createQuery("from Contrat cin where cin.client = :a")
                .setParameter("a", cl)
                .list();
        session.close();
        return contrats;
    }

    public List<Contrat> findByDates(Date debut, Date fin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Contrat> livres = session.createQuery("from Contrat where dateFin > dateDebut")
                .setParameter("debut", debut)
                .setParameter("fin", fin)
                .list();
        session.close();
        return livres;
    }




    @Override
    public boolean update(Contrat o) {
        return false;
    }

    @Override
    public boolean delete(Contrat o) {
        return false;
    }
}

