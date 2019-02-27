package com.ifpb.persist;

import com.ifpb.interfaces.FilmeInterface;
import com.ifpb.model.Filme;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Amanda
 */
public class PersistSGBD implements FilmeInterface {

    private final EntityManager em;

    public PersistSGBD() {
        this.em = Persistence.createEntityManagerFactory("DAC").createEntityManager();
    }

    @Override
    public void adiconar(Filme filme) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(filme);
        transaction.commit();
    }

}
