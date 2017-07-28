package examples;

public class Auto {

    public void setColor(String carColor) {
        System.out.println("The color of the car: " + carColor);
    }

    public void setBrand(String brandName){
        System.out.println("The brand of the car: " + brandName);
    }

    public void setAmountDoors(int amountDoors){
        System.out.println("The car has " + amountDoors + " doors.");
    }

    public void setEngineType(String engineType){
        System.out.println("The car has enginetype: " + engineType);
    }

    public void calculateTorque(int force, int engineRPMs){
        System.out.println("Torque of the car: " + (force * 5252)/engineRPMs);
    }
}
