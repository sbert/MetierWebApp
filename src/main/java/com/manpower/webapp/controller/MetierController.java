package com.manpower.webapp.controller;

import com.manpower.webapp.domain.FamillePro;
import com.manpower.webapp.domain.Metier;
import com.manpower.webapp.service.MetierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by sbert on 22/06/2014.
 */
@Controller
public class MetierController {

    @Autowired
    MetierService metierService;

    @RequestMapping("/")
    public String index(Model model) {
        return famille(model);
    }

    @RequestMapping("/famille")
    public String famille(Model model) {
        model.addAttribute("familles", metierService.getFamillePro());
        return "famille";
    }

    @RequestMapping(value = "/appellation")
    public String findAppellationMetier(@RequestParam(required = false) List<String> codeMetiers, Model model) {
        if( null != codeMetiers ) {
            model.addAttribute("metiers", metierService.findAppellationMetier(codeMetiers));
        }
        return "appellationMetier";
    }



}
