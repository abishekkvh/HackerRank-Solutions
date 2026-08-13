import java.util.*;

public class RansomNote 
{

    public static String checkMagazine(List<String> magazine, List<String> note)
    {
        HashMap<String, Integer> availableWords = new HashMap<String, Integer>();

        for(int i = 0; i < magazine.size(); i++)
        {
            availableWords.put(magazine.get(i), availableWords.getOrDefault(magazine.get(i), 0) + 1);
        }

        for(String word : note)
        {
            if(!availableWords.containsKey(word) || availableWords.get(word) == 0)
            {
                return "NO";
            }

            availableWords.put(word, availableWords.get(word) - 1);
        }

        return "YES";
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        List<String> magazine = new ArrayList<>(m);
        List<String> note = new ArrayList<>(n);

        for(int i = 0; i < m; i++)
        {
            String word = sc.next();
            magazine.add(word);
        }

        for(int i = 0; i < n; i++)
        {
            String word = sc.next();
            note.add(word);
        }

        System.out.println(checkMagazine(magazine, note));

        sc.close();
    }
}