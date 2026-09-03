public class BankReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Validate bank code (first 3 characters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters (digits)
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        // Extract components
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String sequence = reference.substring(9, 14);

        // Build formatted string using StringBuilder
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] ")
                 .append("DATE: ").append(day).append("/").append(month).append("/").append(year)
                 .append(" | SEQ: ").append(sequence);

        return formatted.toString();
    }

    public static void main(String[] args) {
        String input1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(input1)); // [HDF] DATE: 03/02/26 | SEQ: 00042

        String input2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(input2)); // Invalid: bank code must be 3 letters
    }
}