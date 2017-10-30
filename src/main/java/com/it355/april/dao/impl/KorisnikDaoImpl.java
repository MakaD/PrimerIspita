package com.it355.april.dao.impl;

import com.it355.april.dao.KorisnikDao;
import com.it355.april.entity.Korisnik;
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

@Repository("korisnikDao")
@Service
public class KorisnikDaoImpl implements KorisnikDao {

    @SuppressWarnings("unused")
    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Korisnik> getListaKorisnika() {
        return getSession().createCriteria(Korisnik.class).list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Korisnik dodajKorisnika(Korisnik korisnik) {
        return (Korisnik) getSession().merge(korisnik);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Korisnik getKorisnikById(Integer id) {
        return (Korisnik) getSession().createCriteria(Korisnik.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Transactional
    @Override
    public boolean deleteKorisnik(Korisnik korisnik) {
        try {
            getSession().delete(korisnik);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
