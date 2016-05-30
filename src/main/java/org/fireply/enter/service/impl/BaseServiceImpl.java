package org.fireply.enter.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.fireply.enter.dao.Dao;
import org.fireply.enter.service.BaseService;
import org.hibernate.HibernateException;

@Service
@Transactional(readOnly=true)
public class BaseServiceImpl implements BaseService {

    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
    
    @Autowired
    @Qualifier("daoImpl")
    private Dao dao;

    @Override
    @Transactional
    public void persist(Object object) {
        if (object != null) {
            dao.persist(object);
//            logger.debug("persist {} successful", object);
        } else {
//            logger.error("persist failed, caused by: null object");
        }
    }

    @Override
    @Transactional
    public Serializable save(Object object) {
        Serializable result;
        if (object != null) {
            result = dao.save(object);
//            logger.debug("save successful");
        } else {
            result = null;
//            logger.error("save failed, caused by: null object");
        }
        return result;
    }

    @Override
    @Transactional
    public void delete(Object object) {
        if (object != null) {
            dao.delete(object);
//            logger.debug("delete successful");
        } else {
//            logger.error("delete failed. caused by: null object");
        }
    }

    @Override
    @Transactional
    public Object merge(Object object) {
        Object result;
        if (object != null) {
            result = dao.merge(object);
//            logger.debug("merge successful");
        } else {
            result = null;
//            logger.error("merge failded, caused by: null object");
        }
        return result;
    }

    @Override
    public Object get(Class<?> clazz, Serializable id) {
        Object result = null;
        if (clazz == null || id == null) {
            result = null;
//            logger.error("get entity failed, caused by: null in parameters");
        } else {
            try {
                result = dao.get(clazz, id);
            } catch (HibernateException e) {
                System.out.println("BaseService:get:");
                e.printStackTrace();
            }
//            logger.debug("get entity successful");
        }
        return result;
    }

    @Override
    public Object get(String entityName, Serializable id) {
        Object result;
        if (entityName == null || id == null) {
            result = null;
//            logger.error("get entity failed, caused by: null in parameters");
        } else {
            result = dao.get(entityName, id);
//            logger.debug("get entity successful");
        }
        return result;
    }

    @Override
    public List<?> getAll(Class<?> clazz) {
        if (clazz != null) {
            List<?> result = dao.getAll(clazz);
            logger.debug("获取所有 {} 实体成功", clazz.getSimpleName());
            return result;
        } else {
            logger.warn("获取所有实体失败，因为试图获取与 null 对应的实体");
            return null;
        }
    }

    @Override
    public List<?> getAll(String modeName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> get(Class<?> clazz, String fieldName, Object fieldValue) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> get(String modelName, String fieldName, Object fieldValue) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> get(Class<?> clazz, Map<String, Object> fieldsMap) {
        // TODO Auto-generated method stub
        return null;
    }

}
