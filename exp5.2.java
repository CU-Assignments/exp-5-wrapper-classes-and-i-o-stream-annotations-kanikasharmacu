import java.io.*;

// Define the Student class, implementing Serializable to allow serialization
class Student implements Serializable {
    private static final long serialVersionUID = 1L;  // This is for version control during serialization.
    
    private int id;
    private String name;
    private double gpa;

    // Constructor
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student GPA: " + gpa);
    }
}

public class SerializeDeserializeStudent {

    // Method to serialize a Student object to a file
    public static void serializeStudent(Student student, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(student);  // Serialize the student object
            System.out.println("Student object serialized and saved to " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

    // Method to deserialize a Student object from a file
    public static Student deserializeStudent(String filename) {
        Student student = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            student = (Student) ois.readObject();  // Deserialize the student object
            System.out.println("Student object deserialized from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
        return student;
    }

    public static void main(String[] args) {
        String filename = "student.ser";

        // Create a Student object
        Student student = new Student(1, "John Doe", 3.75);

        // Serialize the student object
        serializeStudent(student, filename);

        // Deserialize the student object
        Student deserializedStudent = deserializeStudent(filename);

        // Display student details after deserialization
        if (deserializedStudent != null) {
            deserializedStudent.displayStudentDetails();
        }
    }
}
