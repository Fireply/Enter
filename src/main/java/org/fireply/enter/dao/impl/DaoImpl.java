package org.fireply.enter.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.fireply.enter.dao.Dao;
import org.fireply.enter.util.ClumnNameUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("rawtypes")       //  本类所有返回类型为 List 的方法返回的 List 都是调用  Hibernate 的方法后返回的
public class DaoImpl implements Dao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void persist(Object object) {
        sessionFactory.getCurrentSession().persist(object);
    }

    @Override
    public Serializable save(Object object) {
        return sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void delete(Object object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public Object merge(Object object) {
        return sessionFactory.getCurrentSession().merge(object);
    }

    @Override
    public Object get(Class<?> clazz, Serializable id) throws HibernateException {
        return sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Override
    public Object get(String modelName, Serializable id) {
        return sessionFactory.getCurrentSession().get(modelName, id);
    }

    @Override
    public List get(Class<?> clazz, String fieldName, Object fieldValue) {
        String hql = "from " + clazz.getSimpleName() + " where " + ClumnNameUtil.getClumnName(fieldName) + "='" + fieldValue + "'";
        return executeQuery(hql);
    }

    @Override
    public List get(String modelName, String fieldName, Object fieldValue) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List get(Class<?> clazz, Map<String, Object> fieldsMap) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> getAll(Class<?> clazz) {
        String hql = "from " + clazz.getSimpleName();
        return executeQuery(hql);
    }

    @Override
    public List<?> getAll(String modeName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List executeQuery(String hql) {
        return executeQuery(hql, -1, -1);
    }

    @Override
    public List executeQuery(String hql, int firstResult, int maxResults) {
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        if (firstResult >= 0 && maxResults >= 0) {
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResults);
        }
        List list = query.list();
        return list;
    }

    @Override
    public List executeSqlQuery(String sql) {
        executeSqlQuery(sql, -1, -1);
        return null;
    }

    @Override
    public List executeSqlQuery(String sql, int firstResult, int maxResults) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        if (firstResult >= 0 && maxResults >= 0) {
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResults);
        }
        return query.list();
    }

    @Override
    public List executeUpdate(String hql) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List executeUpdate(String hql, int firstResult, int maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List executeSqlUpdate(String sql) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List executeSqlUpdate(String sql, int firstResult, int maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

}
