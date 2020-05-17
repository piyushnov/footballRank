package org.sapient.Entity;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
public class Standing {

    private String countryName;
    private String leagueId;
    private String leagueName;
    private String teamId;
    private String teamName;
    private String overallLeaguePosition;


}
