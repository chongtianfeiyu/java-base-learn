package cn.evilcoder.hash;

/**
 * User: evilcoder
 * Date: 2016/6/11
 * Time: 17:04
 */
public class Time33 {

  public static int getTime33(String str) {
    int hash = 5381;
    for (int c : str.toCharArray()) {
      hash += (hash << 5) + c;
    }
    hash &= 0x7fffffff;
    return hash;
  }
}
