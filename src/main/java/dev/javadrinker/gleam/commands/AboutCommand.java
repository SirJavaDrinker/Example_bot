package dev.javadrinker.gleam.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class AboutCommand  extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!event.getName().equalsIgnoreCase("about")) {
            return;
        }

        EmbedBuilder eb = new EmbedBuilder();
        eb.addField("Made for demonstration purposes.", "Lorem Ipsum", false);
        event.replyEmbeds(eb.build()).queue();
    }
}

