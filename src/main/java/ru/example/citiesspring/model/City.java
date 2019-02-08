package ru.example.citiesspring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name = "name")
    private String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLastTable(){
        switch (getLastLetter()){
            case 'э': return "c27";
            case 'ю': return "c28";
            case 'я': return "c29";
            default: return String.format("c%02d", ((int)getLastLetter() - 1071));
        }

    }

    public String getFirstTable(){
        char firstLetter = name.toLowerCase().charAt(0);
        switch (firstLetter){
            case 'э': return "c27";
            case 'ю': return "c28";
            case 'я': return "c29";
            default: return String.format("c%02d", ((int)firstLetter - 1071));
        }
    }

    public char getLastLetter() {
        char lastLetter = name.toLowerCase().charAt(name.toLowerCase().length() - 1);
        if(lastLetter == 'ъ' || lastLetter == 'ы' || lastLetter == 'ь'){
            return name.toLowerCase().charAt(name.toLowerCase().length() - 2);
        }
        return lastLetter;
    }

    public char getFirstLetter() {
        char firstLetter = name.toLowerCase().charAt(0);
        return firstLetter;
    }
}

