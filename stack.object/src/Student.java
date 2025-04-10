public class Student {
    int id;
    String name;
    Double marks;
    public Student (int id, String name, double marks ) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public String getrank(double marks){
        if (marks < 5) return "fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 8.5) return "Very Good";
        else return "Excellent";
    }
    @Override
    public String toString() {
        return "Student{" + "ID=" + id + ", Name= " + name + ", Mark=" + marks +", " +
                "Rank=" +getrank(marks) + '}';
    }
}
