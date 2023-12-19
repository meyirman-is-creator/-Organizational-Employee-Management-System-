import java.util.*;
import java.io.*;

public class EmployManagementSystem_main {
    static Scanner scan = new Scanner(System.in);

    public static void EmployDetail() throws Exception {
        int r = 1;
        for (int i = 0; i < r; i++) {
            r++;
            try {
                System.out.print("Enter Employee's name --------: ");
                String name = scan.nextLine();
                String[] nameArr = name.split(" ");
                for (int j = 0; j < nameArr.length; j++) {
                    if (Character.isUpperCase(nameArr[j].charAt(0))) {
                    } else {
                        throw new Exception();
                    }
                    for (int h = 1; h < nameArr[j].length(); h++) {
                        if (Character.isUpperCase(nameArr[j].charAt(h))) {
                            throw new Exception();
                        } else if (Character.isDigit(nameArr[j].charAt(h))) {
                            throw new Exception();
                        }
                    }
                }
                System.out.print("Enter Employee's age ---------: ");
                int age = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter Employee's ID ----------: ");
                int employ_id = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter Employee's Email ID ----: ");
                String email = scan.nextLine();
                System.out.print("Enter Employee's Position ----: ");
                String position = scan.nextLine();
                System.out.print("Enter Employee contact Info --: ");
                long employ_contact = scan.nextLong();
                System.out.print("Enter Employee's Salary ------: ");
                scan.nextLine();
                String salary = scan.nextLine();
                salary = salary.replace(" ", "");
                String temp_salary = "";
                for (int j = 0; j < salary.length(); j++) {
                    if (salary.charAt(j) == '$') {
                        break;
                    }
                    temp_salary += salary.charAt(j);
                }
                int salary_num = Integer.parseInt(temp_salary);
                float employ_salary = (float) salary_num;
                Employee_Add employ_detail = new Employee_Add();
                employ_detail.employee_detail(name, age, employ_id, email, position, employ_contact, employ_salary);
                employ_detail.createFile();

                System.out.println();
                System.out.println("Employee has been Added ;)");
                System.out.println();
                System.out.println();
                break;
            } catch (Exception e) {
                scan.nextLine();
            }

        }
    }


    public static boolean tekser(String findFileStr, String update) throws Exception {
        File file = new File(findFileStr);
        String temp = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String lane;
            while ((lane = br.readLine()) != null) {
                temp += lane + "--===--";
            }
            br.close();
        } catch (Exception e) {
            throw new Exception();
        }
        String[] tempArr = temp.split("--===--");
        int num = 0;
        for (int i = 0; i < tempArr.length; i++) {
            int row = 0;
            for (int j = 0; j < tempArr[i].length(); j++) {
                if (tempArr[i].charAt(j) == update.charAt(j)) {
                    row++;
                } else if (tempArr[i].charAt(j) != update.charAt(j)) {
                    row = 0;
                    break;
                }
                if (row == update.length()) {
                    num = row;
                    break;
                }
            }
        }
        if (num == update.length()) return true;
        return false;
    }

    static void Employee_Update() throws Exception {
        int r = 1;
        for (int i = 0; i < r; i++) {
            r++;
            try {
                System.out.print("Please Enter Employee's ID : ");
                int findEmployID = scan.nextInt();
                System.out.println();
                System.out.println();
                System.out.println();
                String findFileStr = "src/BaseOfUser/" + findEmployID + ".txt";
                File findFile = new File(findFileStr);
                BufferedReader br = null;
                br = new BufferedReader(new FileReader(findFile));
                String temp = "";
                String line;
                while ((line = br.readLine()) != null) {
                    temp += line + "\n";
                }
                System.out.println(temp);

                System.out.println("Please Enter the detail you want to Update :\nFor example:\nIf you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name. \n");
                int p = 1;
                for (int j = 0; j < p; j++) {
                    p++;
                    scan.nextLine();
                    String newItem = scan.nextLine();
                    if (tekser(findFileStr, newItem)) {
                        System.out.print("Please Enter the Updated Info : ");
                        String newInfo = scan.nextLine();
                        br.close();
                        Employee_Update employ_update = new Employee_Update();
                        employ_update.updateFile(newInfo, String.valueOf(findEmployID), newItem);
                        break;
                    } else {
                        throw new Exception();
                    }
                }
                break;
            } catch (Exception e) {
                scan.nextLine();
            }
        }

        System.out.println();
        System.out.println("Press Enter to Continue...");
        System.out.println();
        System.out.println();
    }

    public static void EmployeeShow() {
        int r = 1;
        for (int i = 0; i < r; i++) {
            r++;
            try {
                System.out.print("Please Enter Employee's ID : ");
                int employ_id = scan.nextInt();
                Employee_Show obj1 = new Employee_Show();
                obj1.viewFile(String.valueOf(employ_id));
                break;
            } catch (Exception e) {
                scan.nextLine();
            }
        }
        System.out.print("Press Enter to Continue... ");
        scan.nextLine();
        scan.nextLine();
    }

    public static void EmployeeRemove() {
        while (true) {
            try {
                System.out.print("Please Enter Employee's ID : ");
                int employID = scan.nextInt();
                Employee_Remove remove = new Employee_Remove();
                remove.removeFile(employID);
                System.out.print("Press Enter to Continue...");
                scan.nextLine();
                scan.nextLine();
                break;
            } catch (Exception e) {
                scan.nextLine();
            }
        }

    }

    public static void main(String[] args) {
        boolean on = true;
        while (on) {
            try {
                MainMenu menu = new MainMenu();
                menu.menu();
                System.out.println();
                System.out.print("Please Enter choice : ");
                int n = scan.nextInt();
                if (n > 0 && n < 6) {
                    switch (n) {
                        case 1:
                            EmployDetail();
                            break;
                        case 2:
                            EmployeeShow();
                            break;
                        case 3:
                            EmployeeRemove();
                            break;
                        case 4:
                            Employee_Update();
                            break;
                        case 5:
                            CodeExit obj1 = new CodeExit();
                            obj1.out();
                            on = false;
                            break;
                    }
                } else throw new Exception();
            } catch (Exception e) {
                scan.nextLine();
            }
        }

    }


}
