package dev.javadrinker.gleam.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class HelpCommand extends ListenerAdapter {
    private static final int pgAmount = 1;
    private static int pg = 1;
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!event.getName().equalsIgnoreCase("help")) {
            return;
        }

        EmbedBuilder eb = new EmbedBuilder().setTitle("Help page ["+pg+"/"+pgAmount+"]").addField("/Help", "The basic help command.", false).addField("/About", "Grab information about the bot.", false);
        event.replyEmbeds(eb.build()).queue();
    }
}
