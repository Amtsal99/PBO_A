class NumberDisplay {
    private int limit;
    private int value;

    public NumberDisplay(int limit) {
        this.limit = limit;
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value >= 0 && value < limit) {
            this.value = value;
        }
    }

    public void increment() {
        value = (value + 1) % limit;
    }

    public String getDisplayValue() {
        if (value < 10) {
            return "0" + value;
        } else {
            return "" + value;
        }
    }
}
