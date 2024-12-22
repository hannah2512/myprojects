import java.util.Scanner;

public class CRC_CCITT_V2 {
    public static String computeCRC(String data, String key) {
        int keyLen = key.length();
        StringBuilder paddedData = new StringBuilder(data);
        for (int i = 0; i < keyLen - 1; i++) {
            paddedData.append("0");
        }
        String dividend = paddedData.toString();

        for (int i = 0; i <= dividend.length() - keyLen;) {
            if (dividend.charAt(i) == '1') {
                for (int j = 0; j < keyLen; j++) {
                    dividend = dividend.substring(0, i + j) +
                               (dividend.charAt(i + j) == key.charAt(j) ? '0' : '1') +
                               dividend.substring(i + j + 1);
                }
            }
            while (i < dividend.length() && dividend.charAt(i) != '1') {
                i++;
            }
        }

        return dividend.substring(dividend.length() - (keyLen - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter data (binary string): ");
        String data = scanner.nextLine();
        System.out.print("Enter key (generator polynomial): ");
        String key = scanner.nextLine();
        String crc = computeCRC(data, key);
        System.out.println("CRC Checksum: " + crc);
        System.out.println("Transmitted Data (Data + CRC): " + data + crc);
    }
}
