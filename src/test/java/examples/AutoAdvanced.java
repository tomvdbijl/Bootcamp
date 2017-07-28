package examples;

public class AutoAdvanced {

    public String brand;

    public AutoAdvanced(String brand, int hp, int eRPM){
        this.brand = brand;

        System.out.println("Car is ready to drive");
        System.out.println("Brand of the car is " + brand);
        calculateTorque(hp, eRPM);
    }

    public void printBrand(){
        System.out.println(brand);
    }

    public void calculateTorque(int force, int engineRPMs){
        System.out.println("Torque of the car: " + (force * 5252)/engineRPMs);
    }
}
