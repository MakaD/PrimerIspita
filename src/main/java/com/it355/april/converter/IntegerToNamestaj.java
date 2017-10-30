package com.it355.april.converter;

import com.it355.april.dao.NamestajDao;
import com.it355.april.entity.Namestaj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class IntegerToNamestaj implements Converter<String , Namestaj> {

    @Autowired
    NamestajDao namestajDao;

    @Override
    public Namestaj convert(String  s) {
        if(s.isEmpty()){
            return null;
        }
        Integer valeu = Integer.valueOf(s);
        Namestaj cat = namestajDao.getNamestajById(valeu);
        return cat;
    }
}
