

public class Demo {
  public static void main(String[] args){
    int i = 0;
    while(i < 100){
        System.out.printf("%3d %8d %8d %10f %10f %n", i, 10 * i, i * i, Math.sqrt(i), Math.sin(i));
    }
  }
}