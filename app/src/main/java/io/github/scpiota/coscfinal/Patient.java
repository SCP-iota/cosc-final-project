package io.github.scpiota.coscfinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class Patient {
    private String name;
    private LocalDate dob;
    private Severity severity;
    private LocalTime arrivalTime;

    public Patient(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Severity getSeverity() {
        return severity;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
