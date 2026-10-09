public class HotWeatherAlertWindowsDemo {

    static int countAlerts(int[] readings, int k, int threshold) {
        int sum = 0;
        int alerts = 0;

        for (int i = 0; i < k; i++) {
            sum += readings[i];
        }

        if (sum >= k * threshold) {
            alerts++;
        }

        for (int i = k; i < readings.length; i++) {
            sum = sum + readings[i] - readings[i - k];

            if (sum >= k * threshold) {
                alerts++;
            }
        }

        return alerts;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};

        System.out.println(countAlerts(readings, 3, 4));
    }
}
