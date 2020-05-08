import java.util.*;
import java.io.*;  

class Program {
    static HashMap<String, Integer> map =new HashMap<>();
    public static void main(String[] args)throws IOException{
            File file = new File(args[0]);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
               String assignment = scan.nextLine();
               Assignment assn = new Assignment(assignment.trim());
               assn.printAssignment();
            }
            scan.close();
            

    }
    public static void addIdentifier(String x, int y ){
        if (map.containsKey(x))
            map.put(x,y); 
        else 
            map.put(x, y);
    }
    public static int getExp(String x){
        if (!map.containsKey(x))
            throw new RuntimeException("identifier does not exist");
        else 
            return map.get(x); 

    }
}
