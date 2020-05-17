package org.sapient.controller;


import org.sapient.Entity.DTO.StandingDTO;
import org.sapient.service.CountryCache;
import org.sapient.Util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api/v1")
public class RestController {

    @Autowired
    CountryCache countryCache;

    @RequestMapping(value = "/getStanding", method = RequestMethod.GET)
    public StandingDTO getResponse(@RequestParam("country_name") String countryName, @RequestParam("league_name") String leagueName,
                                   @RequestParam("team_name") String teamName) {

        try {
            StandingDTO standingDTO= HttpUtil.getReponse(countryName, leagueName,teamName);
            if(standingDTO!=null) {
                standingDTO.setCountryId(countryCache.getCountryId(standingDTO.getCountryName()));
                return standingDTO;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
