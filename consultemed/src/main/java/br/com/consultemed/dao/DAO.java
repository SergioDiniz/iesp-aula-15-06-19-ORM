package br.com.consultemed.dao;

import br.com.consultemed.utils.JPAUtils;
import com.sun.javafx.binding.StringFormatter;

import javax.persistence.EntityManager;
import java.util.List;

public class DAO<T> {

    private final Class<T> classe;

    private EntityManager manager = JPAUtils.getEntityManagerFactory().createEntityManager();

    public DAO(Class<T> classe) {
        this.classe = classe;
    }

    public EntityManager getManager() {
        return manager;
    }

    //add
    public void add(T t){
        manager.getTransaction().begin();
        manager.persist(t);
        manager.getTransaction().commit();
    }

    //remove
    public void remove(T t){
        manager.getTransaction().begin();
        manager.remove(t);
        manager.getTransaction().commit();
    }

    //update
    public void update(T t){
        manager.getTransaction().begin();
        manager.merge(t);
        manager.getTransaction().commit();
    }

    //listAll
    public List<T> listAll(Long id){
        String query = String.format("SELECT A FROM %s AS A", this.classe.getName());
        List<T> result = manager.createQuery(query).getResultList();

        return result;
    }

    //findById
    public T findById(Long id){
        T instance = manager.find(classe, id);
        return instance;
    }


}
