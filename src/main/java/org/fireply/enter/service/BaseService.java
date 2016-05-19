package org.fireply.enter.service;

import java.io.Serializable;

public interface BaseService {

    void persist(Object object);

    Serializable save(Object object);

    void delete(Object object);

    Object merge(Object object);

    Object get(Class<?> clazz, Serializable id);

    Object get(String entityName, Serializable id);

}
