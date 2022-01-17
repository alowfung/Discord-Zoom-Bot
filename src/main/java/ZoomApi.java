import spark.Request;
import spark.Response;

public class ZoomApi {

    public static String join(Request request, Response response){
        System.out.println("join from ZoomApi was called");

        //Parse username from incoming request's body
        String username = JsonHandler.extractUser(request.body());
        String time = JsonHandler.extractTime(request.body());

        //Store username in dao
        UserDao.getInstance().put(username);

        // Next step: Send message on the discord server
        String message = time + ": `" + username + "` has **joined** the meeting";
        DiscordHandler.sendMessage(message);

        return "from join(); no real use";
    }

    public static String leave(Request request, Response response){
        System.out.println("leave from ZoomApi was called");

        String username = JsonHandler.extractUser(request.body());
        String time = JsonHandler.extractTime(request.body());

        UserDao.getInstance().delete(username);

        String message = time + ": `" + username + "` has **left** the meeting";
        DiscordHandler.sendMessage(message);

        return "from leave(); no real use";
    }
}
