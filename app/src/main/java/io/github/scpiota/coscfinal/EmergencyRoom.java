package io.github.scpiota.coscfinal;

import java.time.LocalTime;
import java.util.Comparator;

public class EmergencyRoom {
    private Heap<Patient> queue;

    public EmergencyRoom(Comparator<Patient> comparator) {
        this.queue = new Heap<>(comparator);
    }

    public void checkIn(Patient patient, Severity severity) {
        patient.setSeverity(severity);
        patient.setArrivalTime(LocalTime.now());
        queue.add(patient);
    }

    public Patient admit() {
        return queue.remove();
    }
}
