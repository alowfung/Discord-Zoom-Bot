import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.*;

public class Server {
    //used for debug purposes
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        DiscordHandler.startJDA();

        port(1234);

        path("/zoom", () -> {
//            before("/*", (req, res) -> {
//                System.out.println("**********");
//                System.out.println("This is request #" + atomicInteger.incrementAndGet() + "; Zoom event subscription triggered");
//                System.out.println(JsonHandler.prettify(req.body()));
//                System.out.println("**********");
//            });
            post("/join",  ZoomApi::join);
            post("/leave", ZoomApi::leave);

        });

        path("/discord", () -> {
//            before("/*", (req, res) -> System.out.println("This is request #" + atomicInteger.incrementAndGet() + "; Discord API was (in some way) called"));
            get("/redirect", DiscordApi::redirect);});

    }
}
