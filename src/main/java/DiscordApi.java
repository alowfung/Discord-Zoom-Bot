import spark.Request;
import spark.Response;

public class DiscordApi {
    //This does nothing for now
    //Intended for redirect from Discord after OAuth2
    public static String redirect (Request request, Response response){

        System.out.println("redirect method inside DiscordApi was called");

        return "from redirect(); response is ignored";
    }
}
