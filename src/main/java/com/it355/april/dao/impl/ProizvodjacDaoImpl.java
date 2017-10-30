package com.it355.april.dao.impl;

import com.it355.april.dao.ProizvodjacDao;
import com.it355.april.entity.Proizvodjac;
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

@Repository("proizvodjacDao")
@Service
public class ProizvodjacDaoImpl implements ProizvodjacDao{

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
    public List<Proizvodjac> getListaProizvodjaca() {
        return getSession().createCriteria(Proizvodjac.class).list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Proizvodjac dodajProizvodjac(Proizvodjac proizvodjac) {
        return (Proizvodjac) getSession().merge(proizvodjac);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Proizvodjac getProizvodjacById(Integer id) {
        return (Proizvodjac) getSession().createCriteria(Proizvodjac.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Transactional
    @Override
    public boolean deleteProizvodjac(Proizvodjac proizvodjac) {
        try {
            getSession().delete(proizvodjac);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
