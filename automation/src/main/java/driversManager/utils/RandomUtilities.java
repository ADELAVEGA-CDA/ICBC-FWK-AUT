package driversManager.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtilities {
    public static String generateRandomWords(int wordLength) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(wordLength);
        for (int i = 0; i < wordLength; i++) {
            char tmp = (char) ('a' + r.nextInt('z' - 'a'));
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static String getMd5String(String string) throws Exception {
        try {
            byte[] bytesOfMessage = string.getBytes(StandardCharsets.UTF_8);

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }

            return sb.toString();
        } catch (Exception e) {
            throw e;
        }
    }

    public static int getRandom(int a, int b) {
        Random r = new Random();
        return r.nextInt(b - a) + a;
    }

    public static int getRandomThreadLocal(int a, int b) {
        return ThreadLocalRandom.current().nextInt(a, b + 1);
    }
}
