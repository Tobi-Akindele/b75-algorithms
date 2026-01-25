package extras.apexon;

public class HumanReadableTime {

    public static String format(int seconds) {
        int hour = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        return String.format("%02d:%02d:%02d", hour, minutes, secs);
    }

    public static void main(String[] args) {
        System.out.println(format(359999));
        System.out.println(format(3661));
        System.out.println(format(86399));
    }
}
