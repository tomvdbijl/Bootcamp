package examples;

import org.testng.annotations.Test;

public class CallEnumExampleTest {

    @Test
    public void printTheBootCampDays(){
        System.out.printf(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDays.DAYONE)+"\n");
        System.out.printf(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDays.DAYTWO)+"\n");
        System.out.printf(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDays.DAYTHREE)+"\n");
        System.out.printf(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDays.DAYFOUR)+"\n");
        System.out.printf(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDays.DAYFIVE));
    }
}
