package TEST;

import java.text.DateFormat;

import handlers.DiscordHandler;

public class TestSendMessage {
    public static void main(String[] args){
        DiscordHandler.startJDA();
        DiscordHandler.sendMessage(DateFormat.getDateTimeInstance().format(System.currentTimeMillis()));
        DiscordHandler.closeJDA();
    }
}
