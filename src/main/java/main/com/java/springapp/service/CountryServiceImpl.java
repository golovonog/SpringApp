package main.com.java.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import main.com.java.springapp.model.Country;
import main.com.java.springapp.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;  // Репозиторій для доступ до данних

    @Override
    public List<Country> findByCode(int code) {
        return countryRepository.findByCode(code);
    }

    @Override
    public List<Country> findByName(String name) {
        return countryRepository.findByName(name);
    }
}
