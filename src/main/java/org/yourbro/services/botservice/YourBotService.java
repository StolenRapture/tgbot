package org.yourbro.services.botservice;

import org.telegram.telegrambots.api.objects.Message;
import org.yourbro.communication.MessageType;

public class YourBotService implements BotService{
    @Override
    public MessageType defineMessageType(final Message message) {
        MessageType messageType = MessageType.OTHER;

        if (message.isCommand()) {
            messageType = MessageType.COMMAND;
        }

        return messageType;
    }
}
