package main.com.java.springapp.repository;

import main.com.java.springapp.model.CountryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryInfoRepository extends JpaRepository<CountryInfo, Integer> {
    // Додаткові методи, якщо потрібно
}
