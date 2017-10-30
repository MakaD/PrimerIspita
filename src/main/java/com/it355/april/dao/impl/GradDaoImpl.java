/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.april.dao.impl;

import com.it355.april.entity.Grad;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.it355.april.dao.GradDao;

/**
 *
 * @author vasic
 */
@Repository("gradDao")
@Service
public class GradDaoImpl implements GradDao {

    @SuppressWarnings("unused")
    private final Log logger = LogFactory.getLog(getClass());

    //Instanciramo sesiju
    @Autowired
    private SessionFactory sessionFactory;

    //kreiramo seter za sesiju
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //kreiramo geter za sesiju
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Grad> getListaGradova() {
        return getSession().createCriteria(Grad.class).list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Grad dodajGrad(Grad grad) {
        return (Grad) getSession().merge(grad);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Grad getGradById(Integer id) {
        return (Grad) getSession().createCriteria(Grad.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Transactional
    @Override
    public boolean deleteGrad(Grad grad) {
        try {
            getSession().delete(grad);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
