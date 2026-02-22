package org.application.main;

import org.application.model.Request;
import org.application.model.Student;
import org.application.model.Statistics;
import org.application.model.University;
import org.application.util.CollectionUtil;
import org.application.util.ExcelReader;
import org.application.util.JsonWriter;
import org.application.util.XmlWriter;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogManager;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            // Настройка логгера
            LogManager.getLogManager().readConfiguration(App.class.getResourceAsStream("/logging.properties"));

            // Читаем файлы
            List<Student> students = ExcelReader.readStudentsFromExcel("src/main/resources/universityInfo.xlsx");
            List<University> universities = ExcelReader.readUniversitiesFromExcel("src/main/resources/universityInfo.xlsx");

            // Обработка статистики
            CollectionUtil collectionUtil = new CollectionUtil();
            List<Statistics> statistics = collectionUtil.generateStatistics(students, universities);

            // Создание объекта Request
            Request request = new Request();
            request.setStudents(students);
            request.setUniversities(universities);
            request.setStatistics(statistics);

            // Генерация XML-файла
            XmlWriter xmlWriter = new XmlWriter();
            String xmlFilePath = "xmlReqs/req_" + System.currentTimeMillis() + ".xml";
            xmlWriter.writeToXml(request, xmlFilePath);

            // Генерация JSON-файла
            JsonWriter jsonWriter = new JsonWriter();
            String jsonFilePath = "jsonReqs/req_" + System.currentTimeMillis() + ".json";
            jsonWriter.writeToJson(request, jsonFilePath);

        } catch (IOException | JAXBException e) {
            logger.log(Level.SEVERE, "Ошибка при чтении/записи файла", e);
        }
    }

}
