import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;


public class GamesByAge {

    //1. Arrange
    public class Students {

        private int age;
        private String name;
        private String gender;
        
    }
    ObjectMapper objectMapper = new ObjectMapper();
    InputStream is = Test.class.getResourceAsStream("/Users/krishna/Etiquette/src/test/java/students.json");

    String jsonCarArray =
            "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
    List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});

    for(int i=0; i<arraysize; i++){
        if(array[i]==18 or array[i]<=20)
            add to new array
    }

    for(int i=0; i<arraysize; i++){
        if(array[i]==21 or array[i]<=23)
        add to new array
    }

    for(int i=0; i<arraysize; i++){
        if(array[i]==24 or array[i]<=25)
        add to new array
    }

    sout(print array)

        // Need to assert but what should be the assertion

}

