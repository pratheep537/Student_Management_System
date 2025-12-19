import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student with this ID already exists.");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, department, marks));
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
             System.out.println("No students found.");
        return;
        }

        System.out.printf("%-5s %-15s %-15s %-10s%n", 
                      "ID", "NAME", "DEPARTMENT", "MARKS");
        System.out.println("---------------------------------------------");

        for (Student s : students) {
             System.out.printf("%-5d %-15s %-15s %-10.2f%n",
                          s.getId(),
                          s.getName(),
                          s.getDepartment(),
                          s.getMarks());
        }
    }
    public void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student not found.");
    }
    public void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}
