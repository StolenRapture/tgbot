package org.yourbro.bot;

import org.telegram.telegrambots.api.objects.Update;

public class YourBot extends AbstractBot{

    public YourBot(final BotModel bot) {
        super(bot);
    }

    @Override
    public void onUpdateReceived(final Update update) {
        //
    }

    @Override
    public String getBotUsername() {
        return super.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return super.getBotToken();
    }
}
