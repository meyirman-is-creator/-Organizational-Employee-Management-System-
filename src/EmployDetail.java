import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class EmployDetail {
    long employ_contact;
    float employ_salary;
    int employ_id;
    String position;
    String email;
    int age;
    String name;

    EmployDetail(String name, int age, int employ_id, String email, String position, long employ_contact, float employ_salary) {

    }

    protected EmployDetail() {
    }

    void employee_detail(String name, int age, int employ_id, String email, String position, long employ_contact, float employ_salary) {
        this.name = name;
        this.age = age;
        this.employ_id = employ_id;
        this.email = email;
        this.position = position;
        this.employ_contact = employ_contact;
        this.employ_salary = employ_salary;
    }





}
