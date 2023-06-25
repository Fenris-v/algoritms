package sprint1.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Метеорологическая служба вашего города решила исследовать погоду новым способом.
// - Под температурой воздуха в конкретный день будем понимать максимальную температуру в этот день.
// - Под хаотичностью погоды за n дней служба понимает количество дней, в которые температура строго больше, чем в день
// до (если такой существует) и в день после текущего (если такой существует). Например, если за 5 дней максимальная
// температура воздуха составляла [1, 2, 5, 4, 8] градусов, то хаотичность за этот период равна 2: в 3-й и 5-й дни
// выполнялись описанные условия.
// Определите по ежедневным показаниям температуры хаотичность погоды за этот период.
// Заметим, что если число показаний n=1, то единственный день будет хаотичным.
//
// Формат ввода
// В первой строке дано число n –— длина периода измерений в днях, 1 ≤ n≤ 105. Во второй строке даны n целых чисел –—
// значения температуры в каждый из n дней. Значения температуры не превосходят 273 по модулю.
//
// Формат вывода
// Выведите единственное число — хаотичность за данный период.
public class ChaoticWeather {
    public static void main(String[] args) {
        countChaoticDays();
    }

    private static void countChaoticDays() {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[] forecasting = getForecasting(reader);
            int chaoticDaysCount = getChaoticDaysCount(forecasting);
            writer.write(String.valueOf(chaoticDaysCount));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getForecasting(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        int[] forecasting = new int[length];

        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < length; i++) {
            forecasting[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return forecasting;
    }

    private static int getChaoticDaysCount(int[] forecasting) {
        int chaoticDaysCount = 0;
        for (int i = 0; i < forecasting.length; i++) {
            if (i > 0 && forecasting[i - 1] >= forecasting[i]) {
                continue;
            }

            if (i < forecasting.length - 1 && forecasting[i + 1] >= forecasting[i]) {
                continue;
            }

            chaoticDaysCount++;
        }

        return chaoticDaysCount;
    }
}
