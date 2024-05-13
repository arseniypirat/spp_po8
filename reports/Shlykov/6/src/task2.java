class DigitalClock {
    private int hours;
    private int minutes;
    private int seconds;

    public DigitalClock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String displayTime() {
        return hours + ":" + minutes + ":" + seconds;
    }
}

class AnalogClock {
    private int degrees;

    public AnalogClock(int degrees) {
        this.degrees = degrees;
    }

    public int displayDegrees() {
        return degrees;
    }
}

class AnalogClockAdapter extends DigitalClock {
    private AnalogClock analogClock;

    public AnalogClockAdapter(AnalogClock analogClock) {
        super(0, 0, 0);
        this.analogClock = analogClock;
    }

    @Override
    public String displayTime() {
        int degrees = analogClock.displayDegrees();
        int hours = degrees / 30;
        int minutes = (degrees % 30) * 2;
        return hours + ":" + minutes + ":00";
    }
}

public class task2 {
    public static void main(String[] args) {
        AnalogClock analogClock = new AnalogClock(90);
        AnalogClockAdapter adapter = new AnalogClockAdapter(analogClock);
        System.out.println(adapter.displayTime());
    }
}

