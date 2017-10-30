/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.april.dao;

import com.it355.april.entity.Grad;
import java.util.List;

/**
 *
 * @author vasic
 */
public interface GradDao {
    public List<Grad> getListaGradova();
    public Grad dodajGrad(Grad grad);
    public Grad getGradById(Integer id);
    public boolean deleteGrad(Grad grad);
}
