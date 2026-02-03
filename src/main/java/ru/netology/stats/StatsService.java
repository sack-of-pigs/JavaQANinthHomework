package ru.netology.stats;

public class StatsService {

    //Сумма всех продаж
    public long calculateTotalSales(long[] sales) {
        long total = 0;
        for (long sale : sales) {
            total += sale;
        }
        return total;
    }

    //Средняя сумма продаж в месяц
    public long calculateAverageSales(long[] sales) {
        if (sales.length == 0) {
            return 0; // если массив пустой
        }
        long total = calculateTotalSales(sales);
        return total / sales.length; //целочисленное деление без остатка
    }

    //Номер месяца с максимальными продажами
    public int findMonthWithMaxSales(long[] sales) {
        if (sales.length == 0) {
            return -1; // если массив пустой
        }

        long maxSales = sales[0];
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
    public long findMonthWithMinSales(long[] sales) {
        if (sales.length == 0) {
            return -1; // если массив пустой
        }

        long minSales = sales[0];
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
    public int countMonthsBelowAverage(long[] sales) {
        long average = calculateAverageSales(sales);
        int count = 0;

        for (long sale : sales) {
            if (sale < average) {
                count++;
            }
        }

        return count;
    }

    //Кол-во месяцев выше среднего
    public int countMonthsAboveAverage(long[] sales) {
        double average = calculateAverageSales(sales);
        int count = 0;

        for (long sale : sales) {
            if (sale > average) {
                count++;
            }
        }

        return count;
    }
}

