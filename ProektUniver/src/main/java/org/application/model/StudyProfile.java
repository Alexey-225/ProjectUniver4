package org.application.model;

public enum StudyProfile {
    MEDICINE("Медицина"),
    ENGINEERING("Инженерия"),
    LAW("Право");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}