import spark.Request;
import spark.Response;

public class DiscordApi {
    public static String redirect (Request request, Response response){

        System.out.println("redirect method inside DiscordApi was called");

        return "this is for OAuth2 after discord redirects the authorization?";
    }
}
