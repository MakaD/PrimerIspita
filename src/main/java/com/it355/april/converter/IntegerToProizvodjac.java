package com.it355.april.converter;

import com.it355.april.dao.ProizvodjacDao;
import com.it355.april.entity.Proizvodjac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class IntegerToProizvodjac implements Converter<String , Proizvodjac> {

    @Autowired
    ProizvodjacDao proizvodjacDao;

    @Override
    public Proizvodjac convert(String  s) {
        if(s.isEmpty()){
            return null;
        }
        Integer valeu = Integer.valueOf(s);
        Proizvodjac cat = proizvodjacDao.getProizvodjacById(valeu);
        return cat;
    }
}
