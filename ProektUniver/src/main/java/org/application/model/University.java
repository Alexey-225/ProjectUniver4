package org.application.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "university")
@XmlAccessorType(XmlAccessType.FIELD)
public class University {
    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "fullName")
    private String fullName;

    @XmlElement(name = "shortName")
    private String shortName;

    @XmlElement(name = "yearOfFoundation")
    private int yearOfFoundation;

    @XmlElement(name = "mainProfile")
    private StudyProfile mainProfile;

    @XmlElement(name = "address")
    private String address;

    @XmlElement(name = "budgetAllocation")
    private long budgetAllocation;

    public University(String id, String fullName, String shortName, int foundationYear, StudyProfile studyProfile, String s, long l) {
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getBudgetAllocation() {
        return budgetAllocation;
    }

    public void setBudgetAllocation(long budgetAllocation) {
        this.budgetAllocation = budgetAllocation;
    }
}