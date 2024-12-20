import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


//\\s: Matches any whitespace character. This includes spaces, tabs (\t), newlines (\n), and other whitespace.
// +: A quantifier that matches one or more occurrences of the preceding pattern (in this case, any whitespace).
class day1 {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/jsb/Adventofcode/untitled/src/Day-1/inputd1.txt"; // Relative path from the project root
        ArrayList<Integer> leftlist = new ArrayList<Integer>();
        ArrayList<Integer> rightlist = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\s+");
            leftlist.add(Integer.parseInt(parts[0]));
            rightlist.add(Integer.parseInt(parts[1]));
        }
        Collections.sort(leftlist);
        Collections.sort(rightlist);
        //first-part
        int distance = 0;
        for(int i = 0 ; i < leftlist.size() ; i++) {
            distance += Math.abs(leftlist.get(i) - rightlist.get(i));
        }
        for(int num : rightlist)
        {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        //second part
        int result = 0;
        for(int num : leftlist)
        {
            if(map.containsKey(num))
            {
                result += num * map.get(num);
            }
        }
        System.out.println(result);
        System.out.println(distance);
        br.close();


    }
}