package sprint3.task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Тимофей решил купить несколько домов на знаменитом среди разработчиков Алгосском архипелаге. Он нашёл n объявлений
// о продаже, где указана стоимость каждого дома в алгосских франках. А у Тимофея есть k франков. Помогите ему
// определить, какое наибольшее количество домов на Алгосах он сможет приобрести за эти деньги.
//
// Формат ввода
// В первой строке через пробел записаны натуральные числа n и k.
// n — количество домов, которые рассматривает Тимофей, оно не превосходит 100000;
// k — общий бюджет, не превосходит 100000;
// В следующей строке через пробел записано n стоимостей домов. Каждое из чисел не превосходит 100000. Все стоимости
// — натуральные числа.
//
// Формат вывода
// Выведите одно число — наибольшее количество домов, которое может купить Тимофей.
public class HouseBuying {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int houseCount = Integer.parseInt(stringTokenizer.nextToken());
            int money = Integer.parseInt(stringTokenizer.nextToken());
            stringTokenizer = new StringTokenizer(reader.readLine());
            int[] houses = new int[houseCount];
            for (int i = 0; i < houseCount; i++) {
                houses[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int maxCountHouse = getMaxCountHouses(money, houses);
            writer.write(String.valueOf(maxCountHouse));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getMaxCountHouses(int money, int[] houses) {
        int count = 0;
        Arrays.sort(houses);
        for (int house : houses) {
            if (money < house) {
                break;
            }

            money -= house;
            count++;
        }

        return count;
    }
}
