public class MinimumSwapsTwo
{

    public static int minimumSwaps(int[] arr)
    {
        int swaps = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] != i + 1)
            {
                for (int j = i + 1; j < arr.length; j++)
                {
                    if (arr[j] == i + 1)
                    {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        swaps++;
                    }
                }
            }
        }

        return swaps;
    }

    public static void main(String[] args)
    {
        int[] arr = { 7, 1, 3, 2, 4, 5, 6 };
        int swaps = minimumSwaps(arr);
        System.out.println(swaps);

        int[] arr2 = { 4, 3, 1, 2 };
        int swaps2 = minimumSwaps(arr2);
        System.out.println(swaps2);
    }
}
