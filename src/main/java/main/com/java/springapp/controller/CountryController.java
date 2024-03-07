package main.com.java.springapp.controller;

import main.com.java.springapp.model.Country;
import main.com.java.springapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    
    @GetMapping("/{input}")
    public ResponseEntity<List<Country>> getByCodeOrName(@PathVariable String input) {
        
        List<Country> countries;

        try {
            // Спроба конвертувати введене значення в число
            int code = Integer.parseInt(input);
            countries = countryService.findByCode(code);
        } catch (NumberFormatException e) {
            // Якщо конвертація в числовий код не вдалася, то шукаємо за іменем
            countries = countryService.findByName(input);
        }

        if (countries.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(countries);
        }
    }

//    @GetMapping("/byCode/{code}")
//    public ResponseEntity<List<Country>> getByCode(@PathVariable int code) {
//        List<Country> countries = countryService.findByCode(code);
//        if (countries.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(countries);
//        }
//    }
//
//    @GetMapping("/byName/{name}")
//    public ResponseEntity<List<Country>> getByName(@PathVariable String name) {
//        List<Country> countries = countryService.findByName(name);
//        if (countries.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(countries);
//        }
//    }
}

