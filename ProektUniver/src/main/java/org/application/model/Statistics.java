package org.application.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.OptionalDouble;

@XmlRootElement(name = "statistics")
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "profile")
    private StudyProfile profile;

    @XmlElement(name = "avgExamScore")
    private OptionalDouble avgExamScore;

    @XmlElement(name = "studentCount")
    private int studentCount;

    @XmlElement(name = "universityCount")
    private int universityCount;

    @XmlElement(name = "universityNames")
    private List<String> universityNames;

    // Конструктор
    public Statistics(StudyProfile profile, OptionalDouble avgExamScore, int studentCount, int universityCount, List<String> universityNames) {
        this.profile = profile;
        this.avgExamScore = avgExamScore;
        this.studentCount = studentCount;
        this.universityCount = universityCount;
        this.universityNames = universityNames;
    }

    // Геттеры и сеттеры
    public StudyProfile getProfile() {
        return profile;
    }

    public void setProfile(StudyProfile profile) {
        this.profile = profile;
    }

    public OptionalDouble getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(OptionalDouble avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getUniversityCount() {
        return universityCount;
    }

    public void setUniversityCount(int universityCount) {
        this.universityCount = universityCount;
    }

    public List<String> getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(List<String> universityNames) {
        this.universityNames = universityNames;
    }
}