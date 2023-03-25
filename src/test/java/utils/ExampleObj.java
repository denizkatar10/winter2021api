package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class ExampleObj {

    //creat an Object Mapper Class object

    private static ObjectMapper mapper;

    static{
        mapper = new ObjectMapper();
    }

    //Create De-serialization Method
    public static <T> T convertJsonToJava(String json, Class<T> cls){

        T javaResult = null;

        try {
            javaResult = mapper.readValue(json,cls);
        } catch (IOException e) {
            System.out.println("Json couldn't not be converted to Java Object" + e.getMessage());;
        }

        return javaResult;

    }



}
