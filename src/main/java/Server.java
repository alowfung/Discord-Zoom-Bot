import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.*;

public class Server {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        port(1234);

        get("/hello", (req, res) -> "asd");


        path("/zoom", () -> {
            before("/*", (req, res) -> System.out.println("This is request #" + atomicInteger.incrementAndGet() + "; event subscription triggered"));
            post("/join",  ZoomApi::join);
            post("/leave", ZoomApi::leave);
//            post("/join-and-leave", ZoomApi::joinAndLeave);

        });
    }
}
