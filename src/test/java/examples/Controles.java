package examples;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Controles {

    @Test
    private void tekstCheck(){
        String teksten = "De bootcamp is FANTASTISCH";
        Assertions.assertThat(teksten).as("Fantastisch komt voor!").doesNotContain("FANTASTISCH");
    }

    @Test
    private void booleanCheck(){
        boolean isWaar = false;
        Assertions.assertThat(isWaar).as("Foutje bedankt").isTrue();
    }

    @Test
    private void getalCheck(){
        int getal1 = 1;
        int getal2 = 2;
        Assertions.assertThat(getal1).as("Getal1 is niet groter dan getal2").isGreaterThan(getal2);
    }

}
