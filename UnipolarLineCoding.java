public class UnipolarLineCoding {
    public static String encodeUnipolar(String data) {
        StringBuilder encoded = new StringBuilder();
        for (char bit : data.toCharArray()) {
            if (bit == '1') {
                encoded.append("1 ");
            } else {
                encoded.append("0 ");
            }
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        String data = "11001110";  // Sample data
        System.out.println("Original Data: " + data);
        System.out.println("Unipolar Encoded Data: " + encodeUnipolar(data));
    }
}

