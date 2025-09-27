interface FeeCalculable {
    double calculateFee(double amount);
}

public enum PaymenthMethod implements FeeCalculable {

    CREDIT_CARD("Credit card") {
        @Override
        public double calculateFee(double amoung){
            return amount * 0.025f;
        }
    },
    PAYPAL("PayPal"){
        @Override
        public double calculateFee(double amount){
            return (amount * 0.03) + 0.50;
        }
    },
    BANK_TRANSFER("Bank Transfer") {
        @Override
        public double calculateFee(double amount){
            return 1.00f;
        }
    };


    //Every enum objects is going to have this data member
    private final String displayName;

    //this constructor will be called withing the static initilzer for every enum defined in the class
    private PaymenthMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.getDisplayName();
    }

    //This forces every instance of this enum class to give its own implemntation over this method 
    @Override
    public abstract double calculateFee(double amount);

}

