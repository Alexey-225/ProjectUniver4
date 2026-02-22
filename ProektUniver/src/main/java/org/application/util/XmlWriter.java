package org.application.util;

import org.application.model.Request;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class XmlWriter {
    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    public void writeToXml(Request request, String filePath) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Request.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Создание директории
        Path directory = Paths.get(filePath).getParent();
        Files.createDirectories(directory);

        // Запись в файл
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            marshaller.marshal(request, fileOut);
            logger.info("Файл " + filePath + " успешно создан.");
        }
    }
}