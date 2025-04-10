import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();
        int choice;

        do {
            System.out.println("\n===== Student Management =====");
            System.out.println("1. Add student");
            System.out.println("2. Edit student information");
            System.out.println("3. Delete student");
            System.out.println("4. Sort students by score (Bubble Sort)");
            System.out.println("5. Sort students by score (Quick Sort)");
            System.out.println("6. Linear search by ID");
            System.out.println("7. Binary search by ID");
            System.out.println("8. Display student list");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                }
            }

            switch (choice) {
                case 1: // Add student
                    System.out.print("Enter the number of students to add: ");
                    int n;
                    while (true) {
                        try {
                            n = Integer.parseInt(scanner.nextLine());
                            if (n > 0) break;
                            System.out.println("Number of students must be a positive integer.");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid integer.");
                        }
                    }

                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter information for student " + (i + 1) + ":");
                        int id;
                        while (true) {
                            System.out.print("ID (positive integer): ");
                            try {
                                id = Integer.parseInt(scanner.nextLine());
                                if (id > 0 && sm.linearSearch(id) == null) break;
                                System.out.println("Invalid ID! It must be a unique positive integer.");
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input! Please enter a valid integer.");
                            }
                        }

                        String name;
                        while (true) {
                            System.out.print("Name (at least 5 characters, letters only): ");
                            name = scanner.nextLine();
                            if (name.matches("[a-zA-Z ]{5,}")) break;
                            System.out.println("Invalid name! It must contain only letters and be at least 5 characters long.");
                        }

                        double marks;
                        while (true) {
                            System.out.print("Score (0-10): ");
                            try {
                                marks = Double.parseDouble(scanner.nextLine());
                                if (marks >= 0 && marks <= 10) break;
                                System.out.println("Invalid score! Please enter a value between 0 and 10.");
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input! Please enter a valid number.");
                            }
                        }

                        sm.addStudent(new Student(id, name, marks));
                    }
                    System.out.println("Added " + n + " students!");
                    break;

                case 2: // Edit student information
                    System.out.print("Enter the student ID to edit: ");
                    int editId;
                    while (true) {
                        try {
                            editId = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid integer.");
                        }
                    }
                    Student student = sm.linearSearch(editId);
                    if (student != null) {
                        String newName;
                        while (true) {
                            System.out.print("Enter new name (at least 5 characters, letters only): ");
                            newName = scanner.nextLine();
                            if (newName.matches("[a-zA-Z ]{5,}")) break;
                            System.out.println("Invalid name! It must contain only letters and be at least 5 characters long.");
                        }

                        double newMarks;
                        while (true) {
                            System.out.print("Enter new score (0-10): ");
                            try {
                                newMarks = Double.parseDouble(scanner.nextLine());
                                if (newMarks >= 0 && newMarks <= 10) break;
                                System.out.println("Invalid score! Please enter a value between 0 and 10.");
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input! Please enter a valid number.");
                            }
                        }
                        student.name = newName;
                        student.marks = newMarks;
                        System.out.println("Updated student information!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3: // Delete student
                    System.out.print("Enter the student ID to delete: ");
                    int deleteId;

                    while (true) {
                        try {
                            deleteId = Integer.parseInt(scanner.nextLine().trim()); // Đọc ID hợp lệ
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid integer.");
                        }
                    }

                    final int idToDelete = deleteId; // Gán giá trị vào biến final

                    // Xóa sinh viên nếu tồn tại
                    boolean removed = sm.students.removeIf(s -> s.id == idToDelete);

                    if (removed) {
                        System.out.println("Student with ID " + idToDelete + " has been deleted.");
                    } else {
                        System.out.println("Student ID not found!");
                    }

                    break;


                case 4:
                    sm.bubbleSort();
                    System.out.println("Sorted students by score (Bubble Sort)!");
                    sm.displayStudents();
                    break;

                case 5:
                    sm.quickSort(0, sm.students.size() - 1);
                    System.out.println("Sorted students by score (Quick Sort)!");
                    sm.displayStudents();
                    break;

                case 6:
                    System.out.print("Enter ID to search (linear search): ");
                    int searchId1 = Integer.parseInt(scanner.nextLine());
                    Student result1 = sm.linearSearch(searchId1);
                    System.out.println(result1 != null ? result1 : "Student not found!");
                    break;

                case 7:
                    System.out.print("Enter ID to search (binary search): ");
                    int searchId2 = Integer.parseInt(scanner.nextLine());
                    Student result2 = sm.binarySearch(searchId2);
                    System.out.println(result2 != null ? result2 : "Student not found!");
                    break;

                case 8:
                    if (sm.students.isEmpty()) {
                        System.out.println("No students available to display.");
                    } else {
                        sm.displayStudents();
                    }
                    break;


                case 0:
                    System.out.println("Exiting program!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        scanner.close();
    }
}
