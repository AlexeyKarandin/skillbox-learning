public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7843;

    int sum = sumDigits(7843);

    System.out.println(sum);

    // TODO homework_4.2
    System.out.println(Byte.MAX_VALUE);
    System.out.println(Byte.MIN_VALUE);
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Short.MAX_VALUE);
    System.out.println(Short.MIN_VALUE);
    System.out.println(Long.MAX_VALUE);
    System.out.println(Long.MIN_VALUE);
    System.out.println(Float.MAX_VALUE);
    System.out.println(-Float.MIN_VALUE);
    System.out.println(Double.MAX_VALUE);
    System.out.println(-Double.MIN_VALUE);
    System.out.printf("%.32f\n", -Double.MIN_VALUE);
    System.out.printf("%.8f\n", -Double.MAX_VALUE);

  }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */

  public static int sumDigits(Integer number) {

    int sum = 0;
    String numberString = Integer.toString(number);
    for (int i = 0; i < numberString.length(); i++) {
      sum += Integer.parseInt(Character.toString(numberString.charAt(i)));
    }
    return sum;
  }
}
