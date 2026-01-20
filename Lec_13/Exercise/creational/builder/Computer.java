package creational.builder;

public class Computer {
    private String hdd;
    private String ram;

    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public Computer(ComputerBuilder computerBuilder) {
        this.hdd = computerBuilder.hdd;
        this.ram = computerBuilder.ram;
        this.isGraphicsCardEnabled = computerBuilder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = computerBuilder.isBluetoothEnabled;
    }

    public String getHdd() {
        return hdd;
    }

    public String getRam() {
        return ram;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }


    public ComputerBuilder builder() {
        return new ComputerBuilder();
    }

    public static class ComputerBuilder {
        private String hdd;
        private String ram;

        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        private ComputerBuilder() {}

        public ComputerBuilder setHdd(String hdd) {
            this.hdd = hdd;
            return this;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setGraphicsCard(boolean isEnabled) {
            this.isGraphicsCardEnabled = isEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isEnabled) {
            this.isBluetoothEnabled = isEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
