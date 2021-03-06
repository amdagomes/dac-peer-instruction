package com.ifpb.persist;

import com.ifpb.model.Filme;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Amanda
 */
public class FilmeDAO {

    private final EntityManager em;

    public FilmeDAO() {
        //instancia o gerenciador do contexto
        this.em = Persistence.createEntityManagerFactory("DAC").createEntityManager();
    }

    //persiste a entidade no banco de dados
    public void create(Filme filme) {
        //abrindo uma transaçao com o banco
        em.getTransaction().begin();
        //realiza a persistência
        em.persist(filme);
        //confirma a transação
        em.getTransaction().commit();
    }

    //remove o objeto do banco de dados
    public void remove(Filme filme) {
        em.getTransaction().begin();
        em.remove(filme);
        em.getTransaction().commit();
    }

    //sincroniza as alterações com o banco de dados
    public void update(Filme filme) {
        em.getTransaction().begin();
        em.merge(filme);
        em.getTransaction().commit();
    }
    
    // busca um filme pelo seu id
    public Filme buscar(int id){
        em.getTransaction().begin();
        Filme filme = em.find(Filme.class, id);
        em.getTransaction().commit();
        return filme;
    }

    //lista todos os filmes
    public List<Filme> listar() {
        String sql = "SELECT f FROM Filme f";
        TypedQuery<Filme> query = em.createQuery(sql, Filme.class);
        List<Filme> lista = query.getResultList();
        return lista;
    }

}
