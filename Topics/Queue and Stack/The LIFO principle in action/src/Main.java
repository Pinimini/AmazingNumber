import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        int numOfNumbers = Integer.parseInt(sc.nextLine());
        while (numOfNumbers > 0) {
            queue.addFirst(Integer.parseInt(sc.nextLine()));
            numOfNumbers--;
        }
        for (Integer i :
                queue) {
            System.out.println(i);
        }

    }

}