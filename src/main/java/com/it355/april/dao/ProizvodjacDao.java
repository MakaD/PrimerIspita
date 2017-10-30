package com.it355.april.dao;

import com.it355.april.entity.Proizvodjac;

import java.util.List;

public interface ProizvodjacDao {

    public List<Proizvodjac> getListaProizvodjaca();
    public Proizvodjac dodajProizvodjac(Proizvodjac proizvodjac);
    public Proizvodjac getProizvodjacById(Integer id);
    public boolean deleteProizvodjac(Proizvodjac proizvodjac);
}
