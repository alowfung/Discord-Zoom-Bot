import spark.Request;
import spark.Response;

public class ZoomApi {
//    private static JDA jda = TestMineplex.jda;
//    private static Gson gson = new GsonBuilder()
//                .setPrettyPrinting()
//                .create();

    public static String join(Request request, Response response){

        System.out.println("join from ZoomApi was called");

        //Parse username from incoming request's body
        String username = JsonHandler.extractUser(request.body());
        String time = JsonHandler.extractJoinTime(request.body());

        //Store username in dao
        UserDao.getInstance().put(username);

        // Next step: Update the status bar on the discord server

        String message = time + ": `" + username + "` has **joined** the meeting";
        System.out.println("Hello right before sendMessage?");
        DiscordHandlerTemp.sendMessage(message);

        return "whatver useful info the event sub returns from join";
    }

    public static String leave(Request request, Response response){

        System.out.println("leave from ZoomApi was called");

        String username = JsonHandler.extractUser(request.body());
        String time = JsonHandler.extractLeaveTime(request.body());
//
        UserDao.getInstance().delete(username);
//
        String message = time + ": `" + username + "` has **left** the meeting";
        DiscordHandlerTemp.sendMessage(message);

        return "this is infor returned in leave";
    }

    public static String joinAndLeave(Request request, Response response){

        System.out.println("joinAndLeave from ZoomApi was called");

        System.out.println("===============================");
        System.out.println(JsonHandler.prettify(request.body()));
        System.out.println("===============================");

        return "info from join and leave at the same time";
    }
}
