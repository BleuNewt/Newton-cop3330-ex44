/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Newton
 */
package ex44;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
public class ProductSearch
{
    public static void main( String[] args )
    {
        //need to add one external library
        //json-simple-1.1.1.jar
        //Create one json parser object
        JSONParser parser = new JSONParser();
        try
        {
            //read json file
            // using parser also store it in obj
            Object ob = parser.parse(new FileReader("D:/products.json"));
            //Create json object
            JSONObject jsonObject = (JSONObject)ob;
            //read products array from file
            JSONArray subjects = (JSONArray)jsonObject.get("products");
            //create buffered reader
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
            //Make string var
            String input;
            //Flag used
            int flag = 0;
            System.out.print("What is the product name? ");
            input = buffReader.readLine();
            //Create iterator array
            Iterator iterator = subjects.iterator();
            //Loop through iterator
            while (iterator.hasNext())
            {
                //Create another json
                JSONObject json = (JSONObject) iterator.next();
                //Get the name value
                String name = (String)json.get("name");

                //Compare with given input
                if(input.toLowerCase().equals(name.toLowerCase()))
                {
                    System.out.println("Name: "+name);
                    System.out.println("Price: "+json.get("price"));
                    System.out.println("Quantity: "+json.get("quantity"));
                    flag = 1;
                }
            }
            //If flag value is zero, then value not found
            if(flag == 0)
                System.out.println("Sorry, that product was not found in our inventory");
        }
            catch(Exception e) {e.printStackTrace();}
    }
}