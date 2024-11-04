package residents;

import java.io.*;
import java.util.*;

public class Loader {
    public static List<Resident> fileLoader(String file) throws FileNotFoundException, WrongAgeException, WrongSexException {
        List<Resident> list=new ArrayList<>();
        try (Scanner scan= new Scanner(new File(file))) {
            while (scan.hasNext()) {
                scan.nextLine();
                Resident res=new Resident(scan.nextInt(), scan.nextInt());
                list.add(res);
            }
        }
        return list;
    }
}
