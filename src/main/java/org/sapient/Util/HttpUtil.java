package org.sapient.Util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.sapient.Entity.Country;
import org.sapient.Entity.DTO.StandingDTO;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class HttpUtil {

    public static StandingDTO getReponse(final String countryName, final String leagueName, final String teamName) throws IOException {
        Request request = new Request.Builder()
                .url("https://apiv2.apifootball.com/?action=get_standings&league_id=14&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978")
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response =call.execute();
        String responseBody = response.body().string();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<StandingDTO> standingDTOS = Arrays.asList(mapper.readValue(responseBody, StandingDTO[].class));

        for(StandingDTO k : standingDTOS) {
            if (k.getCountryName().equals(countryName) && k.getLeagueName().equals(leagueName)
                    && k.getTeamName().equals(teamName)) {
                return k;
            }
        }


        return null;
    }

    public static List<Country> getReponse() throws IOException {
        Request request = new Request.Builder()
                .url("https://apiv2.apifootball.com/?action=get_countries&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978")
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response =call.execute();
        //     System.out.println(" response "+response.body());
        String responseBody = response.body().string();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Country> countries = Arrays.asList(mapper.readValue(responseBody, Country[].class));

        return countries;
    }
}

