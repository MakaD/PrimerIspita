package com.it355.april.dao;

import com.it355.april.entity.Namestaj;

import java.util.List;

public interface NamestajDao {

    public List<Namestaj> getListaNamestaja();
    public Namestaj dodajNamestaj(Namestaj namestaj);
    public Namestaj getNamestajById(Integer id);
    public boolean deleteNamestaj(Namestaj namestaj);
}
