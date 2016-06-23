package cn.evilcoder.encryption;

import cn.evilcoder.Utils.HexStringUtils;

import java.security.MessageDigest;

/**
 * User: evilcoder
 * Date: 2016/6/11
 * Time: 17:56
 * 数字摘要算法工具类
 */
public class MessageDigestUtlls {

  public static String getMessageDigestString(String str, MessageDigestAlgorithm algorithm) {
    try {
      MessageDigest md = MessageDigest.getInstance(algorithm.getName());
      md.update(str.getBytes("UTF-8"));
      return HexStringUtils.bytesToHexString(md.digest());
    } catch (Exception e) {
      return "";
    }
  }

}
