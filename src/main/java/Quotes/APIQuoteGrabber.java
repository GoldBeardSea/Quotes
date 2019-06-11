package Quotes;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIQuoteGrabber {

    public static String getRonSwanson(String filePath) {
        try {
            URL url = new URL("http://ron-swanson-quotes.herokuapp.com/v2/quotes");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            Gson gson = new Gson();
            String[] swanString = gson.fromJson(reader, String[].class);
            Quote swansonQuote = new Quote(null, "Ron Swanson", "0 likes", swanString[0]);
            filewriterJSON(filePath, swansonQuote.getText());
            return String.format("%s - Ron Swanson", swansonQuote.getText());
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Printing Local Quote, connection error");
            return GSONQuoteGrabber.quoteGetter(filePath);
        }
    }

    public static boolean filewriterJSON(String filePath, String text) {
        JSONParser jsonParser = new JSONParser();

        try {
            Object fileObject = jsonParser.parse(new FileReader(filePath));
            JSONArray jsonQuoteArr = (JSONArray)fileObject;

            JSONObject quoteObj = new JSONObject();
            quoteObj.put("tags", "[]");
            quoteObj.put("author", "Ron Swanson");
            quoteObj.put("likes", "0 likes");
            quoteObj.put("text", text);

            jsonQuoteArr.add(quoteObj);


            FileWriter file = new FileWriter(filePath);
            file.write(jsonQuoteArr.toJSONString());
            file.flush();
            file.close();
            return true;

        } catch (ParseException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
