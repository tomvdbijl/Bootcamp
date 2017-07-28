package examples;

public class EnumExample {

    public enum BootCampDays {
        DAYONE,
        DAYTWO,
        DAYTHREE,
        DAYFOUR,
        DAYFIVE
    }

    public static String checkBootCampDaysInfo(BootCampDays bootCampDays) {

        switch (bootCampDays) {
            case DAYONE:
                return "Zin in!";

            case DAYTWO:
                return "Ik wil nog niet aan spijt denken!";

            case DAYTHREE:
                return "Het spijt is er!";

            case DAYFOUR:
                return "When does the pain stops!";

            case DAYFIVE:
                return "Pure torture!!!!";

            default:
                return "Weet je het zeker?";
        }
    }
}
