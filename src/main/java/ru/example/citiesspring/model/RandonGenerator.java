package ru.example.citiesspring.model;

public class RandonGenerator {


    public int getRandom(int min, int max) {
        max -= min;
        return (int)(Math.random() * ++max) + min;
    }

    public Long getRandom(long min, long max) {
        max -= min;
        return (long)(Math.random() * ++max) + min;
    }
}