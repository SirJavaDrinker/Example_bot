package dev.javadrinker.gleam.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;

public class TextCommandExecutor extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String raw = e.getMessage().getContentRaw();
        Message msg = e.getMessage();
        if (scanFirst(">>say", raw)) {

            if (!raw.contains("/")) { return; }
            String[] split = raw.split("/");
            if (split.length<2 || split.length>3) {
                return;
            }

            if (split.length>2 && split[2].contains("del")) {
                msg.delete().queue();
                msg.getChannel().sendMessage(split[1]).queue();
            } else {
                msg.reply(split[1]).queue();
            }

        }
    }


    private static boolean scanFirst(String scanString, String inputString) {
        for (int i = 0; i<scanString.length(); i++) {
            if (inputString.charAt(i)!=scanString.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
