package ru.example.citiesspring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.citiesspring.model.City;
import ru.example.citiesspring.model.RandonGenerator;
import ru.example.citiesspring.repository.CityRepository;

@Controller
@RequestMapping("/")
public class HomeController {

    private CityRepository cityRepository;
    private City current = new City((char)new RandonGenerator().getRandom(1072, 1103) + "");

    @Autowired
    public HomeController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public String getIndex(Model model){
        RandonGenerator rg = new RandonGenerator();
        int rndIndex = rg.getRandom(0,  cityRepository.findCityByLetter((current.getLastLetter() + "").toUpperCase() + "%").size() - 1);
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("citycount", cityRepository.count());
        model.addAttribute("newcity", new City());
        model.addAttribute("answer", cityRepository.findCityByLetter((current.getLastLetter() + "").toUpperCase() + "%").get(rndIndex).getName());
        return "index";
    }

    @PostMapping
    public String addCity(City city){
        current = city;
        return "redirect:/";
    }

}
