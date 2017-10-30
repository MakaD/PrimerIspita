package com.it355.april.controller;

import com.it355.april.dao.GradDao;
import com.it355.april.dao.ProizvodjacDao;
import com.it355.april.entity.Proizvodjac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProizvodjacController {

    @Autowired
    ProizvodjacDao proizvodjacDao;

    @Autowired
    GradDao gradDao;


    @RequestMapping(value = "/add_proizvodjac", method = RequestMethod.GET)
    public String addProizvodjac(Model model) {
        model.addAttribute("proizvodjac", new Proizvodjac());
        List proizvodjaci = proizvodjacDao.getListaProizvodjaca();
        model.addAttribute("proizvodjaci", proizvodjaci);
        List gradovi = gradDao.getListaGradova();
        model.addAttribute("gradovi", gradovi);
        return "add_proizvodjac";
    }

    @RequestMapping(value = "/add_proizvodjac", method = RequestMethod.POST)
    public ModelAndView addProizvodjac(@ModelAttribute("proizvodjac") Proizvodjac proizvodjac, ModelAndView model) {
        proizvodjac = proizvodjacDao.dodajProizvodjac(proizvodjac);
        model.addObject("proizvodjaci", proizvodjacDao.getListaProizvodjaca());
        model.addObject("successMsg", "Proizvodjac uspešno dodat");
        model.addObject("gradovi", gradDao.getListaGradova());
        model.addObject("proizvodjac", new Proizvodjac());
        return model;
    }

    @RequestMapping(value = "/edit_proizvodjac/{id}", method = RequestMethod.GET)
    public String editProizvodjac(@PathVariable("id") int id, Model model) {
        Proizvodjac proizvodjac = proizvodjacDao.getProizvodjacById(id);
        model.addAttribute("proizvodjac", proizvodjac);
        model.addAttribute("proizvodjaci", proizvodjacDao.getListaProizvodjaca());
        model.addAttribute("gradovi", gradDao.getListaGradova());
        return "add_proizvodjac";
    }



    @RequestMapping(value = "/delete_proizvodjac/{id}", method = RequestMethod.GET)
    public String deleteProizvodjac(@PathVariable("id") int id, HttpServletRequest request) {
        Proizvodjac proizvodjac = proizvodjacDao.getProizvodjacById(id);
        if (proizvodjac == null) {
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }
        proizvodjacDao.deleteProizvodjac(proizvodjac);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}


