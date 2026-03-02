package ma.entreprise.service;

import ma.entreprise.entities.Assurance;
import ma.entreprise.entities.Client;
import ma.entreprise.util.HibernateUtil;
import org.hibernate.Session;

public class AssuranceService extends AbstractFacade<Assurance>{

    public AssuranceService() {
        super(Assurance.class);
    }


    public Assurance findByType(String type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Assurance as = (Assurance) session.createQuery("from Assurance where type = :tp")
                .setParameter("tp", type)
                .uniqueResult();
        session.close();
        return as;
    }

    @Override
    public boolean update(Assurance o) {
        return false;
    }

    @Override
    public boolean delete(Assurance o) {
        return false;
    }
}
