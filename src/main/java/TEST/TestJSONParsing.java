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
                "    \"account_id\": \"acrQrmZzTSOASwhRoam9ng\",\n" +
                "    \"object\": {\n" +
                "      \"uuid\": \"PWjKCvfwSdeog+RxsKNLjQ\\u003d\\u003d\",\n" +
                "      \"participant\": {\n" +
                "        \"user_id\": \"16778240\",\n" +
                "        \"user_name\": \"A Low\",\n" +
                "        \"participant_user_id\": \"BA6UOekTSd-7cUus1mFDWQ\",\n" +
                "        \"id\": \"BA6UOekTSd-7cUus1mFDWQ\",\n" +
                "        \"join_time\": \"2022-01-09T03:21:20Z\",\n" +
                "        \"email\": \"onlyformiscellaneouspurposes@gmail.com\"\n" +
                "      },\n" +
                "      \"id\": \"9341547700\",\n" +
                "      \"type\": 4,\n" +
                "      \"topic\": \"A Low\\u0027s Personal Meeting Room\",\n" +
                "      \"host_id\": \"BA6UOekTSd-7cUus1mFDWQ\",\n" +
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

        /*

        JsonElement jsonElement_1 = jsonElement
                .getAsJsonObject()
                .get("payload")
                .getAsJsonObject()
                .get("account_id");

        System.out.println("----");
        System.out.println(jsonElement_1.getAsString());
          // acrQrmZzTSOASwhRoam9ng
        System.out.println(jsonElement_1.toString());
          // "acrQrmZzTSOASwhRoam9ng"
//        System.out.println(jsonElement_1.getAsJsonObject());
          // Not a JSON Object: "acrQrmZzTSOASwhRoam9ng"
        System.out.println(jsonElement_1.deepCopy());
          // "acrQrmZzTSOASwhRoam9ng"
//        System.out.println(jsonElement_1.getAsJsonNull());
          // Not a JSON Null: "acrQrmZzTSOASwhRoam9ng"
//        System.out.println(jsonElement_1.getAsBigDecimal());
          // Character array is missing "e" notation exponential mark.
//        System.out.println(jsonElement_1.getAsBigInteger());
          // For input string: "acrQ"
        System.out.println(jsonElement_1.getAsBoolean());
          // false

//        System.out.println(jsonElement_1.getAsByte());
          // Exception in thread "main" java.lang.NumberFormatException: For input string: "acrQrmZzTSOASwhRoam9ng"

//        System.out.println(jsonElement_1.getAsJsonArray());
          // Exception in thread "main" java.lang.IllegalStateException: Not a JSON Array: "acrQrmZzTSOASwhRoam9ng"

        System.out.println(jsonElement_1.getAsJsonPrimitive());
          // "acrQrmZzTSOASwhRoam9ng"

        System.out.println(jsonElement_1.isJsonObject());
          // false

         */

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
