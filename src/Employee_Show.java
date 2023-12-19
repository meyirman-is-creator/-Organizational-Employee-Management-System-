import java.io.*;
import java.sql.SQLOutput;

public class Employee_Show {
    public void viewFile(String id) throws Exception {
        String linkToFile = "src/BaseOfUser/" + id + ".txt";
        File file = new File(linkToFile);
        String temp = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(linkToFile));
            String line;
            while ((line = br.readLine()) != null) {
                temp += line + "-===-";
            }
            br.close();
        } catch (Exception e) {
            throw new Exception();
        }
        String[] tempArr = temp.split("-===-");
        for(int i =0; i<tempArr.length; i++)
            System.out.println(tempArr[i]);

    }
}
