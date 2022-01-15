import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class DiscordHandlerTemp {
    private static JDA jda = TestMineplex.getJda();
    private static final String CHANNEL_NAME = "zoom";
    private static final TextChannel TEXT_CHANNEL = jda.getTextChannelsByName(CHANNEL_NAME, false).get(0);

    private class JDAHandler{

    }

    public static void sendMessage(String message){

//        if(jda==null){
//            jda = TestMineplex.jda;
//        }

        System.out.println("Hello from inside sendMessage?");
        System.out.println(jda);
        TEXT_CHANNEL.sendMessage(message).queue();
    }

    public static void sendMessage(String message, String channel){

    }

//    public static DiscordHandlerTemp send(String strong){
//
//        return DiscordHandlerTemp.class;
//    }
}
