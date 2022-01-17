import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

import static net.dv8tion.jda.api.GatewayEncoding.JSON;

public class TestZoomJWT {

    //not to worry, this is a temporary api key and will be expired by the time you see it on GitHub
    private final static String API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6IjUyRUZURGZiUVFhTzNheURZWnU2cUEiLCJleHAiOjE2NDE3ODQzMjIsImlhdCI6MTY0MTY5NzkyNX0.L9FxxKnA1GaqX9QdWBp84OBPjS39020yeduApCqSX4w";
    /*
    curl --request GET \
  --url 'https://api.zoom.us/v2/users?status=active&page_size=30&page_number=1' \
  --header 'authorization: Bearer { eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6IjUyRUZURGZiUVFhTzNheURZWnU2cUEiLCJleHAiOjE2NDE1MjM2MjgsImlhdCI6MTY0MTUxODIyOH0.3c2PZYNDwmDyJ9otJ6tNquluz_m4AtXhgB3LCSr65n4 }' \
  --header 'content-type: application/json
     */

    /*
    curl --request GET \
  --url 'https://api.zoom.us/v2/users?status=active&page_size=30&page_number=1' \
  --header 'authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6IjUyRUZURGZiUVFhTzNheURZWnU2cUEiLCJleHAiOjE2NDE1MjM2MjgsImlhdCI6MTY0MTUxODIyOH0.3c2PZYNDwmDyJ9otJ6tNquluz_m4AtXhgB3LCSr65n4' \
  --header 'content-type: application/json
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("fsjlndjfnsdjk");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

//        String jsonString = "{\n" +
//                "       \"pageInfo\": {\n" +
//                "             \"pageName\": \"abc\",\n" +
//                "             \"pagePic\": \"http://example.com/content.jpg\"\n" +
//                "        },\n" +
//                "        \"posts\": [\n" +
//                "             {\n" +
//                "                  \"post_id\": \"123456789012_123456789012\",\n" +
//                "                  \"actor_id\": \"1234567890\",\n" +
//                "                  \"picOfPersonWhoPosted\": \"http://example.com/photo.jpg\",\n" +
//                "                  \"nameOfPersonWhoPosted\": \"Jane Doe\",\n" +
//                "                  \"message\": \"Sounds cool. Can't wait to see it!\",\n" +
//                "                  \"likesCount\": \"2\",\n" +
//                "                  \"comments\": [],\n" +
//                "                  \"timeOfPost\": \"1234567890\"\n" +
//                "             }\n" +
//                "        ]\n" +
//                "    }";
//        var ambiguous = null;
//        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
//        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();
//        System.out.println("========================");
//        System.out.println("Print as JsonObject:");
//        System.out.println(jsonObject);
//        System.out.println("========================");
//        System.out.println("Print as JsonElement:");
//        System.out.println(jsonElement);
//        System.out.println("========================");
//        System.out.println(gson.toJson(jsonObject));
//        System.out.println("========================");
//        System.out.println(gson.toJson(jsonElement));
//        JsonObject jsonObject = JsonParser.parseString("{\"name\": \"John\"}").getAsJsonObject();
//        System.out.println(jsonObject.get("name").getAsString());


        // create a client
        HttpClient client = HttpClient.newHttpClient();

// create a request
        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("https://api.zoom.us/v2/users?status=active&page_size=30&page_number=1"))
//                .header("accept", "application/json")
                .GET()
                .header("content-type", "application/json")
                .header("authorization", "Bearer " + API_KEY)
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString(Charset.defaultCharset()));

        System.out.println(response);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(gson.toJson(response.body()));
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");

        System.out.println(response.statusCode());
        String jsonString = response.body();
        JsonElement jsonElement = JsonParser.parseString(jsonString).getAsJsonObject();
        System.out.println(gson.toJson(jsonElement));



        //(String) response.body()

// use the client to send the request
//        var response = client.send(request, new JsonBodyHandler<>(APOD.class));

// the response:
//        System.out.println(response.body().get().title);


    }
}
