package com.it355.april.rest;

import com.it355.april.dao.KorisnikDao;
import com.it355.april.entity.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class MainRestController {

    @Autowired
    KorisnikDao korisnikDao;

    @RequestMapping(value = "/korisnik/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> getKById(@PathVariable("id") int id) {
        Korisnik korisnik = korisnikDao.getKorisnikById(id);
        return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
    }

    @RequestMapping(value = "/korisnici", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Korisnik>> getAllK() {
        List<Korisnik> korisnici = korisnikDao.getListaKorisnika();
        return new ResponseEntity<List<Korisnik>>(korisnici, HttpStatus.OK);
    }

    @RequestMapping(value = "/korisnik", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> createK(@RequestBody Korisnik korisnik) {
        return new ResponseEntity<Korisnik>(korisnikDao.dodajKorisnika(korisnik), HttpStatus.OK);
    }

}
