package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenCreatingANewDog {
    private final LocalDateTime FOURTH_OF_JULY = LocalDateTime.of(2019,04,07,00,00);

    @Test
    public void it_should_have_a_name_breed_color_and_date_of_birth() {
        Dog fido = DogBreeder.aDog().called("Fido")
                .ofBreed("Labrador")
                .ofColor("black")
                .bornOn(FOURTH_OF_JULY);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("black", fido.getColor());
        Assert.assertEquals(FOURTH_OF_JULY, fido.getDateOfBirth());
    }

    @Test
    public void it_should_have_an_optional_favorite_food() {

        Dog fido = DogBreeder.aDog().called("Fido")
                .ofBreed("Labrador")
                .ofColor("black")
                .withFavoriteFood("pizza")
                .bornOn(FOURTH_OF_JULY);

        Assert.assertEquals("pizza", fido.getFavoriteFood());
    }

    @Test
    public void it_should_have_an_optional_favorite_toy() {

        Dog fido = DogBreeder.aDog().called("Fido")
                .ofBreed("Labrador")
                .ofColor("black")
                .withFavoriteToy("ball")
                .bornOn(FOURTH_OF_JULY);

        Assert.assertEquals("ball", fido.getFavoriteToy());
    }

    @Test
    public void it_should_be_created_as_a_small_dog() {

        Dog fido = DogBreeder.aSmallDog()
                .called("Fido")
                .ofColor("black")
                .withFavoriteToy("ball")
                .bornOn(FOURTH_OF_JULY);

        Assert.assertEquals("Poodle", fido.getBreed());
    }

    @Test
    public void it_should_be_created_as_a_big_dog() {

        Dog fido = DogBreeder.aBigDog()
                .called("Fido")
                .ofColor("black")
                .withFavoriteToy("ball")
                .bornOn(FOURTH_OF_JULY);

        Assert.assertEquals("Labrador", fido.getBreed());
    }

    @Test
    public void it_should_be_created_as_a_guard_dog() {

        Dog fido = DogBreeder.aGuardDog()
                .called("Fido")
                .ofColor("black")
                .withFavoriteToy("ball")
                .bornOn(FOURTH_OF_JULY);

        Assert.assertEquals("Mrr", fido.getBreed());
    }
}
