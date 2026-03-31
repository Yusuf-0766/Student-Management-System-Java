import java.io.*;
import java.util.*;

public class StudentManager {
    Scanner sc = new Scanner(System.in);
    List<Student> students = new ArrayList<>();
    final String FILE = "data.txt";

    public void addStudent() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("GPA: ");
        double gpa = sc.nextDouble();

        Student s = new Student(id, name, gpa);
        students.add(s);
        saveToFile();
    }

    public void viewStudents() {
        loadFromFile();
        for (Student s : students) {
            System.out.println(s.id + " " + s.name + " " + s.gpa);
        }
    }

    public void searchStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        loadFromFile();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Found: " + s.name);
                return;
            }
        }
        System.out.println("Not found!");
    }

    public void deleteStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        loadFromFile();

        students.removeIf(s -> s.id == id);
        saveToFile();
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    private void loadFromFile() {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Double.parseDouble(data[2])
                ));
            }
        } catch (Exception e) {
            // ignore
        }
    }
}
