// Build a console application to manage the driver and truck related data. Each truck will have exactly one driver who will drive the truck.
// Create a class Truck with following attribute
// id: integer
// name: String
// totalMilesTraveledByTruck: Float
// Create a class Driver with following attribute
// id: integer
// name: String
// contact: String
// experience: Float

// Establish the relationship between the Truck and Driver. Create getters, setters, and parameterized constructors for the above classes.

// Create class Solution with the main method.
// Implement the below static method in Solution class
// getAllTruckWithDistance method:
// This method accepts an array of Truck objects and an integer value representing the threshold distance as input parameters. It returns an array of Truck objects whose total miles traveled is greater than or equal to the specified distance.
// The resulting array must be sorted in descending order based on the associated driver's experience.

// If no truck meets the specified distance criteria, the method should return null.

// Note:

// A Truck must have exactly one associated Driver, and a driver cannot exist without a Truck.
// If multiple drivers have the same experience value, the corresponding trucks should be ordered according to the original insertion order in the input array.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TruckDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Truck[] trucks = new Truck[size];

        for (int i = 0; i < size; i++) {

            int id = scanner.nextInt();
            scanner.nextLine();
            String name = scanner.nextLine();
            float totalMiles = scanner.nextFloat();

            int did = scanner.nextInt();
            scanner.nextLine();
            String dname = scanner.nextLine();
            String dcontact = scanner.nextLine();
            float experience = scanner.nextFloat();

            Driver driver = new Driver(did, dname, dcontact, experience);
            trucks[i] = new Truck(id, name, totalMiles, driver);
        }

        float distance = scanner.nextFloat();

        Truck[] output = getAllTruckWithDistance(trucks, distance);

        if (output == null) {
            System.out.println("No Truck Found");
        } else {
            for (Truck truck : output) {
                System.out.println(truck.getId());
                System.out.println(truck.getName());
                System.out.println(truck.getTotalMilesTraveled());
                System.out.println(truck.getDriver().getId());
                System.out.println(truck.getDriver().getName());
            }
        }

        scanner.close();
    }

    private static Truck[] getAllTruckWithDistance(Truck[] trucks, float distance) {

        List<Truck> input = new ArrayList<Truck>();

        if (trucks.length == 0) {
            return null;
        }

        for (Truck truck : trucks) {

            if (truck.getTotalMilesTraveled() >= distance) {
                input.add(truck);
            }
        }

        // Collections.sort(input, Comparator.comparing(obj ->
        // ((Truck)obj).getDriver().getExperience()).reversed());

        Collections.sort(input,
                (a, b) -> Double.compare(b.getDriver().getExperience(), a.getDriver().getExperience()));

        Truck[] output = input.toArray(new Truck[input.size()]);

        if (output.length == 0) {
            return null;
        }

        return output;
    }

}

class Truck {

    private int id;
    private String name;
    private float totalMilesTraveledByTruck;
    private Driver driver;

    public Truck(int id, String name, float totalMilesTraveledByTruck, Driver driver) {
        this.id = id;
        this.name = name;
        this.totalMilesTraveledByTruck = totalMilesTraveledByTruck;
        this.driver = driver;
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

    public float getTotalMilesTraveled() {
        return totalMilesTraveledByTruck;
    }

    public void setTotalMilesTraveled(float totalMilesTraveledByTruck) {
        this.totalMilesTraveledByTruck = totalMilesTraveledByTruck;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}

class Driver {

    private int id;
    private String name;
    private String contact;
    private float experience;

    public Driver(int id, String name, String contact, float experience) {
        this.id = id;
        this.name = name;
        this.contact = contact;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

}