package generator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nikolaj
 */
public class DataGenerator {
    
    private static final String[] firstNames = new String[]{"Lars","Morten","Peter","Jan"};
    
    private static final String[] lastNames = new String[]{"Hansen","Larsen","Brünner","Petersen"};
    
    private static final String[] streets = new String[]{"Tuborgvej","Larsensvej","Langevej","Lyngbyvej"};
    
    private static final String[] cities = new String[]{"Lyngby","Sogenfri","København","Hellerup"};
    
    private static final Random rand = new Random();
    
    private static final Map<String,Supplier<String>> propertiesMapper = new HashMap<>();
    
    static {
        propertiesMapper.put("fname", () -> firstNames[rand.nextInt(firstNames.length)]);
        propertiesMapper.put("lname", () -> lastNames[rand.nextInt(lastNames.length)]);
        propertiesMapper.put("street", () -> streets[rand.nextInt(streets.length)]);
        propertiesMapper.put("city", () -> cities[rand.nextInt(cities.length)]);
    }
    
    public static String getData(int count, String properties) {
        String[] propSplit = properties.split(",");
        JsonArray jArray = new JsonArray();
        
        for (int i = 0; i < count; i++) {
            JsonObject json = new JsonObject();
            for (int j = 0; j < propSplit.length; j++) {
                String currentProperty = propSplit[j];
                json.addProperty(currentProperty, propertiesMapper.get(currentProperty).get());
            }
            jArray.add(json);
        }
        return jArray.toString();
    }
}
