package examples;

import org.testng.annotations.Test;

public class ConditionExercises {


    public String bootcampAgeChecker(int age){
        String melding= null;

        if (age < 21){
            melding = "deelnemer is te jong!";
        }else if(age >= 21 && age < 65) {
            melding = "deelnemer toegelaten.";
        }else if(age >= 65) {
            melding = "overleg met manager";
        }

        return melding;
    }

    @Test
    public void testMember(){
        System.out.println(bootcampAgeChecker(19));
        System.out.println(bootcampAgeChecker(21));
        System.out.println(bootcampAgeChecker(25));
        System.out.println(bootcampAgeChecker(64));
        System.out.println(bootcampAgeChecker(65));
    }
}
