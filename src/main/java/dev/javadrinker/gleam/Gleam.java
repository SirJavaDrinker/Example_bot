package dev.javadrinker.gleam;

import dev.javadrinker.gleam.commands.AboutCommand;
import dev.javadrinker.gleam.commands.HelpCommand;
import dev.javadrinker.gleam.commands.TextCommandExecutor;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.Objects;

public class Gleam {
    private static final Dotenv config = Dotenv.configure().ignoreIfMissing().load();
    public static Dotenv getConfig = config;

    private static final String token = config.get("TOKEN");
    private static JDA jda;

    public static void main(String[] args) throws Exception {

        JDABuilder builder = JDABuilder.createDefault(token);
        jda = builder.setActivity(Activity.watching("the shine."))
                .addEventListeners(
                        new HelpCommand(),
                        new AboutCommand(),
                        new TextCommandExecutor()
                )
                .enableIntents(
                        GatewayIntent.MESSAGE_CONTENT,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.DIRECT_MESSAGES,
                        GatewayIntent.DIRECT_MESSAGES,
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.SCHEDULED_EVENTS
                )
                .build()
                .awaitReady();

        upsertCommands();
    }

    public static JDA getJDA() {
        return jda;
    }

    public static void upsertCommands() {
        jda.getGuilds();
        for (Guild guild : jda.getGuilds()) {
            if (guild != null) {
                System.out.println("Loading upserting commands for guild [" + guild.getId() + "].");
                Objects.requireNonNull(jda.getGuildById(guild.getId()).upsertCommand("help", "Get the command guide for this bot."))
                        .queue();
                Objects.requireNonNull(jda.getGuildById(guild.getId()).upsertCommand("about", "Get the information about this bot."))
                        .queue();
            } else {
                System.out.println("Guild ID was null!");
            }
        }
    }
}
