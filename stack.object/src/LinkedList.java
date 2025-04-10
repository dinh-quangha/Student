// Lớp danh sách liên kết đơn (Singly Linked List) để lưu trữ đối tượng Student
public class LinkedList {
    Node head, tail; // head trỏ đến phần tử đầu tiên, tail trỏ đến phần tử cuối cùng
    // Hàm khởi tạo: Khởi tạo danh sách liên kết rỗng
    public LinkedList() {
        head = tail = null;
    }
    // Kiểm tra danh sách có rỗng hay không
    public boolean isEmpty() {
        return (head == null);
    }
    // Thêm một sinh viên vào danh sách (thêm vào cuối danh sách)
    public void add(Student s) {
        Node q = new Node(s); // Tạo một node mới chứa thông tin sinh viên
        if (isEmpty()) { // Nếu danh sách rỗng, gán head và tail là node mới
            head = tail = q;
        } else { // Nếu danh sách không rỗng, thêm node mới vào cuối và cập nhật tail
            tail.next = q;
            tail = q;
        }
    }
    // Duyệt danh sách và in ra thông tin của từng sinh viên
    public void traverse() {
        Node p = head; // Bắt đầu từ node đầu tiên
        while (p != null) { // Lặp đến khi hết danh sách
            System.out.println(p.student.toString()); // In thông tin sinh viên
            p = p.next; // Chuyển đến node tiếp theo
        }
    }
}
