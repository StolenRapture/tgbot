package org.yourbro.services.botservice.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.yourbro.communication.MessageType;
import org.yourbro.services.botservice.BotService;

import java.util.HashMap;

public class YourBotService implements BotService {
    @Override
    public MessageType defineMessageType(final Message message) {
        MessageType messageType = MessageType.UNRECOGNIZED;

        if (message.isCommand()) {
            messageType = MessageType.COMMAND;
        }

        return messageType;
    }

}
