package org.example.simple.controller;


import org.example.simple.Entity.DTO.StandingDTO;
import org.example.simple.Entity.Standing;
import org.example.simple.Util.CountryCache;
import org.example.simple.Util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api/")
public class RestController {

    @Autowired
    CountryCache countryCache;

    @RequestMapping(value = "/v1", method = RequestMethod.GET)
    public StandingDTO getResponse(@RequestParam("country_name") String countryName, @RequestParam("league_name") String leagueName,
                                   @RequestParam("team_name") String teamName) {

        try {
            StandingDTO standingDTO= HttpUtil.getReponse(countryName, leagueName,teamName);
            standingDTO.setCountryId(countryCache.getCountryId(standingDTO.getCountryName()));
            return  standingDTO;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
