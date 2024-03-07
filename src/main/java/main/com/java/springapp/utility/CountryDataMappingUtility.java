package main.com.java.springapp.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.PostConstruct;
import main.com.java.springapp.model.Country;
import main.com.java.springapp.model.CountryInfo;
import main.com.java.springapp.repository.CountryInfoRepository;
import main.com.java.springapp.repository.CountryRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CountryDataMappingUtility {

    private final RestTemplate restTemplate;
    private final CountryRepository countryRepository;
    private final CountryInfoRepository countryInfoRepository; // Додайте це поле
    
    @Autowired
    public CountryDataMappingUtility(RestTemplate restTemplate, CountryRepository countryRepository, CountryInfoRepository countryInfoRepository) {
        this.restTemplate = restTemplate;
        this.countryRepository = countryRepository;
        this.countryInfoRepository = countryInfoRepository; // Додайте цей конструктор
    }
    
//    @PostConstruct
    public void mapAndSaveCountryData() throws JSONException {
        try {
            // Отримання даних з API
            String apiUrl = "http://analityk1.com.ua:9111/api/reference/RiskCountries";
            String apiResponse = restTemplate.getForObject(apiUrl, String.class);

            // Розбір отриманих даних
            JSONArray countriesArray = new JSONArray(apiResponse);

            // Збереження в базу даних
            for (int i = 0; i < countriesArray.length(); i++) {
                 try{  
                    JSONObject countryJson = countriesArray.getJSONObject(i);
                    Country country = mapCountryFromJson(countryJson);
                    countryRepository.save(country);

                    // Перевірка, чи не є countryInfo рівним null
                    if (!countryJson.isNull("countryInfo")) {
                        CountryInfo countryInfo = mapCountryInfoFromJson(countryJson.getJSONObject("countryInfo"));
                        countryInfo.setCountry(country);
                        countryInfoRepository.save(countryInfo);
                    }

                 } catch (Exception e) {
                     System.out.println("!!!!!!!!!!!!!ERROR 1 countriesArray.getJSONObject(i)" + e.getMessage());
                }
            }
        
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!ERROR 2 " + e.getMessage());
        }
    }

    private Country mapCountryFromJson(JSONObject json) throws JSONException, JsonProcessingException {
        return new ObjectMapper().readValue(json.toString(), Country.class);
    }

    private CountryInfo mapCountryInfoFromJson(JSONObject json) throws JSONException, JsonProcessingException {
       return new ObjectMapper().readValue(json.toString(), CountryInfo.class);
    }

}
