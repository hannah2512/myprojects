public class BipolarLineCoding {
    public static String encodeBipolar(String data) {
        StringBuilder encoded = new StringBuilder();
        boolean lastPositive = false;
        for (char bit : data.toCharArray()) {
            if (bit == '1') {
                encoded.append(lastPositive ? "-1 " : "+1 ");
                lastPositive = !lastPositive;
            } else {
                encoded.append("0 ");
            }
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        String data = "11001110";
        System.out.println("Original Data: " + data);
        System.out.println("Bipolar Encoded Data: " + encodeBipolar(data));
    }
}
