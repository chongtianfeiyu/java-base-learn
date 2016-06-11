package cn.evilcoder.encryption;

/**
 * User: evilcoder
 * Date: 2016/6/11
 * Time: 20:54
 */
public enum MessageDigestAlgorithm {
  MD5("MD5", "Message Digest Algorithm 5"),
  SHA1("SHA-1", "Message Digest Algorithm of SHA-1"),
  SHA256("SHA-256", "Message Digest Algorithm of SHA-256"),;

  private String name;
  private String desc;

  MessageDigestAlgorithm(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
