package ma.entreprise.service;

import ma.entreprise.entities.Assurance;
import ma.entreprise.entities.Client;
import ma.entreprise.util.HibernateUtil;
import org.hibernate.Session;

public class ClientService extends AbstractFacade<Client> {


    public ClientService() {
        super(Client.class);
    }

    public Client findByCin(String cin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Client a = (Client) session.createQuery("from Client where cin = :c")
                .setParameter("c", cin)
                .uniqueResult();
        session.close();
        return a;
    }




    @Override
    public boolean update(Client o) {
        return false;
    }

    @Override
    public boolean delete(Client o) {
        return false;
    }
}
