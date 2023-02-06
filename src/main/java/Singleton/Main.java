package Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Введите данные!");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введите размер списка: ");
            int arraySize = Integer.parseInt(br.readLine());
            System.out.println("Введите верхнюю границу для значений: ");
            int upperBound = Integer.parseInt(br.readLine());
            logger.log("Создание списка");

            List<Integer> num = getRandomNumbers(arraySize, upperBound);

            System.out.println("Вот случайный список: " + Arrays.toString(num.toArray()));
            logger.log("Просим пользователя ввести входные данные для фильтрации");

            System.out.println("Введите порог для фильтра: ");
            int filterThreshold = Integer.parseInt(br.readLine());

            Filter filter = new Filter(filterThreshold);
            List<Integer> filteredNumbers = filter.filterOut(num);

            logger.log("Выводим результат на экран");

            System.out.println("Отфильтрованный список: " + Arrays.toString(filteredNumbers.toArray()));
            logger.log("Завершаем программу");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> getRandomNumbers(int arraySize, int upperBound) {
        ArrayList<Integer> result = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            result.add(random.nextInt(upperBound));
        }
        return result;
    }

}
