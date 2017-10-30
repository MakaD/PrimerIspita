package com.it355.april.dao.impl;

import com.it355.april.dao.NamestajDao;
import com.it355.april.entity.Namestaj;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("namestajDao")
@Service
public class NamestajDaoImpl implements NamestajDao{

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
    public List<Namestaj> getListaNamestaja() {
        return getSession().createCriteria(Namestaj.class).list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Namestaj dodajNamestaj(Namestaj namestaj) {
        return (Namestaj) getSession().merge(namestaj);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Namestaj getNamestajById(Integer id) {
        return (Namestaj) getSession().createCriteria(Namestaj.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Transactional
    @Override
    public boolean deleteNamestaj(Namestaj namestaj) {
        try {
            getSession().delete(namestaj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
