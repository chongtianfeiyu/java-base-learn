package cn.evilcoder.innerclass;

/**
 * User: evilcoder
 * Date: 2016/3/25
 * Time: 21:39
 */
public class MemberInnerClass {

  private int index;

  public MemberInnerClass(int index) {
    this.index = index;
  }

  public class Inner{
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
