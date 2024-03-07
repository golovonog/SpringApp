package main.com.java.springapp.service;

import java.util.List;
import main.com.java.springapp.model.Country;

public interface CountryService {

    List<Country> findByCode(int code);

    List<Country> findByName(String name);
}
