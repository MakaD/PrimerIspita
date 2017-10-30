/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.april.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.it355.april.entity.Grad;
import com.it355.april.dao.GradDao;

/**
 *
 * @author vasic
 */
@Controller
public class GradController {

    @Autowired
    GradDao gradDao;


    @RequestMapping(value = "/add_grad", method = RequestMethod.GET)
    public String addGrad(Model model) {
        model.addAttribute("grad", new Grad());
        List gradovi = gradDao.getListaGradova();
        model.addAttribute("gradovi", gradovi);
        return "add_grad";
    }

    @RequestMapping(value = "/add_grad", method = RequestMethod.POST)
    public ModelAndView addGrad(@ModelAttribute("grad") Grad grad, ModelAndView model) {
        grad = gradDao.dodajGrad(grad);
        model.addObject("gradovi", gradDao.getListaGradova());
        model.addObject("successMsg", "Grad uspešno dodat");
        model.addObject("grad", new Grad());
        return model;
    }

    @RequestMapping(value = "/edit_grad/{id}", method = RequestMethod.GET)
    public String editGrad(@PathVariable("id") int id, Model model) {
        Grad grad = gradDao.getGradById(id);
        model.addAttribute("grad", grad);
        model.addAttribute("gradovi", gradDao.getListaGradova());
        return "add_grad";
    }
 
    @RequestMapping(value = "/delete_grad/{id}", method = RequestMethod.GET)
    public String deleteGrad(@PathVariable("id") int id, HttpServletRequest request) {
        Grad grad = gradDao.getGradById(id);
        if (grad == null) {
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }
        gradDao.deleteGrad(grad);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
