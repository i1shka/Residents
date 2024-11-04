package residents;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Resident> resList=Loader.fileLoader("input.txt");
        findMan(resList);
        System.out.println("Номер самого старшего мужчины в списке: " + findMan(resList));
    }

    public static int findMan(List<Resident> resList) {
        int indexOfRes;
        List<Resident> resList1=new ArrayList<>(resList);
        for (int i = resList1.size()-1; i >=0 ; i--) {
            if (resList1.get(i).sex==0){
                resList1.remove(i);
            }
        }
        resList1.sort(Comparator.comparing(x->x.age));
        if (resList1.isEmpty())
            indexOfRes=-1;
        else indexOfRes=resList.indexOf(resList1.getLast())+1;
        return indexOfRes;
    }
}