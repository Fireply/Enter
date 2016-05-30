package org.fireply.enter.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public interface BaseService {

    void persist(Object object);

    Serializable save(Object object);

    void delete(Object object);

    Object merge(Object object);

    Object get(Class<?> clazz, Serializable id);

    Object get(String entityName, Serializable id);

    List<?> getAll(Class<?> clazz);
    
    List<?> getAll(String modeName);
    
    List<?> get(Class<?> clazz, String fieldName, Object fieldValue);
    
    List<?> get(String modelName, String fieldName, Object fieldValue);
    
    List<?> get(Class<?> clazz, Map<String, Object> fieldsMap);
    
}
