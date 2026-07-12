import java.util.*;

public class countCharacters {
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int count =0;
        str = str.trim();
        if(str.isEmpty())
        {
            System.err.println(0);
            sc.close();
            return;
        }
            
        for(char c : str.toCharArray())
        {
            if(Character.isAlphabetic(c))
            {

                count++;
            }
        }

        System.out.println(count);
        sc.close();

    }
}
