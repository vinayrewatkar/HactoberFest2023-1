import java.util.*;

class Pair implements Comparable<Pair> {
    public int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int compareTo(Pair p) {
        return this.a - p.a;
    }
}

public class FCSC_arrival {
    public static void FCFS(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = sc.nextInt();
        ArrayList<Pair> list = new ArrayList<>();
        int[] waiting_time = new int[n];
        int[] turnaround_time = new int[n];
        double wait_time = 0;
        double turn_time = 0;
        System.out.println("Enter arrival time with corresponding burst time");

        for (int i = 0; i < n; i++) {
            int arrival_time = sc.nextInt();
            int burst_time = sc.nextInt();
            list.add(new Pair(arrival_time, burst_time));
        }
        Collections.sort(list);

        int current_time = 0;
        for (int i = 0; i < n; i++) {
            Pair currentProcess = list.get(i);

            if (current_time < currentProcess.a) {
                current_time = currentProcess.a;
            }

            waiting_time[i] = current_time - currentProcess.a;
            current_time += currentProcess.b;
            turnaround_time[i] = waiting_time[i] + currentProcess.b;
            wait_time += waiting_time[i];
            turn_time += turnaround_time[i];
        }

        double avgWaitingTime = wait_time / n;
        double avgTurnaroundTime = turn_time / n;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
        sc.close();
    }

    public static void main(String[] args) {
        FCFS(args);
    }
}
