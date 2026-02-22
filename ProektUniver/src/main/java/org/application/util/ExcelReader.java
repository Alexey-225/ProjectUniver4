package org.application.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.application.model.Student;
import org.application.model.University;
import org.application.model.StudyProfile;

import java.util.logging.Logger;

public class ExcelReader {
    private static final Logger logger = Logger.getLogger(ExcelReader.class.getName());

    public static List<Student> readStudentsFromExcel(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // Предполагаем, что студенты находятся на первом листе

            List<Student> students = new ArrayList<>();
            for (Row row : sheet) {
                if (row.getRowNum() > 0) { // Пропускаем заголовочную строку
                    String fullName = row.getCell(0).getStringCellValue();
                    String universityId = row.getCell(1).getStringCellValue();
                    int courseNumber = (int) row.getCell(2).getNumericCellValue(); // Целочисленное значение курса
                    double examScore = row.getCell(3).getNumericCellValue(); // Среднее экзаменационное значение

                    Student student = new Student(fullName, universityId, courseNumber, (float) examScore, false /* международные */);
                    students.add(student);
                }
            }
            logger.info("Студенты успешно прочитаны из файла.");
            return students;
        }
    }

    public static List<University> readUniversitiesFromExcel(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(1); // Предполагаем, что университеты находятся на втором листе

            List<University> universities = new ArrayList<>();
            for (Row row : sheet) {
                if (row.getRowNum() > 0) { // Пропускаем заголовочную строку
                    String id = row.getCell(0).getStringCellValue();
                    String fullName = row.getCell(1).getStringCellValue();
                    String shortName = row.getCell(2).getStringCellValue();
                    int foundationYear = (int) row.getCell(3).getNumericCellValue(); // Год основания
                    String profileText = row.getCell(4).getStringCellValue(); // Название профиля
                    StudyProfile studyProfile = convertToEnum(profileText); // Преобразование строки в enum

                    University university = new University(id, fullName, shortName, foundationYear, studyProfile, "", 0L);
                    universities.add(university);
                }
            }
            logger.info("Университеты успешно прочитаны из файла.");
            return universities;
        }
    }

    private static StudyProfile convertToEnum(String text) {
        switch(text.toUpperCase()) {
            case "MEDECINE":
                return StudyProfile.MEDICINE;
            case "ENGINEERING":
                return StudyProfile.ENGINEERING;
            case "LAW":
                return StudyProfile.LAW;
            default:
                throw new IllegalArgumentException("Unknown profile type: " + text);
        }
    }
}