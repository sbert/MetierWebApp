package com.manpower.webapp.service;

import com.manpower.webapp.domain.FamillePro;
import com.manpower.webapp.domain.Metier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sbert on 23/06/2014.
 */
@Service
public class MetierService {

    @Value("${service.metier.url}")
    private String url;

    public List<Metier> findMetierByLibelle(String libelle) {
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(restTemplate.getForObject(url + "/metier/libelle/" + libelle, Metier[].class));
    }

    public List<Metier> findMetierByLibelleQualif(String libelle) {
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(restTemplate.getForObject(url + "/metier/qualif/libelle/" + libelle, Metier[].class));
    }

    public List<Metier> findMetierByCodeQualif(String code) {
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(restTemplate.getForObject(url + "/metier/qualif/code/" + code, Metier[].class));
    }

    public Metier findAppellationMetier(String codeMetier) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url + "/appellation/" + codeMetier, Metier.class);
    }

    public List<FamillePro> getFamillePro() {
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(restTemplate.getForObject(url + "/famille", FamillePro[].class));
    }

    public List<Metier> findAppellationMetier(List<String> codeMetiers) {
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(restTemplate.postForObject(url + "/appellation", codeMetiers, Metier[].class));
    }


}
