import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonHandler {
    private static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static String extractUser(String jsonString){

        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();
//        System.out.println(gson.toJson(jsonElement));

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

    public static String extractJoinTime(String jsonString){

        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();
//        System.out.println(gson.toJson(jsonElement));

        String time = jsonElement
                .getAsJsonObject()
                .get("payload")
                .getAsJsonObject()
                .get("object")
                .getAsJsonObject()
                .get("participant")
                .getAsJsonObject()
                .get("join_time")
                .getAsString();

        return time;
    }

    public static String extractLeaveTime(String jsonString){

        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();
//        System.out.println(gson.toJson(jsonElement));

        String time = jsonElement
                .getAsJsonObject()
                .get("payload")
                .getAsJsonObject()
                .get("object")
                .getAsJsonObject()
                .get("participant")
                .getAsJsonObject()
                .get("leave_time")
                .getAsString();

        return time;
    }

    public static String prettify(String jsonString){
        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();
        return gson.toJson(jsonElement);
    }
}
