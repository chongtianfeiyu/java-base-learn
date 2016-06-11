package cn.evilcoder.encryption;

import java.security.MessageDigest;

/**
 * User: evilcoder
 * Date: 2016/6/11
 * Time: 17:56
 * 数字摘要算法工具类
 */
public class MessageDigestUtlls {
  private final static String[] digits = {"0", "1", "2", "3", "4",
      "5", "6", "7", "8", "9",
      "a", "b", "c", "d", "e", "f"};

  private static String byte2HexString(byte b) {
    int n = b;
    if (n < 0) {
      n = 256 + n;
    }
    // 取高位
    int d1 = (n >>> 4) & 0xf;
    // 取低位
    int d2 = n & 0xf;
    return digits[d1] + digits[d2];
  }

  private static String byteArrayToHexString(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(byte2HexString(b));
    }
    return sb.toString();
  }


  public static String getMessageDigestString(String str, MessageDigestAlgorithm algorithm) {
    try {
      MessageDigest md = MessageDigest.getInstance(algorithm.getName());
      md.update(str.getBytes("UTF-8"));
      return byteArrayToHexString(md.digest());
    } catch (Exception e) {
      return "";
    }
  }

}
