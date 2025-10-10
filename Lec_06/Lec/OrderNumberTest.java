@TestMethodOrder(MethodOrder.OrderAnnotation.clas)
public class OrderNumberTest {

    @Test
    @Order(3)
    void testNullValues() {} // this test will execute third 

    @Test
    @Order(1)
    void testEmptyValues() {} // this test will execute first 

    @Test 
    @Order(2)
    void testValidValus() {} // this will execute second


}