import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.text.DateFormat;

public class JsonHandler {
    private static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static String extractUser(String jsonString){

        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();

        String username = jsonElement
                .getAsJsonObject()
                .get("payload")
                .getAsJsonObject()
                .get("object")
                .getAsJsonObject()
                .get("participant")
                .getAsJsonObject()
                .get("user_name")
                .getAsString();

        return username;
    }

    public static String extractTime(String jsonString){
        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();

        long time = jsonElement
                .getAsJsonObject()
                .get("event_ts")
                .getAsLong();

        return DateFormat.getDateTimeInstance().format(time);
    }

    //Helper
    public static String prettify(String jsonString){
        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();
        return gson.toJson(jsonElement);
    }
}
