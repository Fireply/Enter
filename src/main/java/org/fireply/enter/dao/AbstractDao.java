package org.fireply.enter.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractDao<ID extends Serializable, T> {

    private final Class<T> entityClass;

    @Autowired
    private SessionFactory sessionFactory;

    public AbstractDao() {
        
        /*this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];*/
        
        Type genericSuperclass = getClass().getGenericSuperclass();
        
        ParameterizedType parametrizedType = null;
        while (parametrizedType == null) {
            if ((genericSuperclass instanceof ParameterizedType)) {
                parametrizedType = (ParameterizedType) genericSuperclass;
            } else { 
                genericSuperclass = ((Class<?>) genericSuperclass).getGenericSuperclass();
            } 
        } 
     
        entityClass = (Class<T>) parametrizedType.getActualTypeArguments()[1];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public Serializable save(T entity) {
        return getSession().save(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public T merge(T entity) {
        return (T) getSession().merge(entity);
    }
    
    public T getById(ID id) {
        return (T) getSession().get(entityClass, id);
    }
   
    public List<T> getAll() {
        Criteria criteria = createEntityCriteria();
        return (List<T>) criteria.list();
    }
    
    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(entityClass);
    }

}
