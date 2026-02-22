package org.application.util;

import org.application.model.Request;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class JsonWriter {
    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    public void writeToJson(Request request, String filePath) throws IOException {
        // Создание директории
        Path directory = Paths.get(filePath).getParent();
        Files.createDirectories(directory);

        // Запись в файл
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            String json = JsonUtil.serializeRequest(request);
            fileOut.write(json.getBytes());
            logger.info("Файл " + filePath + " успешно создан.");
        }
    }
}