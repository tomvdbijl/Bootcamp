package API;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetExample {

    private String seasonParam;
    private String driverParam;

    @Test
    public void getCurrentF1Results(){
        given().
                when().get("http://ergast.com/api/f1/current/last/results").
                then().statusCode(200);
    }

    @Test
    public void checkValueInResponse() {
        given().
                when().get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").
                then().assertThat().body("MRData.RaceTable.driverId",equalTo("max_verstappen")); //containsString("verstappen"));
    }

    @Test
    public void testUrlParamMethode1() {
        seasonParam = "2016";
        driverParam = "max_verstappen";

        given().pathParam("season", seasonParam).
                pathParam("driver", driverParam).
                when().get("http://ergast.com/api/f1/{season}/drivers/{driver}/results.json").
                then().statusCode(200).
                and().assertThat().body("MRData.RaceTable.driverId",equalTo("max_verstappen")).
                and().assertThat().body("MRData.RaceTable.Races.Results.Driver.driverId",anything("max_verstappen"));
    }

    @Test
    public void testUrlParamMethode2() {
        seasonParam = "2016";
        driverParam = "max_verstappen";

        given().
        when().get("http://ergast.com/api/f1/" + seasonParam + "/drivers/" + driverParam + "/results.json").
        then().statusCode(200).
                and().assertThat().body("MRData.RaceTable.driverId",equalTo("max_verstappen")).
                and().assertThat().body("MRData.RaceTable.Races.Results.Driver.driverId",anything("max_verstappen"));
    }
}
