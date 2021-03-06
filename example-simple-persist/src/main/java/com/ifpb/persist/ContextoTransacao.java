package com.ifpb.persist;

import com.ifpb.model.Filme;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Amanda
 */
@PersistenceContext(unitName = "DAC", type = PersistenceContextType.TRANSACTION)
public class ContextoTransacao {

    private final EntityManager em;

    public ContextoTransacao() {
        this.em = Persistence.createEntityManagerFactory("DAC").createEntityManager();
    }

    public void persistir(Filme filme) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(filme);
        transaction.commit();
    }

}
