package sprint4.task11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NextStop {
    private static final int maxDistance = 20 * 20;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[][] subwayStations = getStations(reader);
            int[][] busStations = getStations(reader);
            int station = getStation(subwayStations, busStations);
            writer.write(station + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getStations(BufferedReader reader) throws IOException {
        int[][] stations = new int[Integer.parseInt(reader.readLine())][];
        StringTokenizer stringTokenizer;
        for (int i = 0; i < stations.length; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            stations[i] = new int[]{Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken())};
        }

        return stations;
    }

    private static int getStation(int[][] subwayStations, int[][] busStations) {
        int topStation = 1;
        int stationCount;
        int topCount = 0;
        int xDiff;
        int yDiff;
        for (int i = 0; i < subwayStations.length; i++) {
            stationCount = 0;
            for (int[] busStation : busStations) {
                xDiff = Math.abs(subwayStations[i][0] - busStation[0]);
                yDiff = Math.abs(subwayStations[i][1] - busStation[1]);
                if (xDiff * xDiff + yDiff * yDiff <= maxDistance) {
                    stationCount++;
                }
            }

            if (stationCount > topCount) {
                topCount = stationCount;
                topStation = i + 1;
            }
        }

        return topStation;
    }
}
