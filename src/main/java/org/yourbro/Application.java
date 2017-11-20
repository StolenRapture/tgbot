package org.yourbro;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
import org.yourbro.services.fileloader.FileLoaderService;

import java.io.IOException;
import java.util.Properties;


public final class Application {
    private static final String SPRING_CONFIG = "spring.xml";

    private BotService botService;
    private FileLoaderService<Properties> fileLoaderService;

    private Application() {
    }

    /**
     * Entry point.
     *
     * @param args input arguments
     */
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(SPRING_CONFIG);
        Application application = applicationContext.
                getBean(Application.class);

        ApiContextInitializer.init();

        final Properties botInitParameters = application.
                getFileLoaderService().loadFile(PropertiesPath.CORE_BOT);
        final BotModel bot = new BotModel();
        final Populator<Properties, BotModel> populator = new BotModelPopulator();
        populator.populate(botInitParameters, bot);

        try {
            registerBot(new YourBot(bot, application.getBotService()));
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    private static void registerBot(final AbstractBot bot) throws TelegramApiRequestException {
        final TelegramBotsApi botsApi = new TelegramBotsApi();
        botsApi.registerBot(bot);
    }

    public FileLoaderService<Properties> getFileLoaderService() {
        return fileLoaderService;
    }

    @Required
    public void setFileLoaderService(FileLoaderService<Properties> fileLoaderService) {
        this.fileLoaderService = fileLoaderService;
    }

    public BotService getBotService() {
        return botService;
    }

    @Required
    public void setBotService(BotService botService) {
        this.botService = botService;
    }
}
