package org.yourbro;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.yourbro.bot.YourBot;

public class Application {
    private Application() {
    }

    /**
     * Entry point.
     *
     * @param args
     */
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new YourBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
