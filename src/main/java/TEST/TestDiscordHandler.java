//package TEST;
//
//import net.dv8tion.jda.api.EmbedBuilder;
//import net.dv8tion.jda.api.JDA;
//import net.dv8tion.jda.api.entities.TextChannel;
//import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
//import net.dv8tion.jda.api.hooks.ListenerAdapter;
//
//public class TestDiscordHandler {
//    private static JDA jda = DiscordHandler.getJda();
//    private static final String CHANNEL_NAME = "zoom";
//    private static final TextChannel TEXT_CHANNEL = jda.getTextChannelsByName(CHANNEL_NAME, false).get(0);
//
//    public static void sendMessage(String message){
//
////        if(jda==null){
////            jda = handlers.DiscordHandler.jda;
////        }
//
//        System.out.println("Hello from inside sendMessage?");
//        System.out.println(jda);
//        TEXT_CHANNEL.sendMessage(message).queue();
//    }
//
//    public static void sendMessage(String message, String textChannel){
//
//    }
//
////    public static Test.DiscordHandlerTemp send(String strong){
////
////        return Test.DiscordHandlerTemp.class;
////    }
//}
//
//
//class EventListenerDupe extends ListenerAdapter {
//
//    @Override
//    public void onMessageReceived(MessageReceivedEvent event){
//        if(event.getAuthor().isBot()){
//            return;
//        }
//
//        ///////////////////////
//        ///////////////////////
//        ///////////////////////
//
//        exploration_onMessageReceived(event);
//
//        //////////////////////
//        //////////////////////
//        //////////////////////
//
//        if(event.getMessage().getContentRaw().equals("!zoom")){
//            EmbedBuilder info = new EmbedBuilder();
//            info.setTitle("375's Zoom meeting");
//            info.setDescription("<zoom_invite>");
////            info.addField("Online", "A Low", false);
//            info.addField("Online from dao.UserDao", UserDao.getInstance().getAll().toString(), false);
//            event.getChannel().sendMessageEmbeds(info.build()).queue();
//            info.clear();
//        }
//    }
//
//    private void exploration_onMessageReceived(MessageReceivedEvent event){
//        System.out.println("Message #" + DiscordHandler.counter.incrementAndGet() +
//                ": " + event.getMessage().getContentRaw() + " | " + event.getMessage().toString());
//
//        System.out.println("What is event member?: " + event.getMember());
//        System.out.println("What is event author?: " + event.getAuthor());
//        System.out.println("What is event author.avatarId?: " + event.getAuthor().getAvatarId());
//        System.out.println("What is event author.name?: " + event.getAuthor().getName());
////        System.out.println(event.getMember().deafen(handlers.DiscordHandler.deafen()));
////        System.out.println(Objects.requireNonNull(event.getGuild().getMember(event.getAuthor())).deafen(handlers.DiscordHandler.deafen()));
////        System.out.println(Objects.requireNonNull(event.getGuild().getMember(event.getAuthor())).deafen(handlers.DiscordHandler.deafen()));
//////        System.out.println(event.getMember().deafen(handlers.DiscordHandler.deafen()));
////        System.out.println("After trying to deafen!");
//        System.out.println(event.getMember().getOnlineStatus());
//        System.out.println("Online status but accessing guild");
//        System.out.println("What is event.getGuild()?: " + event.getGuild());
//
//        System.out.println("===================================");
//        System.out.println("Print out all memeber inside guild:");
////        List<Member> members = event.getGuild().getMembers();
//        event.getGuild().getMembers().stream()
//                .forEach(member -> System.out.println("User #" + DiscordHandler.counter.incrementAndGet() + ": " + member));
//        System.out.println("===================================");
//
//
//        System.out.println("What is event.getGuild().getMember?: " + event.getGuild().getMember(event.getAuthor()));
//        System.out.println("What is event.getGuild().getMember().getOnlineStatus()?: " + event.getGuild().getMember(event.getAuthor()).getOnlineStatus());
//        System.out.println(event.getMember().isOwner());
//
//        System.out.println("=================");
//        System.out. println("Trying to send a message back");
////        try {
////            wait(5000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        DiscordHandler.jda.getTextChannelsByName("general", true).get(0).sendMessage("This was " + event.getAuthor().getName() + "'s original message: ```" + event.getMessage().getContentRaw() + "```").queue();
//        System.out.println("=================");
//
////
//        System.out.println(event.getAuthor() + "; this was their original message: " + event.getAuthor().getId());
//
//
//    }
//
//}
//
//
//
