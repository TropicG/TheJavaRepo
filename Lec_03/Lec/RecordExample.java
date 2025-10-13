public record FXOrder(int units, double price, int ttl){

    public FXOrder {
        if(uints < 1) {
            throw new IllegalArgumentException("FXOrder units must be positive");
        }

        if(price <= 0.0){
            throw new IllegalArgumentException("FXOrder price must be positive");
        }
    }
}