import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.*;

public class Server {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        //////////////////////////
        ////////////////
        //////////////////////////
        TestMineplex.mainToBeCalled();
        DiscordHandlerTemp.sendMessage("Hello try this");

        port(1234);

        get("/hello", (req, res) -> "asd");


        path("/zoom", () -> {
            before("/*", (req, res) -> {
                System.out.println("**********");
                System.out.println("This is request #" + atomicInteger.incrementAndGet() + "; Zoom event subscription triggered");
                System.out.println(JsonHandler.prettify(req.body()));
                System.out.println("**********");
            });
            post("/join",  ZoomApi::join);
            post("/leave", ZoomApi::leave);
//            post("/join-and-leave", ZoomApi::joinAndLeave);

        });

        path("/discord", () -> {
            before("/*", (req, res) -> System.out.println("This is request #" + atomicInteger.incrementAndGet() + "; Discord API was (in some way) called"));
            before("/redirect", (req, res) -> System.out.println("The method's request for /discord/redirect is: " + req.requestMethod()));
            get("/redirect", DiscordApi::redirect);});
    }
}
