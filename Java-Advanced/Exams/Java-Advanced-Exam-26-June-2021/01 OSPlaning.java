import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning_1_26June2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tasks = fillStack(scanner);
        ArrayDeque<Integer> threads = fillQueue(scanner);
        int taskToBeKilled = Integer.parseInt(scanner.nextLine());

        int threadKiller = 0;

        while (tasks.size() > 0 && threads.size() > 0) {
            int task = tasks.pop();
            int thread = threads.poll();

            if (task == taskToBeKilled) {
                threadKiller = thread;
                threads.push(threadKiller);
                break;
            } else if (thread < task) {
                tasks.push(task);
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", threadKiller, taskToBeKilled);
        threads.forEach(t -> System.out.print(t + " "));
    }

    private static ArrayDeque<Integer> fillQueue(Scanner scanner) {
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        int[] values = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int value : values) {
            tasks.offer(value);
        }
        return tasks;
    }

    private static ArrayDeque<Integer> fillStack(Scanner scanner) {
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        int[] values = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int value : values) {
            threads.push(value);
        }
        return threads;
    }
}
