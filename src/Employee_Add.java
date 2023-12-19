import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Employee_Add extends EmployDetail{
    Employee_Add(String name, int age, int employ_id, String email, String position, long employ_contact, float employ_salary){
        super(name,age,employ_id, email,position,employ_contact,employ_salary);
    }
    public Employee_Add(){

    }
    EmployDetail emp = new EmployDetail() {
        @Override
        void employee_detail(String name, int age, int employ_id, String email, String position, long employ_contact, float employ_salary) {
            super.name = name;
            super.age = age;
            super.employ_id = employ_id;
            super.email = email;
            super.position = position;
            super.employ_contact = employ_contact;
            super.employ_salary = employ_salary;
        }
    };

    void createFile() throws FileNotFoundException {
        String fileName = "src/BaseOfUser/"+employ_id+".txt";
        File newFile = new File(fileName);

        //create new File
        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int salary = (int) employ_salary;
        String infoInFile =
                "Employee ID       :" + employ_id + "\n" +
                "Employee Name     :" + name + "\n" +
                "Age               :" + age + "\n" +
                "Employee contact  :" + employ_contact + "\n" +
                "Email Information :" + email + "\n" +
                "Employee position :" + position + "\n" +
                "Employee Salary   :" + salary + "$";

        //print in new File
        try {
            PrintWriter pw = new PrintWriter(newFile);
            pw.println(infoInFile);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}