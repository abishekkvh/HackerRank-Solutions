import java.util.*;

public class NewYearChaos
{
    public static void minimumBribes(List<Integer> q)
    {
        int bribes = 0;

        for (int i = 0; i < q.size(); i++)
        {
            int person = q.get(i);

            if (person - (i + 1) > 2)
            {
                System.out.println("Too chaotic");
                return;
            }

            int start = Math.max(0, person - 2);

            for (int j = start; j < i; j++)
            {
                if (q.get(j) > person)
                {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args)
    {
        List<Integer> q1 = Arrays.asList(2, 1, 5, 3, 4);
        List<Integer> q2 = Arrays.asList(2, 5, 1, 3, 4);

        minimumBribes(q1);
        minimumBribes(q2);
    }
}