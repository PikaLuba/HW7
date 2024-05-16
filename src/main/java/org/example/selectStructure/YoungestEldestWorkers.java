package org.example.selectStructure;

public class YoungestEldestWorkers {
    private String type;
    private String name;
    private String dateOfBirth;

    public YoungestEldestWorkers(String type, String name, String dateOfBirth) {
        this.type = type;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
