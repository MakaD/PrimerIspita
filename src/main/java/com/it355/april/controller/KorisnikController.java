package com.it355.april.controller;

import com.it355.april.dao.KorisnikDao;
import com.it355.april.entity.Korisnik;
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
public class KorisnikController {

    @Autowired
    KorisnikDao korisnikDao;

    @RequestMapping(value = "/add_korisnik", method = RequestMethod.GET)
    public String addKorisnik(Model model) {
        model.addAttribute("korisnik", new Korisnik());
        List korisnici = korisnikDao.getListaKorisnika();
        model.addAttribute("korisnici", korisnici);
        return "add_korisnik";
    }

    @RequestMapping(value = "/add_korisnik", method = RequestMethod.POST)
    public ModelAndView addKorisnikPost(@ModelAttribute("korisnik") Korisnik korisnik, ModelAndView model) {
        korisnik = korisnikDao.dodajKorisnika(korisnik);
        model.addObject("korisnici", korisnikDao.getListaKorisnika());
        model.addObject("successMsg", "Korisnik uspešno dodat");
        model.addObject("korisnik", new Korisnik());
        return model;
    }

    @RequestMapping(value = "/edit_korisnik/{id}", method = RequestMethod.GET)
    public String editKorisnik(@PathVariable("id") int id, Model model) {
        Korisnik korisnik = korisnikDao.getKorisnikById(id);
        model.addAttribute("korisnik", korisnik);
        List korisnici = korisnikDao.getListaKorisnika();
        model.addAttribute("korisnici", korisnici);
        return "add_korisnik";
    }

    @RequestMapping(value = "/delete_korisnik/{id}", method = RequestMethod.GET)
    public String deleteKorisnik(@PathVariable("id") int id, HttpServletRequest request) {
        Korisnik korisnik = korisnikDao.getKorisnikById(id);
        if (korisnik == null) {
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }
        korisnikDao.deleteKorisnik(korisnik);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
