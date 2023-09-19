package sprint7.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GoldenRush {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int maxWeight = Integer.parseInt(reader.readLine());
            int heapCount = Integer.parseInt(reader.readLine());
            PriorityQueue<GoldenHeap> goldenHeaps = new PriorityQueue<>();
            StringTokenizer stringTokenizer;
            int weight;
            int costPerKg;
            for (int i = 0; i < heapCount; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                costPerKg = Integer.parseInt(stringTokenizer.nextToken());
                weight = Integer.parseInt(stringTokenizer.nextToken());
                goldenHeaps.add(new GoldenHeap(weight, costPerKg));
            }

            long maxCost = getMaxCost(goldenHeaps, maxWeight);
            writer.write(String.valueOf(maxCost));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long getMaxCost(PriorityQueue<GoldenHeap> goldenHeaps, int maxWeight) {
        long maxCost = 0;
        GoldenHeap goldenHeap;
        while (!goldenHeaps.isEmpty() && maxWeight > 0) {
            goldenHeap = goldenHeaps.poll();
            if (maxWeight >= goldenHeap.getWeight()) {
                maxCost += (long) goldenHeap.getWeight() * goldenHeap.getCostPerKg();
            } else {
                maxCost += (long) maxWeight * goldenHeap.getCostPerKg();
            }

            maxWeight -= goldenHeap.getWeight();
        }

        return maxCost;
    }
}

class GoldenHeap implements Comparable<GoldenHeap> {
    private final int weight;
    private final int costPerKg;

    public GoldenHeap(int weight, int cost) {
        this.weight = weight;
        this.costPerKg = cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getCostPerKg() {
        return costPerKg;
    }

    @Override
    public int compareTo(GoldenHeap goldenHeap) {
        return goldenHeap.getCostPerKg() - costPerKg;
    }
}
