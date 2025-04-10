import java.util.ArrayList;
import java.util.Collections;

public class StudentManagement {
    ArrayList<Student> students = new ArrayList<>();

    // Thêm sinh viên vào danh sách
    public void addStudent(Student student) {
        students.add(student);
    }


    // Sắp xếp nổi bọt (Bubble Sort)
    public void bubbleSort() {
        int n = students.size();
        if (n <= 1) return;

        for (int i = 0; i < n - 1; i++) {
            boolean isSorted = true;
            for (int j = n - 1; j > i; j--) {
                if (students.get(j).marks < students.get(j - 1).marks) {
                    // Hoán đổi
                    Collections.swap(students, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }

    // Sắp xếp nhanh (Quick Sort)
    public void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        double pivot = students.get(high).marks;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (students.get(j).marks > pivot) {
                i++;
                Collections.swap(students, i, j);
            }
        }

        Collections.swap(students, i + 1, high);
        return i + 1;
    }

    // Tìm kiếm tuyến tính (Linear Search)
    public Student linearSearch(int id) {
        for (Student s : students) {
            if (s.id == id) return s;
        }
        return null;
    }

    // Tìm kiếm nhị phân (Binary Search)
    public Student binarySearch(int id) {
        bubbleSort();  // Sắp xếp trước khi tìm kiếm
        int left = 0, right = students.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (students.get(mid).id == id) return students.get(mid);
            if (students.get(mid).id < id) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    // Hiển thị danh sách sinh viên
    public void displayStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
