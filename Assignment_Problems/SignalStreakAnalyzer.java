public class SignalStreakAnalyzer {
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data provided.");
            return;
        }

        char maxColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }

            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                maxColor = currentColor;
            }
        }

        System.out.printf("Longest Streak: '%c' repeated %d times\n", maxColor, maxStreak);
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR"); // Output: Longest Streak: 'G' repeated 3 times
        findLongestStreak("RRRRYYGG"); // Output: Longest Streak: 'R' repeated 4 times
    }
}