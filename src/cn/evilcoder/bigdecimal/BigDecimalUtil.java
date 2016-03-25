package cn.evilcoder.bigdecimal;

import java.math.BigDecimal;

/**
 * User: evilcoder
 * Date: 2016/3/25
 * Time: 23:38
 */
public class BigDecimalUtil {
  
  public static double add(double a,double b){
    BigDecimal aBig = BigDecimal.valueOf(a);
    BigDecimal bBig = BigDecimal.valueOf(b);
    return aBig.add(bBig).doubleValue();
  }
  public static double subtract(double a,double b){
    BigDecimal aBig = BigDecimal.valueOf(a);
    BigDecimal bBig = BigDecimal.valueOf(b);
    return aBig.subtract(bBig).doubleValue();
  }
  public static double multiply(double a,double b){
    BigDecimal aBig = BigDecimal.valueOf(a);
    BigDecimal bBig = BigDecimal.valueOf(b);
    return aBig.multiply(bBig).doubleValue();
  }
  public static double divide(double a,double b){
    BigDecimal aBig = BigDecimal.valueOf(a);
    BigDecimal bBig = BigDecimal.valueOf(b);
    return aBig.divide(bBig).doubleValue();
  }

  public static float add(double a,float b){
    BigDecimal aBig = BigDecimal.valueOf(a);
    BigDecimal bBig = BigDecimal.valueOf(b);
    return aBig.add(bBig).floatValue();
  }
  public static float subtract(float a,float b){
    BigDecimal aBig = BigDecimal.valueOf(a);
    BigDecimal bBig = BigDecimal.valueOf(b);
    return aBig.subtract(bBig).floatValue();
  }
  public static float multiply(float a,float b){
    BigDecimal aBig = BigDecimal.valueOf(a);
    BigDecimal bBig = BigDecimal.valueOf(b);
    return aBig.multiply(bBig).floatValue();
  }
  public static float divide(float a,float b){
    BigDecimal aBig = BigDecimal.valueOf(a);
    BigDecimal bBig = BigDecimal.valueOf(b);
    return aBig.divide(bBig).floatValue();
  }



}
