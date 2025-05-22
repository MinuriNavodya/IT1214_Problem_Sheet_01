import java.util.Scanner;

class Student {
    private String name;
    private int studentId;
    private int attended;

    Student(String name, int studentId, int attended) {
        this.name = name;
        this.studentId = studentId;
        this.attended = attended;
    }
    public String getName() {
        return name;
    }
    public int getStudentId() {
        return studentId;
    }
    public int getattended() {
        return attended;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public void setattended(int attended) {
        this.attended = attended;
    }
    

}
class Classroom{
    Student[] students=new Student[10]; 
    int studentCount=0;
    public void addStudent(Student student){
        if(studentCount<students.length){
            students[studentCount]=student;
            studentCount++;
        }else{
            System.out.println("Classroom is full");
        }
    }
	
    public void updateattended(int studentId, int attended){
		int count=0;
		boolean stcheck=false;
        for(int i=0;i<studentCount;i++){
            if(students[i].getStudentId()==studentId){
                stcheck=true;
				count=i;
				break;
			}
        }
		if(stcheck==true){
			students[count].setattended(attended);
            System.out.println("Days attended updated for student ID: " + studentId);
        }else{
			System.out.println("Student not found");
		}
    }
    public void displayStudents(){
        for(int i=0;i<studentCount;i++){
            System.out.println("Name: " + students[i].getName() + ", Student ID: " + students[i].getStudentId() + ", Days Attended: " + students[i].getattended());
        }
    }
}
class StudentMain{
    public static void main(String[] args){
        Classroom classroom=new Classroom();
        Student student1=new Student("Alice smith", 101, 12);
        Student student2=new Student("Bob Jones", 102, 15); 
        Student student3=new Student("Carol Lee", 103, 10);
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.updateattended(102, 16);
        classroom.updateattended(104, 16);
        classroom.displayStudents();
    }
}
