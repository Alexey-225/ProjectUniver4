package org.application.model;

public enum UniversityComparatorType {
    NAME(new UniversityNameComparator()),
    YEAR_OF_FOUNDATION(new UniversityYearOfFoundationComparator());

    private final UniversityComparator comparator;

    UniversityComparatorType(UniversityComparator comparator) {
        this.comparator = comparator;
    }

    public UniversityComparator getComparator() {
        return comparator;
    }
}