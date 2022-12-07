package packages;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        int nGen= inp.nextInt();
        int arr[] = generaArr(nGen);
        sumArr(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static int[] generaArr(int size) {
        Random rand = new Random();
        int upperbound = 100;
        int lowerbound = 10;

        int[] numeri = new int[size];
        for (int i = 0; i < size; i++) {
            numeri[i] = rand.nextInt(upperbound - lowerbound) + lowerbound;
            if (numeri[i] % 2 == 0) {
                numeri[i] += 1;
            }
        }
        return numeri;
    }

    static void sumArr(int[] arr)
    {
        for(int i = 0; i < arr.length; i++) {
            arr[i] += arr[i++];
        }
    }
}

