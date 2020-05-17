package org.example.simple.Util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.example.simple.Entity.Country;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CountryCache {

    LoadingCache<String, String> countryLoadingCache;
    @PostConstruct
    public void init() throws IOException {
        countryLoadingCache = CacheBuilder.newBuilder()
                .build(new CacheLoader<String, String>(){
                    @Override
                    public String load(final String s) throws Exception {
                        return null ;
                    }
                });
        populateCountryCache();
    }


    public void populateCountryCache() throws IOException {

        List<Country> countries=HttpUtil.getReponse();
        for(Country c :countries){
            countryLoadingCache.put(c.getCountryName(),c.getCountryId());
        }
    }

    public String getCountryId(String countryName) {
        try {
            return countryLoadingCache.get(countryName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
