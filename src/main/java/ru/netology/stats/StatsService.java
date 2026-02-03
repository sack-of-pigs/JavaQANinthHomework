package ru.netology.stats;

public class StatsService {

    //Сумма всех продаж
    public int calculateTotalSales(int[] sales) {
        int total = 0;
        for (int sale : sales) {
            total += sale;
        }
        return total;
    }

    //Средняя сумма продаж в месяц
    public int calculateAverageSales(int[] sales) {
        if (sales.length == 0) {
            return 0; // если массив пустой
        }
        int total = calculateTotalSales(sales);
        return (int) total / sales.length; //целочисленное деление без остатка
    }

    //Номер месяца с максимальными продажами
    public int findMonthWithMaxSales(int[] sales) {
        if (sales.length == 0) {
            return -1; // если массив пустой
        }

        int maxSales = sales[0];
        int monthIndex = 0;

        for (int i = 1; i < sales.length; i++) {
            if (sales[i] >= maxSales) { // при равенстве будет выбираться последний на данный момент
                maxSales = sales[i];
                monthIndex = i;
            }
        }

        return monthIndex + 1; // номер месяца (индекс + 1)
    }

    //Номер месяца с минимальными продажами
    public int findMonthWithMinSales(int[] sales) {
        if (sales.length == 0) {
            return -1; // если массив пустой
        }

        int minSales = sales[0];
        int monthIndex = 0;

        for (int i = 1; i < sales.length; i++) {
            if (sales[i] < minSales) {
                minSales = sales[i];
                monthIndex = i;
            }
        }

        return monthIndex + 1; // номер месяца (индекс + 1)
    }

    //Кол-во месяцев ниже среднего
    public int countMonthsBelowAverage(int[] sales) {
        double average = calculateAverageSales(sales);
        int count = 0;

        for (int sale : sales) {
            if (sale < average) {
                count++;
            }
        }

        return count;
    }

    //Кол-во месяцев выше среднего
    public int countMonthsAboveAverage(int[] sales) {
        double average = calculateAverageSales(sales);
        int count = 0;

        for (int sale : sales) {
            if (sale > average) {
                count++;
            }
        }

        return count;
    }
}

