import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.stats.StatsService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsServiceTest {
    public StatsService service;
    public long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
    /**
     * Внутри класса создаём поле с объектом StatsService чтобы использовать его
     * в каждом методе этого класса
     * А так же создаём массив для тестирования
     */

    @Test
    void testCalculateTotalSales() {
        service = new StatsService();
        long result = service.calculateTotalSales(sales);
        assertEquals(180, result);
    }

    @Test
    void testCalculateAverageSales() {
        service = new StatsService();
        long result = service.calculateAverageSales(sales);
        assertEquals(15, result);
    }

    @Test
    void testFindMonthWithMaxSales() {
        service = new StatsService();
        int result = service.findMonthWithMaxSales(sales);
        assertEquals(8, result);
    }

    @Test
    void testFindMonthWithMinSales() {
        service = new StatsService();
        int result = service.findMonthWithMinSales(sales);
        assertEquals(9, result);
    }

    @Test
    void testCountMonthsBelowAverage() {
        service = new StatsService();
        int result = service.countMonthsBelowAverage(sales);
        assertEquals(5, result);
    }

    @Test
    void testCountMonthsAboveAverage() {
        service = new StatsService();
        int result = service.countMonthsAboveAverage(sales);
        assertEquals(5, result);
    }
}
