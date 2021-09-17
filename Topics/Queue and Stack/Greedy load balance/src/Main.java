import java.util.*;

class Main {
    public static void main(String[] args) {
        Map<String, Integer> tasks = new HashMap<>();
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        int sum1 = 0;
        int sum2 = 0;
        Scanner sc = new Scanner(System.in);

        int key = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < key; i++) {
            String[] mass;
            mass = sc.nextLine().split(" ");
            tasks.put(mass[0], Integer.parseInt(mass[1]));
        }

        for (int i = 1; i <= tasks.size(); i++) {
            if (queue1.isEmpty() || sum1 < sum2 ) {
                queue1.add(i + "");
                sum1 += tasks.get(i +"");
            } else if (queue2.isEmpty() || sum1 > sum2) {
                queue2.add(i + "");
                sum2 += tasks.get(i +"");
            } else if (sum1 == sum2) {
                queue1.add(i + "");
                sum1 += tasks.get(i +"");
            }

        }
        for (String s :
                queue1) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s :
                queue2) {
            System.out.print(s + " ");
        }
    }
}