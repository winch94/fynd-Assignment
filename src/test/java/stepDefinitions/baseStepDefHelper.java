package stepDefinitions;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.BeforeClass;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class baseStepDefHelper {

    public static Response response;
    public static String newName = "";
    public static String newSalary = "";
    public static String newAge = "";


    /* * employeeJSONModifier(String jsonParamType)
     * jsonParamType- valid, invalid, null
     * if valid puts all valid values in json
     * if invalid puts all invalid values in json
     * if null, puts empty string values in json
     */
    public static String employeeJSONModifier(String jsonParamType) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object o = parser.parse(new FileReader(System.getProperty("user.dir") + "/src/test/resources/payloadData/employee.json"));
        JSONObject json = (JSONObject) o;

        // if valid puts all valid values in json
        if (jsonParamType.equals("valid")) {
            newName = randomAlphabeticString(8);
            newSalary = randomInteger(5);
            newAge = randomInteger(2);
        }
        // if invalid puts all invalid values in json
        else if (jsonParamType.equals("invalid")) {
            newName = randomSplChar(5);
            newSalary = randomSplChar(5);
            newAge = randomSplChar(5);
        }
        // if null puts all empty string in json
        else if (jsonParamType.equals("null")) {
            newName = "";
            newSalary = "";
            newAge = "";
        }

        //puts all values to in the json
        json.put("name", newName);
        json.put("salary", newSalary);
        json.put("age", newAge);

        //returns json as string
        return json.toJSONString();
    }

    public static String randomAlphabeticString(int count) {
        //returns string of random alphabets
        return RandomStringUtils.randomAlphabetic(count);
    }

    public static String randomInteger(int count) {
        //returns string of random numbers
        return RandomStringUtils.randomNumeric(count);
    }

    public static String randomSplChar(int count) {
        //declare a string with all special chars
        String randomSplChar = "|[]{}~`@#%^&*";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(count);

        for (int i = 0; i < count; i++) {
            // generate a random number with special characters of variable length
            int index = (int) (randomSplChar.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(randomSplChar.charAt(index));
        }

        return sb.toString();
    }


}
