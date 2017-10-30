package com.it355.april.controller;

import com.it355.april.dao.KorisnikDao;
import com.it355.april.dao.NamestajDao;
import com.it355.april.dao.ProizvodjacDao;
import com.it355.april.entity.Namestaj;
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
public class NamestajController {

    @Autowired
    NamestajDao namestajDao;

    @Autowired
    ProizvodjacDao proizvodjacDao;

    @Autowired
    KorisnikDao korisnikDao;

    @RequestMapping(value = "/add_namestaj", method = RequestMethod.GET)
    public String addNamestaj(Model model) {
        model.addAttribute("namestaj", new Namestaj());
        List namestaji = namestajDao.getListaNamestaja();
        model.addAttribute("namestaji", namestaji);
        List proizvodjaci = proizvodjacDao.getListaProizvodjaca();
        model.addAttribute("proizvodjaci", proizvodjaci);
        List korisnici = korisnikDao.getListaKorisnika();
        model.addAttribute("korisnici", korisnici);
        return "add_namestaj";
    }

    @RequestMapping(value = "/add_namestaj", method = RequestMethod.POST)
    public ModelAndView addNamestaj(@ModelAttribute("namestaj") Namestaj namestaj, ModelAndView model) {
        namestaj = namestajDao.dodajNamestaj(namestaj);
        model.addObject("namestaji", namestajDao.getListaNamestaja());
        model.addObject("successMsg", "Namestaj uspešno dodat");
        model.addObject("proizvodjaci", proizvodjacDao.getListaProizvodjaca());
        model.addObject("korisnici", korisnikDao.getListaKorisnika());
        model.addObject("namestaj", new Namestaj());
        return model;
    }

    @RequestMapping(value = "/edit_namestaj/{id}", method = RequestMethod.GET)
    public String editProizvodjac(@PathVariable("id") int id, Model model) {
        Namestaj namestaj = namestajDao.getNamestajById(id);
        model.addAttribute("namestaj", namestaj);
        model.addAttribute("namestaji", namestajDao.getListaNamestaja());
        model.addAttribute("proizvodjaci", proizvodjacDao.getListaProizvodjaca());
        model.addAttribute("korisnici", korisnikDao.getListaKorisnika());
        return "add_namestaj";
    }



    @RequestMapping(value = "/delete_namestaj/{id}", method = RequestMethod.GET)
    public String deleteProizvodjac(@PathVariable("id") int id, HttpServletRequest request) {
        Namestaj namestaj = namestajDao.getNamestajById(id);
        if (namestaj == null) {
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }
        namestajDao.deleteNamestaj(namestaj);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

}
