package org.fireply.enter.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

public interface Dao {

    void persist(Object object);
    Serializable save(Object object);
    void delete(Object object);
    Object merge(Object object);
    
    Object get(Class<?> clazz, Serializable id);
    Object get(String modelName, Serializable id);
    List<?> getAll(Class<?> clazz);
    List<?> getAll(String modeName);
    
    List<?> get(Class<?> clazz, String fieldName, Object fieldValue);
    List<?> get(String modelName, String fieldName, Object fieldValue);
    List<?> get(Class<?> clazz, Map<String, Object> fieldsMap);
    
    List<?> executeQuery(String hql);
    List<?> executeQuery(String hql,int firstResult,int maxResults);
    List<?> executeSqlQuery(String sql);
    List<?> executeSqlQuery(String sql,int firstResult,int maxResults);
    
    List<?> executeUpdate(String hql);
    List<?> executeUpdate(String hql,int firstResult,int maxResults);
    List<?> executeSqlUpdate(String sql);
    List<?> executeSqlUpdate(String sql,int firstResult,int maxResults);
    
//    Object findById(String id);
//    List<?> findByExample(Object object);
    
}
