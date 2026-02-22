package org.application.util;

import org.application.model.Student;
import org.application.model.Statistics;
import org.application.model.StudyProfile;
import org.application.model.University;

import java.util.*;
import java.util.stream.Collectors;

import java.util.logging.Logger;

public class CollectionUtil {
    private static final Logger logger = Logger.getLogger(CollectionUtil.class.getName());

    public List<Statistics> generateStatistics(List<Student> students, List<University> universities) {
        // Группировка университетов по профилям
        Map<StudyProfile, List<University>> universitiesByProfile = universities.stream()
                .filter(u -> u.getMainProfile() != null) // Проверка на null
                .collect(Collectors.groupingBy(University::getMainProfile));

        // Группировка студентов по профилям
        Map<StudyProfile, List<Student>> studentsByProfile = students.stream()
                .collect(Collectors.groupingBy(student -> {
                    Optional<University> university = universities.stream()
                            .filter(u -> u.getId().equals(student.getUniversityId()))
                            .findFirst();
                    if (university.isPresent()) {
                        StudyProfile profile = university.get().getMainProfile();
                        if (profile != null) {
                            return profile;
                        } else {
                            System.out.println("University with ID " + student.getUniversityId() + " has no main profile.");
                            return null;
                        }
                    } else {
                        System.out.println("Student with ID " + student.getUniversityId() + " has no university.");
                        return null;
                    }
                }));

        List<Statistics> statistics = new ArrayList<>();
        for (StudyProfile profile : universitiesByProfile.keySet()) {
            List<University> profileUniversities = universitiesByProfile.get(profile);
            List<Student> profileStudents = studentsByProfile.getOrDefault(profile, Collections.emptyList());

            int studentCount = profileStudents.size();
            int universityCount = profileUniversities.size();
            List<String> universityNames = profileUniversities.stream()
                    .map(University::getFullName)
                    .collect(Collectors.toList());

            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();

            Statistics stat = new Statistics(profile, avgExamScore, studentCount, universityCount, universityNames);
            statistics.add(stat);
        }

        logger.info("Статистика успешно сгенерирована.");
        return statistics;
    }
}