package serenitylabs.tutorials.vetclinic.domain;
import java.time.LocalDateTime;

public class Dog {

    private final String name;
    private final String breed;
    private final LocalDateTime dateOfBirth;
    private final String favoriteFood;
    private final String favoriteToy;
    private final String color;

    public Dog(String name, String breed, LocalDateTime dateOfBirth, String color, String favoriteFood, String favoriteToy) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.color = color;
        this.favoriteFood = favoriteFood;
        this.favoriteToy = favoriteToy;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public String getColor() {
        return color;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getFavoriteToy() {
        return favoriteToy;
    }
}
