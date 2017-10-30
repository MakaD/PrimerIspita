package com.it355.april.dao;

import com.it355.april.entity.Korisnik;

import java.util.List;

public interface KorisnikDao {

    public List<Korisnik> getListaKorisnika();
    public Korisnik dodajKorisnika(Korisnik korisnik);
    public Korisnik getKorisnikById(Integer id);
    public boolean deleteKorisnik(Korisnik korisnik);

}
