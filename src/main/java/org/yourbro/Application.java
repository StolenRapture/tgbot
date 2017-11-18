package org.yourbro;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.yourbro.bot.BotModel;
import org.yourbro.bot.YourBot;
import org.yourbro.constants.PropertiesPath;
import org.yourbro.populators.Populator;
import org.yourbro.populators.impl.BotModelPopulator;
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
     * @param args
     */
    public static void main(String[] args) throws IOException {
        ApiContextInitializer.init();
        final TelegramBotsApi botsApi = new TelegramBotsApi();

        final FileLoaderService<Properties> fileLoaderService = new PropertyFileLoaderService();
        final Properties botCoreParameters = fileLoaderService.loadFile(PropertiesPath.CORE_BOT);
        final BotModel bot = new BotModel();
        final Populator<Properties, BotModel> populator = new BotModelPopulator();
        populator.populate(botCoreParameters, bot);

        try {
            botsApi.registerBot(new YourBot(bot));
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }



    }
}
