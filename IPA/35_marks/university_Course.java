import java.util.*;

public class university_Course {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        University[] universities = new University[4];

        for (int i = 0; i < 4; i++) {

            int universityId = sc.nextInt();
            sc.nextLine();

            String universityName = sc.nextLine();
            String location = sc.nextLine();

            int courseId = sc.nextInt();
            sc.nextLine();

            String courseName = sc.nextLine();

            double fees = sc.nextDouble();
            sc.nextLine();

            float rating = sc.nextFloat();
            sc.nextLine();

            universities[i] = new University(
                    universityId,
                    universityName,
                    location,
                    courseId,
                    courseName,
                    fees,
                    rating);
        }

        String courseName = sc.nextLine();
        String locationName = sc.nextLine();

        // Calling first method
        University[] result = findUniversityCourseName(universities, courseName);

        if (result == null) {
            System.out.println(
                    "No University found with the given course name");
        } else {
            for (University res : result) {

                System.out.println(
                        res.getUniversityId() + " " +
                                res.getUniversityName() + " " +
                                res.getCourse().getCourseName());
            }
        }

        // Calling second method
        University unires = findUniversityWithSecondHighestCourseFee(
                universities,
                locationName);

        if (unires == null) {
            System.out.println("No University found");
        } else {
            System.out.println(
                    unires.getUniversityId() + " " +
                            unires.getUniversityName() + " " +
                            unires.getCourse().getCourseName() + " " +
                            unires.getCourse().getFees());
        }

        sc.close();
    }

    // Method 1
    public static University[] findUniversityCourseName(
            University[] universities,
            String courseName) {

        ArrayList<University> list = new ArrayList<>();

        for (University uni : universities) {

            if (uni.getCourse()
                    .getCourseName()
                    .equalsIgnoreCase(courseName)) {

                list.add(uni);
            }
        }

        if (list.isEmpty()) {
            return null;
        }

        return list.toArray(new University[list.size()]);
    }

    // Method 2
    public static University findUniversityWithSecondHighestCourseFee(
            University[] universities,
            String location) {

        double highestFees = -1;
        double secondHighestFees = -1;

        University highestUniversity = null;
        University secondHighestUniversity = null;

        for (University uni : universities) {

            if (uni.getLocation().equalsIgnoreCase(location)) {

                double fees = uni.getCourse().getFees();

                if (fees > highestFees) {

                    // Old highest becomes second highest
                    secondHighestFees = highestFees;
                    secondHighestUniversity = highestUniversity;

                    // Current university becomes highest
                    highestFees = fees;
                    highestUniversity = uni;
                } else if (fees < highestFees &&
                        fees > secondHighestFees) {

                    secondHighestFees = fees;
                    secondHighestUniversity = uni;
                }
            }
        }

        return secondHighestUniversity;
    }
}

// Course class
class Course_ {

    private int courseId;
    private String courseName;
    private double fees;
    private float rating;

    public Course_(
            int courseId,
            String courseName,
            double fees,
            float rating) {

        this.courseId = courseId;
        this.courseName = courseName;
        this.fees = fees;
        this.rating = rating;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

// University class
class University {

    private int universityId;
    private String universityName;
    private String location;
    private Course_ course;

    public University(
            int universityId,
            String universityName,
            String location,
            int courseId,
            String courseName,
            double fees,
            float rating) {

        this.universityId = universityId;
        this.universityName = universityName;
        this.location = location;

        // Composition:
        // Course object is created inside University
        this.course = new Course_(
                courseId,
                courseName,
                fees,
                rating);
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Course_ getCourse() {
        return course;
    }

    public void setCourse(Course_ course) {
        this.course = course;
    }
}