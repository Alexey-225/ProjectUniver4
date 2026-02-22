package org.application.model;

public class StudentAvgExamScoreComparator implements StudentComparator {

    @Override
    public int compare(Student s1, Student s2) {
        return Float.compare(s2.getAvgExamScore(), s1.getAvgExamScore()); // Сортировка по убыванию
    }
}