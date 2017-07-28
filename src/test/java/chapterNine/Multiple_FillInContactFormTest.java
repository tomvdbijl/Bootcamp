package chapterNine;

import General.SetUpTearDown;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class Multiple_FillInContactFormTest extends SetUpTearDown{

    private final static String DATASOURCE_FILE_NAME = "bootcampData.csv";
    private final static String DATASOURCE_FILE_PATH = "/src/main/java/resources/";

    @Test
    public void multipleFillsContactForm(){
        File dataSource = new File(DATASOURCE_FILE_PATH + DATASOURCE_FILE_NAME);
        if(dataSource.exists()){
            System.out.println("datasource is niet bescikbaar");

        }
        InputStream inputStream = getClass().getResourceAsStream(DATASOURCE_FILE_PATH + DATASOURCE_FILE_NAME);
        try {
            inputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
