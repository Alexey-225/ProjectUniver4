package org.application.util;

import org.application.model.StudentComparatorType;
import org.application.model.UniversityComparatorType;

public class ComparatorUtil {
    private ComparatorUtil() {}

    public static StudentComparatorType getStudentComparator(StudentComparatorType type) {
        return type;
    }

    public static UniversityComparatorType getUniversityComparator(UniversityComparatorType type) {
        return type;
    }
}