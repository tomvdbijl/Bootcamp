package examples;

import org.testng.annotations.Test;

public class AboutMethods {

    @Test
    public void printProduct(){
        System.out.println(multiply(25, 50));
    }

    private int multiply(int eersteWaarde, int tweedeWaarde) {
        return eersteWaarde * tweedeWaarde;
    }
}
