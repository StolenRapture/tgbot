package org.yourbro.populators.impl;

import org.yourbro.bot.BotConstants;
import org.yourbro.bot.BotModel;
import org.yourbro.populators.Populator;

import java.util.Properties;

public class BotModelPopulator implements Populator<Properties, BotModel> {
    @Override
    public void populate(Properties properties, BotModel botModel) {
        botModel.setUserName(properties.getProperty(BotConstants.USERNAME));
        botModel.setToken(properties.getProperty(BotConstants.TOKEN));
    }
}
