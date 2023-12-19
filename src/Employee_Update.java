import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Employee_Update {

    public void updateFile(String newInfo, String ID, String whichItem) {
        if (whichItem.equals("Employee ID")) {
            String linkToOldFile = "src\\BaseOfUser\\" + ID + ".txt";
            String linkToNewFile = "src\\BaseOfUser\\" + newInfo + ".txt";
            File oldFile = new File(linkToOldFile);
            File newFile = new File(linkToNewFile);
            oldFile.renameTo(newFile);
            BufferedReader br = null;
            String temp = "";
            try {
                br = new BufferedReader(new FileReader(linkToNewFile));
                String line;
                while ((line = br.readLine()) != null) {
                    temp += line + "-===-";
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String[] tempArr = temp.split("-===-");
            String save = "";
            for (int i = 0; i < tempArr.length; i++) {
                int row = 0;
                for (int j = 0; j < tempArr[i].length(); j++) {
                    if (tempArr[i].charAt(j) == whichItem.charAt(j)) {
                        row++;
                    } else if (tempArr[i].charAt(j) != whichItem.charAt(j)) {
                        row = 0;
                        break;
                    } if (row == whichItem.length()) {
                        for (int h = 0; h < tempArr[i].length(); h++) {
                            if (tempArr[i].charAt(h) == ':') {
                                save += tempArr[i].charAt(h);
                                break;
                            }
                            save += tempArr[i].charAt(h);
                        }
                        tempArr[i]=save+newInfo;
                        break;
                    }
                }
                File file = new File(linkToNewFile);
                if(file.exists()){
                    try{
                        file.createNewFile();
                        PrintWriter pw = new PrintWriter(file);
                        for(int j =0; j<tempArr.length; j++){
                            pw.println(tempArr[j]);
                        }
                        pw.close();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        } else {
            String fileCourse = "src/BaseOfUser/" + ID+".txt";
            String temp = "";
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(fileCourse));
                String line;
                while ((line = br.readLine()) != null) {
                    temp += line + "-===-";
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String[] tempArr = temp.split("-===-");
            File oldFile = new File(fileCourse);
            if (oldFile.exists()) {
                try {
                    oldFile.createNewFile();
                    PrintWriter pw = new PrintWriter(oldFile);
                    int num = 0;
                    String save = "";
                    for (int j = 0; j < tempArr.length; j++) {
                        int row = 0;
                        for (int h = 0; h < tempArr[j].length(); h++) {
                            if (tempArr[j].charAt(h) == whichItem.charAt(h)) {
                                row++;
                            } else if (tempArr[j].charAt(h) != whichItem.charAt(h)) {
                                row = 0;
                                break;
                            }
                            if (row == whichItem.length()) {
                                num = row;
                                for (int o = 0; o < tempArr[j].length(); o++) {
                                    if (tempArr[j].charAt(o) == ':') {
                                        save += tempArr[j].charAt(o);
                                        break;
                                    }
                                    save += tempArr[j].charAt(o);
                                }
                                tempArr[j] = save + newInfo;
                                break;
                            }
                        }
                    }
                    pw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            File newFile = new File(fileCourse);
            if (newFile.exists()) {
                try {
                    newFile.createNewFile();
                    PrintWriter pw = new PrintWriter(newFile);
                    for (int p = 0; p < tempArr.length; p++) {
                        pw.print(tempArr[p] + "\n");
                    }
                    pw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
