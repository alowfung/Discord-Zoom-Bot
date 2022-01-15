import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TestMineplex {
    public static JDA jda;
    public static AtomicInteger counter = new AtomicInteger(0);
    public static boolean deafen = true;

    public static void main(String[] args){
        System.out.println("Before instantiating the jda");

        try {
            jda = JDABuilder.createDefault("OTIyNzAxNzIzMjg4NjMzNDE1.YcFS8Q.mR274gqixNOl67Ju8IrlCcSQXQY")
//                    .setActivity(Activity.playing("D4DJ グルミク"))

                    //Checking ONLINE status of members
//                    .setChunkingFilter(ChunkingFilter.ALL) //load members (and a whole lot more i'm assuming on startup)
                    /*
                    https://stackoverflow.com/questions/61226721/discord-jda-invalid-member-list
                    &
                    https://github.com/JDA-Applications/JDA-Utilities/issues/116

                    These two sites say that chunking need to be enabled in order to
                     */
                    .setMemberCachePolicy(MemberCachePolicy.ALL) //lazy loading

                    .setActivity(Activity.playing("バンドリ")) //literally the playing under each user
                    .enableIntents(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS) //allows to see stuff like online status
                    .enableCache(CacheFlag.ONLINE_STATUS)
                    .addEventListeners(new EventListener()) //
                    .build();
            jda.awaitReady();

//            System.out.println("What if I don't create the jda again? Does the one I created previous times still exist?");

        }
        catch (Exception exception){
            System.err.println(exception);
            System.err.println(exception.getClass());
        }

        System.out.println("After instantiating the jda");
    }

    public static boolean deafen(){
        deafen = !deafen;
        return !deafen;
    }
}

class EventListener extends ListenerAdapter implements Comparator<EventListener> {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getAuthor().isBot()){
            return;
        }

        ///////////////////////
        ///////////////////////
        ///////////////////////

        System.out.println("Message #" + TestMineplex.counter.incrementAndGet() +
                ": " + event.getMessage().getContentRaw() + " | " + event.getMessage().toString());

        System.out.println("What is event member?: " + event.getMember());
        System.out.println("What is event author?: " + event.getAuthor());
        System.out.println("What is event author.avatarId?: " + event.getAuthor().getAvatarId());
        System.out.println("What is event author.name?: " + event.getAuthor().getName());
//        System.out.println(event.getMember().deafen(TestMineplex.deafen()));
//        System.out.println(Objects.requireNonNull(event.getGuild().getMember(event.getAuthor())).deafen(TestMineplex.deafen()));
//        System.out.println(Objects.requireNonNull(event.getGuild().getMember(event.getAuthor())).deafen(TestMineplex.deafen()));
////        System.out.println(event.getMember().deafen(TestMineplex.deafen()));
//        System.out.println("After trying to deafen!");
        System.out.println(event.getMember().getOnlineStatus());
        System.out.println("Online status but accessing guild");
        System.out.println("What is event.getGuild()?: " + event.getGuild());

        System.out.println("===================================");
        System.out.println("Print out all memeber inside guild:");
//        List<Member> members = event.getGuild().getMembers();
        event.getGuild().getMembers().stream()
                        .forEach(member -> System.out.println("User #" + TestMineplex.counter.incrementAndGet() + ": " + member));
        System.out.println("===================================");


        System.out.println("What is event.getGuild().getMember?: " + event.getGuild().getMember(event.getAuthor()));
        System.out.println("What is event.getGuild().getMember().getOnlineStatus()?: " + event.getGuild().getMember(event.getAuthor()).getOnlineStatus());
        System.out.println(event.getMember().isOwner());

        System.out.println("=================");
        System.out. println("Trying to send a message back");
//        try {
//            wait(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        TestMineplex.jda.getTextChannelsByName("general", true).get(0).sendMessage("This was " + event.getAuthor().getName() + "'s original message: ```" + event.getMessage().getContentRaw() + "```").queue();
        System.out.println("=================");

//
        System.out.println(event.getAuthor() + "; this was their original message: " + event.getAuthor().getId());


        //////////////////////
        //////////////////////
        //////////////////////

        TestMineplex.jda.getTextChannelsByName("general", true).get(0);

//        EmbedBuilder info = new EmbedBuilder();
//        info.setTitle("375's Zoom meeting");
//        info.setDescription("https://sfsu.zoom.us/my/alowfung?pwd=ODZ5WjdnYmkreVY0SDJuRG8rTTZvQT09");
//        info.addField("Online", "A Low", false);
//        info.addField("Online from UserDao", UserDao.getInstance().getAll().toString(), false);

//        event.getChannel().sendMessageEmbeds(info.build()).queue();
//        info.clear();

        if(event.getMessage().getContentRaw().equals("!zoom")){
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("375's Zoom meeting");
            info.setDescription("https://sfsu.zoom.us/my/alowfung?pwd=ODZ5WjdnYmkreVY0SDJuRG8rTTZvQT09");
//            info.addField("Online", "A Low", false);
            info.addField("Online from UserDao", UserDao.getInstance().getAll().toString(), false);
            event.getChannel().sendMessageEmbeds(info.build()).queue();
            info.clear();
        }


    }

    @Override
    public int compare(EventListener o1, EventListener o2) {
        return 0;
    }
}
