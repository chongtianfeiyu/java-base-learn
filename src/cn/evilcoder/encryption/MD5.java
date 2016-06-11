package cn.evilcoder.encryption;

import java.security.MessageDigest;

/**
 * User: evilcoder
 * Date: 2016/6/11
 * Time: 17:56
 */
public class MD5 {
  private final static String[] digits = {"0", "1", "2", "3", "4",
      "5", "6", "7", "8", "9",
      "a", "b", "c", "d", "e", "f"};

  public static String byte2HexString(byte b) {
    int n = b;
    if (n < 0) {
      n = 256 + n;
    }
    int d1 = n / 16;
    int d2 = n % 16;
    return digits[d1] + digits[d2];
  }

  public static String byteArrayToHexString(byte[] bytes) {
    StringBuffer sb = new StringBuffer();
    for (byte b : bytes) {
      sb.append(byte2HexString(b));
    }
    return sb.toString();
  }

  public static String md5(String origin) {
    String result = "";
    try {
      result = origin;
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(result.getBytes("UTF-8"));
      result = byteArrayToHexString(md.digest());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

}
