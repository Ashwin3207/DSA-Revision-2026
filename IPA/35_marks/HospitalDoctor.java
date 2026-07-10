
import java.util.*;

// Question: Hospital and Doctor Management

// Build a console application to manage hospital and doctor related data. Each Hospital will have exactly one Doctor assigned to it.

// Create a class Hospital with the following attributes
// id : integer
// name : String
// totalPatientsTreated : integer

// Create a class Doctor with the following attributes
// id : integer
// name : String
// specialization : String
// experience : float

// Establish the relationship between the Hospital and Doctor classes.

// Create getters, setters and parameterized constructors for both classes.

// Create class Solution with the main method.

// Implement the following static method.

// findHospitalsByPatients

// The method accepts

// an array of Hospital objects
// an integer value representing the minimum number of patients

// It returns an array of Hospital objects whose totalPatientsTreated is greater than or equal to the given minimum value.

// The returned array must be sorted in descending order of the associated doctor's experience.

// If multiple doctors have the same experience, preserve the original insertion order.

// If no hospital satisfies the condition, return null.

// Note
// Every Hospital must have exactly one associated Doctor.
// A Doctor cannot exist without a Hospital.
// Stable ordering must be maintained for equal experience values.

public class HospitalDoctor {

    public static void main(String[] args) {

    }

    public static Hospital[] findHospitalsByPatients(Hospital[] hospitals, int minPatients) {
        ArrayList<Hospital> list = new ArrayList<>();

        for (Hospital host : hospitals) {
            if (host.getTotalPatientsTreated() >= minPatients) {
                list.add(host);
            }
        }

        Collections.sort(list,
                (a, b) -> Float.compare(b.getDoctor().getExperience(), a.getDoctor().getExperience()));

        if (list.isEmpty()) {
            return null;
        }
        return list.toArray(new Hospital[list.size()]);
    }

}

class Hospital {
    private int id;
    private String name;
    private int totalPatientsTreated;
    private Doctor doctor;

    Hospital(int id, String name, int totalPatientsTreated, Doctor doctor) {
        this.id = id;
        this.name = name;
        this.totalPatientsTreated = totalPatientsTreated;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPatientsTreated() {
        return totalPatientsTreated;
    }

    public void setTotalPatientsTreated(int totalPatientsTreated) {
        this.totalPatientsTreated = totalPatientsTreated;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}

class Doctor {
    private int id;
    private String name;
    private String specialization;
    private float experience;

    public Doctor(int id, String name, String specialization, float experience) {

        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

}
