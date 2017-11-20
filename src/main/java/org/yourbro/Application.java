package org.yourbro;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.yourbro.bot.AbstractBot;
import org.yourbro.bot.BotModel;
import org.yourbro.bot.YourBot;
import org.yourbro.constants.PropertiesPath;
import org.yourbro.populators.Populator;
import org.yourbro.populators.impl.BotModelPopulator;
import org.yourbro.services.botservice.BotService;
import org.yourbro.services.botservice.YourBotService;
import org.yourbro.services.fileloader.FileLoaderService;
import org.yourbro.services.fileloader.impl.PropertyFileLoaderService;

import java.io.IOException;
import java.util.Properties;


public class Application {
    private Application() {
    }

    /**
     * Entry point.
     *
     * @param args input arguments
     */
    public static void main(String[] args) throws IOException {
        ApiContextInitializer.init();

        final BotService botService = new YourBotService();
        final FileLoaderService<Properties> fileLoaderService = new PropertyFileLoaderService();
        final Properties botCoreParameters = fileLoaderService.loadFile(PropertiesPath.CORE_BOT);
        final BotModel bot = new BotModel();
        final Populator<Properties, BotModel> populator = new BotModelPopulator();
        populator.populate(botCoreParameters, bot);

        try {
            registerBot(new YourBot(bot, botService));
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    private static void registerBot(final AbstractBot bot) throws TelegramApiRequestException {
        final TelegramBotsApi botsApi = new TelegramBotsApi();
        botsApi.registerBot(bot);
    }
}
