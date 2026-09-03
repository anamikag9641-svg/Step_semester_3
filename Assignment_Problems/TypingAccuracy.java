public class TypingAccuracy {
    public static void checkTypingAccuracy(String original, String typed) {
        int matchedCount = 0;
        int totalLength = original.length();
        int firstMismatchPos = -1;
        char originalChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < totalLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCount++;
            } else if (firstMismatchPos == -1) {
                // Record the 1-based position and characters of the first mismatch
                firstMismatchPos = i + 1;
                originalChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = ((double) matchedCount / totalLength) * 100;

        StringBuilder output = new StringBuilder();
        output.append(String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matchedCount, totalLength, accuracy));

        if (firstMismatchPos != -1) {
            output.append(String.format("First Mismatch at position %d ('%c' vs '%c')", firstMismatchPos, originalChar, typedChar));
        } else {
            output.append("No Mismatches");
        }

        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}