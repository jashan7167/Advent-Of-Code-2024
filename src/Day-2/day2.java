import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day2
{
    public static void main(String[] args) throws IOException {
        String filepath = "/home/jsb/Adventofcode/untitled/src/Day-2/inputd2.txt";
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String line;
        ArrayList<Integer> list = new ArrayList<>();
        int safe = 0;
        while((line=br.readLine())!=null)
        {
            String[] parts = line.split("\\s+");
            for(int i=0;i<parts.length;i++)
            {
                list.add(Integer.parseInt(parts[i]));
            }

            if(IsSafeSequence2(list))
            {
                safe++;
            }
            list.clear();
        }

        System.out.println(safe);

    }

    public static boolean IsSafeSequence(ArrayList<Integer> arr)
    {
        //single element cant compare
        if(arr.size()<2)
        {
            return false;
        }
        //if they are equal
        if(arr.get(0).equals(arr.get(1)))
        {
            return false;
        }
        boolean inc = arr.get(1)>arr.get(0);
        for(int i=0;i<arr.size()-1;i++)
        {
            int diff = arr.get(i+1)-arr.get(i);
            if(Math.abs(diff)<1 || Math.abs(diff)>3)
            {
                return false;
            }

            if((inc && diff<=0) || (!inc && diff>=0))
            {
                return false;
            }
        }
        return true;
    }
    public static boolean IsSafeSequence2(ArrayList<Integer> arr) {
        if (IsSafeSequence(arr)) {
            return true;
        }

        // Attempt to remove each element and check if the resulting sequence is safe
        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Integer> modifiedList = new ArrayList<>(arr);
            modifiedList.remove(i);

            if (IsSafeSequence(modifiedList)) {
                return true;
            }
        }
        return false;
    }
}