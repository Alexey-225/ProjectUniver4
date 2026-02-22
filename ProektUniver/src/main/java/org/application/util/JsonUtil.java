package org.application.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.application.model.Request;
import org.application.model.Student;
import org.application.model.University;
import org.application.model.Statistics;

import java.util.List;

public class JsonUtil {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Сериализация отдельных объектов
    public static String serializeStudent(Student student) {
        return gson.toJson(student);
    }

    public static String serializeUniversity(University university) {
        return gson.toJson(university);
    }

    public static String serializeStatistics(Statistics statistics) {
        return gson.toJson(statistics);
    }

    // Сериализация коллекций
    public static String serializeStudents(List<Student> students) {
        return gson.toJson(students);
    }

    public static String serializeUniversities(List<University> universities) {
        return gson.toJson(universities);
    }

    public static String serializeStatistics(List<Statistics> statistics) {
        return gson.toJson(statistics);
    }

    // Сериализация объекта Request
    public static String serializeRequest(Request request) {
        return gson.toJson(request);
    }

    // Десериализация отдельных объектов
    public static Student deserializeStudent(String json) {
        return gson.fromJson(json, Student.class);
    }

    public static University deserializeUniversity(String json) {
        return gson.fromJson(json, University.class);
    }

    // Десериализация коллекций
    public static List<Student> deserializeStudents(String json) {
        return gson.fromJson(json, new com.google.gson.reflect.TypeToken<List<Student>>() {}.getType());
    }

    public static List<University> deserializeUniversities(String json) {
        return gson.fromJson(json, new com.google.gson.reflect.TypeToken<List<University>>() {}.getType());
    }

    public static List<Statistics> deserializeStatistics(String json) {
        return gson.fromJson(json, new com.google.gson.reflect.TypeToken<List<Statistics>>() {}.getType());
    }

    // Десериализация объекта Request
    public static Request deserializeRequest(String json) {
        return gson.fromJson(json, Request.class);
    }
}