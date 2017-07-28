package examples;

import org.testng.annotations.Test;

public class CarGames {

    @Test
    public void startGame() {
        Auto astra = new Auto();
        astra.setColor("Rood");
        astra.setBrand("Opel");
        astra.setAmountDoors(299);
        astra.setEngineType("V8 5.2 litre");
        astra.calculateTorque(250, 1500);

        Auto a4 = new Auto();
        a4.setColor("Paars");
        a4.setBrand("Audi");
        a4.setAmountDoors(3);
        a4.setEngineType("V10 8.5 litre");
        a4.calculateTorque(500,2000);
    }

    @Test
    public void startGameTwo(){
        AutoAdvanced autoAdvanced = new AutoAdvanced("Opel", 30, 5252);
        autoAdvanced.printBrand();
    }
}
