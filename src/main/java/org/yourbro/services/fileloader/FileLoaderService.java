package org.yourbro.services.fileloader;

import java.io.File;
import java.io.IOException;

public interface FileLoaderService<T> {
    T loadFile (String path) throws IOException;

    default File loadFileFromResources(final String path) {
        final ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return new File(classLoader.getResource(path).getFile());
    }
}
