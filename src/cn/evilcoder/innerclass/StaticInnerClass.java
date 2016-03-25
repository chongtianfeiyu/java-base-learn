package cn.evilcoder.innerclass;

/**
 * User: evilcoder
 * Date: 2016/3/25
 * Time: 21:28
 */
public class StaticInnerClass {

  private int index;

  public StaticInnerClass(int index) {
    this.index = index;
  }

  public static class Inner{
    String username;
    String password;

    public Inner(String username, String password) {
      this.username = username;
      this.password = password;
    }

    @Override
    public String toString() {
      return username+":"+password;
    }
  }

}
