public class DifferentialManchester {
    public static String encodeDifferentialManchester(String data) {
        StringBuilder encoded = new StringBuilder();
        boolean lastLevel = true; // Assume the signal starts with a high level

        for (char bit : data.toCharArray()) {
            if (bit == '1') {
                encoded.append(lastLevel ? "1" : "0");
                lastLevel = !lastLevel;
                encoded.append(lastLevel ? "1 " : "0 ");
            } else {
                lastLevel = !lastLevel;
                encoded.append(lastLevel ? "1" : "0");
                lastLevel = !lastLevel;
                encoded.append(lastLevel ? "1 " : "0 ");
            }
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        String data = "11001110";
        System.out.println("Original Data: " + data);
        System.out.println("Differential Manchester Encoded Data: " +
                           encodeDifferentialManchester(data));
    }
}
