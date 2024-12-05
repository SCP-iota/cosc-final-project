package io.github.scpiota.coscfinal;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        if(p1.getSeverity() == p2.getSeverity()) {
            long p1Age = p1.getDob().until(LocalDate.now(), ChronoUnit.YEARS);
            long p2Age = p2.getDob().until(LocalDate.now(), ChronoUnit.YEARS);
            
            if(p1Age == p2Age) {
                // Intentionally reversed, since patients of the same severity and age should be first-come-first-serve
                return p2.getArrivalTime().compareTo(p1.getArrivalTime());
            } else {
                return (int) (p1Age - p2Age);
            }
        } else {
            return p1.getSeverity().getValue() - p2.getSeverity().getValue();
        }
    }
}
