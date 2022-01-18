package TEST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class TestJSONParsing {

    private static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static void main(String[] args){
        String jsonString = "{\n" +
                "  \"payload\": {\n" +
                "    \"account_id\": \"<account_id>\",\n" +
                "    \"object\": {\n" +
                "      \"uuid\": \"<uuid>\",\n" +
                "      \"participant\": {\n" +
                "        \"user_id\": \"<user_id>\",\n" +
                "        \"user_name\": \"A Low\",\n" +
                "        \"participant_user_id\": \"<participant_user_id>\",\n" +
                "        \"id\": \"<id>\",\n" +
                "        \"join_time\": \"2022-01-09T03:21:20Z\",\n" +
                "        \"email\": \"<email>\"\n" +
                "      },\n" +
                "      \"id\": \"<id>\",\n" +
                "      \"type\": 4,\n" +
                "      \"topic\": \"A Low\\u0027s Personal Meeting Room\",\n" +
                "      \"host_id\": \"<host_id>\",\n" +
                "      \"duration\": 0,\n" +
                "      \"start_time\": \"2022-01-09T03:21:20Z\",\n" +
                "      \"timezone\": \"\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"event_ts\": 1641698482405,\n" +
                "  \"event\": \"meeting.participant_joined\"\n" +
                "}\n";
        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();
        System.out.println(gson.toJson(jsonElement));

        System.out.println("======================");

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

        System.out.println(username);


    }
}
