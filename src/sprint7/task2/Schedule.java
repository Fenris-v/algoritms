package sprint7.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Schedule {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int lessonCount = Integer.parseInt(reader.readLine());
            StringTokenizer stringTokenizer;
            int startAt;
            int finishAt;
            PriorityQueue<Lesson> lessons = new PriorityQueue<>();
            for (int i = 0; i < lessonCount; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                startAt = (int) (Double.parseDouble(stringTokenizer.nextToken()) * 100);
                finishAt = (int) (Double.parseDouble(stringTokenizer.nextToken()) * 100);
                lessons.add(new Lesson(startAt, finishAt));
            }

            List<Lesson> schedule = getOptimalSchedule(lessons);
            writer.write(schedule.size() + "\n");
            for (Lesson lesson : schedule) {
                writer.write(lesson.toString() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Lesson> getOptimalSchedule(PriorityQueue<Lesson> lessons) {
        List<Lesson> schedule = new ArrayList<>();
        Lesson lesson;
        while (!lessons.isEmpty()) {
            lesson = lessons.poll();
            if (lesson.getFinishAt() - lesson.getStartAt() == 0) {
                schedule.add(lesson);
                continue;
            }

            if (schedule.isEmpty() || schedule.get(schedule.size() - 1).getFinishAt() <= lesson.getStartAt()) {
                schedule.add(lesson);
            }
        }

        return schedule;
    }
}

class Lesson implements Comparable<Lesson> {
    private static final DecimalFormat FORMAT = new DecimalFormat("0.##", new DecimalFormatSymbols(Locale.US));

    private final double startAt;
    private final double finishAt;

    public Lesson(double startAt, double finishAt) {
        this.startAt = startAt;
        this.finishAt = finishAt;
    }

    public double getStartAt() {
        return startAt;
    }

    public double getFinishAt() {
        return finishAt;
    }

    @Override
    public String toString() {
        return FORMAT.format(startAt / 100) + " " + FORMAT.format(finishAt / 100);
    }

    @Override
    public int compareTo(Lesson lesson) {
        if (finishAt != lesson.getFinishAt()) {
            return (int) (finishAt - lesson.getFinishAt());
        }

        return (int) (startAt - lesson.getStartAt());
    }
}
