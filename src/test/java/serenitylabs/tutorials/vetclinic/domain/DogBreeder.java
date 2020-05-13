package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class DogBreeder implements WithBreed, WithColor {

    private String name;
    private String breed;
    private String color;
    private String favoriteFood;
    private String favoriteToy;

    public static DogBreeder aSmallDog() {
        return aDog().ofBreed("Poodle");
    }

    public static DogBreeder aBigDog() {
        return aDog().ofBreed("Labrador");
    }

    public static DogBreeder aGuardDog() {
        return aDog().ofBreed("Mrr");
    }

    public DogBreeder called(String name) {
        this.name = name;
        return this;
    }

    public static DogBreeder aDog() {
            return new DogBreeder();
    }

    public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
    }

    public DogBreeder ofColor(String color) {
        this.color = color;
        return this;
    }

    public Dog bornOn(LocalDateTime birthday) {
        return new Dog(name, breed, birthday, color, favoriteFood, favoriteToy);
    }

    public DogBreeder withFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
        return this;
    }

    public DogBreeder withFavoriteToy(String favoriteToy) {
        this.favoriteToy = favoriteToy;
        return this;
    }
}
