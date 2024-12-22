public class ManchesterLineCoding {
    public static String encodeManchester(String data) {
        StringBuilder encoded = new StringBuilder();
        for (char bit : data.toCharArray()) {
            if (bit == '1') {
                encoded.append("01 ");  // 1 -> Low-High (0 1)
            } else {
                encoded.append("10 ");  // 0 -> High-Low (1 0)
            }
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        String data = "11001110";  // Sample data
        System.out.println("Original Data: " + data);
        System.out.println("Manchester Encoded Data: " + encodeManchester(data));
    }
}
