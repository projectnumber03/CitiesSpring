package ru.example.citiesspring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.example.citiesspring.model.City;

import java.util.ArrayList;

public interface CityRepository extends CrudRepository<City, Long> {
    @Query("SELECT c FROM City c WHERE c.name like :name")
    ArrayList<City> findCityByLetter(@Param("name") String name);
}
