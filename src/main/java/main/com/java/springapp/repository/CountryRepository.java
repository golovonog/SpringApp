package main.com.java.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import main.com.java.springapp.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("SELECT c FROM Country c WHERE c.code = :code")
    List<Country> findByCode(int code);

    @Query("SELECT c FROM Country c WHERE c.name = :name")
    List<Country> findByName(String name);
}
