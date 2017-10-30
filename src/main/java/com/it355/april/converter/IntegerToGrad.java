/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.april.converter;

import com.it355.april.entity.Grad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.it355.april.dao.GradDao;

/**
 *
 * @author vasic
 */
@Component
final class IntegerToGrad implements Converter<String , Grad> {

    @Autowired
    GradDao gradDao;

    @Override
    public Grad convert(String  s) {
        if(s.isEmpty()){
            return null;
        }
        Integer valeu = Integer.valueOf(s);
        Grad cat = gradDao.getGradById(valeu);
        return cat;
    }
}
