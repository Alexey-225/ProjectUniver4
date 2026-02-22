package org.application.model;

public enum StudentComparatorType {
    NAME(new StudentNameComparator()),
    COURSE_NUMBER(new StudentCourseNumberComparator()),
    AVG_EXAM_SCORE(new StudentAvgExamScoreComparator());

    private final StudentComparator comparator;

    StudentComparatorType(StudentComparator comparator) {
        this.comparator = comparator;
    }

    public StudentComparator getComparator() {
        return comparator;
    }
}