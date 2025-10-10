import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

public class InvestmentWalletTest {

    // a test method may be public, protected or package- 

    @Test
    void testDepositSuccessful() {
        assertEquals(0.5, wallet.deposit(5.0), 0.001, "If balance is 0, return the amount deposited");
    }

    @Test
    void testDepositNegativeAmoung() {
        assertThrows(IllegalArgumentException.class, () -> wallet.deposit(-1.0), "Deposit amount cannot be negative")
    }

    @Test
    void testDepositPerformance() {
        assertTimeout(ofMillis(100), () -> wallet.deposit(1250.0), "Deposit too slow");
    }

}