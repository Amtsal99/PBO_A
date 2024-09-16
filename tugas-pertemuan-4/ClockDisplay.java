class ClockDisplay {
    private NumberDisplay hours;
    private NumberDisplay minutes;

    public ClockDisplay() {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
    }

    public void setTime(int hour, int minute) {
        hours.setValue(hour);
        minutes.setValue(minute);
    }

    public void timeTick() {
        minutes.increment();
        if (minutes.getValue() == 0) {
            hours.increment();
        }
    }

    public String getTime() {
        return hours.getDisplayValue() + ":" + minutes.getDisplayValue();
    }
}