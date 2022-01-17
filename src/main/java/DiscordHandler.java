import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicInteger;

public class DiscordHandler {
    public static JDA jda;
    //debug
    public static AtomicInteger counter = new AtomicInteger(0);

    //Discord stuff
    //Replace "<token>" with your actual bot token (and remember to remove angle brackets afterwards)
    private static final String BOT_TOKEN = "OTIyNzAxNzIzMjg4NjMzNDE1.YcFS8Q.mR274gqixNOl67Ju8IrlCcSQXQY";

    //Zoom stuff
    private static final String DEFAULT_CHANNEL_NAME = "zoom";
    // private static final TextChannel TEXT_CHANNEL = jda.getTextChannelsByName(CHANNEL_NAME, false).get(0);

    public static JDA getJda(){
        if(jda == null){
            jda = createJDA();
            System.out.println("jda is being created for the first time, its value is: " + jda);
        }
        else{
            System.out.println("Oops, jda is not null, here is its value: " + jda);
        }
        return jda;
    }

    private static JDA createJDA(){
        try {
            jda = JDABuilder.createDefault(BOT_TOKEN)
                    .setMemberCachePolicy(MemberCachePolicy.ALL) //lazy loading
                    .setActivity(Activity.playing("バンドリ")) //literally the playing under each user
                    .enableIntents(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS) //allows to see stuff like online status
                    .enableCache(CacheFlag.ONLINE_STATUS) //aka keep info about if user's online
                    .addEventListeners(new EventListener()) //for instance, onMessageReceived
                    .build();
            jda.awaitReady();
        }
        catch (Exception exception){
            System.err.println(exception);
            System.err.println(exception.getClass());
        }

        return jda;
    }

    public static void startJDA(){
        System.out.println("Before instantiating the jda");

        jda = getJda();

        System.out.println("After instantiating the jda");
    }

    public static void closeJDA(){
        if(jda != null){
            System.out.println("jda is not null; shutting down...");
            jda.shutdown();
        }
        else{
            System.out.println("jda is null, so not calling shutdown");
        }
    }

    //Helper
    private static TextChannel getTextChannel(String textChannel){
        return jda.getTextChannelsByName(textChannel, false).get(0);
    }

    //Behaviors
    public static void sendMessage(String message){
        getTextChannel(DEFAULT_CHANNEL_NAME).sendMessage(message).queue();
    }

    public static void sendMessage(String message, String textChannel){
        getTextChannel(textChannel).sendMessage(message).queue();
    }
}

class EventListener extends ListenerAdapter {
    private static final String ZOOM_INVITE = "https://us05web.zoom.us/j/9341547700?pwd=R245RnhzZElpUXNBS2pRMnlMT0dMZz09";

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getAuthor().isBot()){
            return;
        }

        if(event.getMessage().getContentRaw().equals("!zoom")){
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("375's Zoom meeting");
            info.setDescription(ZOOM_INVITE);
            info.addField("Online from UserDao", UserDao.getInstance().getAll().toString(), false);
            event.getChannel().sendMessageEmbeds(info.build()).queue();
            info.clear();
        }
    }
}
