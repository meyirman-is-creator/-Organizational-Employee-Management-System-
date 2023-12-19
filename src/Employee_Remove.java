import java.io.*;
public class Employee_Remove implements Remove{
    @Override
    public void removeFile(int ID) throws Exception{
        String linkToFile = "src/BaseOfUser/"+ID+".txt";
        File fileDel = new File(linkToFile);
        if(fileDel.exists()){
            if (fileDel.delete()) {
                System.out.println();
                System.out.println("Employee has been removed Successfully");
                System.out.println();
            }
        } else{
            throw new Exception();
        }

    }
}
