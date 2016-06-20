package cn.evilcoder.innerclass;

/**
 * User: evilcoder
 * Date: 2016/3/25
 * Time: 22:01
 */
public class LocalInnerClass {
  private int index;

  public LocalInnerClass(int index) {
    this.index = index;
  }

  public void test(){
    class Inner{
      String username;
      String password;

      public Inner(String username, String password) {
        this.username = username;
        this.password = password;
      }

      @Override
      public String toString() {
        return username+":"+password+":"+index;
      }
    }

    System.out.println(new Inner("name","pass"));
  }
}
