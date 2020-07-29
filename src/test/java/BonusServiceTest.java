import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService bonusService = new BonusService();

//        подготоваливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

//        вызываем целевой метод:
        long actual = bonusService.calculate(amount, registered);

//        производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService bonusService = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = bonusService.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService bonusService = new BonusService();

        long amount = 15_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = bonusService.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService bonusService = new BonusService();

        long amount = 15_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = bonusService.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}