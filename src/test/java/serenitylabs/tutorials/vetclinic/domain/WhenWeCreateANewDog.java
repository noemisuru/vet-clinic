package serenitylabs.tutorials.vetclinic.domain;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WhenWeCreateANewDog {

    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
//        Assert.assertEquals("Black", fido.getColours());
    }

    @Test
    public void a_dog_should_be_printed_in_a_readable_form() {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertThat(fido.toString(),is(equalToIgnoringCase("Fido the Black labrador")));

        assertThat(fido.toString(), startsWith("Fido"));
        assertThat(fido.toString(), endsWith("labrador"));
        assertThat(fido.toString(), containsString("black"));
    }

    @Test
    public void a_dog_can_have_several_colours() {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black", "White");

        assertThat(fido.getColours(), contains("Black","White"));
        assertThat(fido.getColours(), hasItem("Black"));
        assertThat(fido.getColours(), not(hasItem("Red")));
    }
}
