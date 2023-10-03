import java.util.ArrayList;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        ArrayList<Student> classList = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Enter student information");
            System.out.println("2. Print class");
            System.out.println("3. Search by first and last name");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student's first name: ");
                    String firstName = input.next();
                    System.out.print("Enter student's last name: ");
                    String lastName = input.next();
                    System.out.print("Enter student's age: ");
                    int age = input.nextInt();
                    classList.add(new Student(firstName, lastName, age));
                    System.out.println("Student information added successfully.");
                }
                case 2 -> {
                    System.out.println("List of students in the class:");
                    for (Student student : classList) {
                                System.out.println("First Name: " + student.firstName() + ", Last Name: " + student.lastName() + ", Age: " + student.age());
                    }
                }
                case 3 -> {
                    System.out.print("Enter the first name of the student to search for: ");
                    String searchFirstName = input.next();
                    System.out.print("Enter the last name of the student to search for: ");
                    String searchLastName = input.next();
                    boolean found = false;
                    for (Student student : classList) {
                        if (student.firstName().equals(searchFirstName) && student.lastName().equals(searchLastName)) {
                            System.out.println("Student found: First Name: " + student.firstName() + ", Last Name: " + student.lastName() + ", Age: " + student.age());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                }
                case 4 -> {
                    System.out.println("Exiting the program.");
                    input.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}









