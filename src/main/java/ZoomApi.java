import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import spark.Request;
import spark.Response;

public class ZoomApi {
    private static Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

    public static String join(Request request, Response response){

        System.out.println("join from ZoomApi was called");

        System.out.println(request.body());
//
        String jsonString = request.body();
        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();
        System.out.println("===============================");
        System.out.println(gson.toJson(jsonElement));
        System.out.println("===============================");

        return "whatver useful info the event sub returns from join";
    }

    public static String leave(Request request, Response response){

        System.out.println("leave from ZoomApi was called");

        System.out.println(request.body());
//
        String jsonString = request.body();
        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();
        System.out.println("===============================");
        System.out.println(gson.toJson(jsonElement));
        System.out.println("===============================");

        return "this is infor returned in leave";
    }

    public static String joinAndLeave(Request request, Response response){

        System.out.println("joinAndLeave from ZoomApi was called");

        System.out.println(request.body());
//
        String jsonString = request.body();
        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();
        System.out.println("===============================");
        System.out.println(gson.toJson(jsonElement));
        System.out.println("===============================");

        return "info from join and leave at the same time";
    }
}
