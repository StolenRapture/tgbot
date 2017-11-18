package org.yourbro.services.fileloader.impl;

import org.yourbro.services.fileloader.FileLoaderService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLoaderService implements FileLoaderService<Properties> {

    public Properties loadFile(final String path) throws IOException {
        Properties properties = new Properties();
        properties.load(getFileInputStream(path));
        return properties;
    }

    private FileInputStream getFileInputStream(final String path) throws FileNotFoundException {
        return new FileInputStream(loadFileFromResources(path));
    }

}
