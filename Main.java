import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: manager.addStudent(); break;
                case 2: manager.viewStudents(); break;
                case 3: manager.searchStudent(); break;
                case 4: manager.deleteStudent(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid option!");
            }
        }
    }
}
