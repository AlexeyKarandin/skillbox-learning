public class Main {

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        boolean isHaveMasking = false;
        int frstIndex = 0;
        int lastIndex = 0;
        while (true) {
            isHaveMasking = text.indexOf('<') != -1 ? true : false;
            isHaveMasking = text.indexOf('>') != -1 ? true : false;
            if (!isHaveMasking) {
                break;
            }
            frstIndex = text.indexOf('<');
            // +1 т.к. last не входит в диапазон
            lastIndex = text.indexOf('>') + 1;
            text = text.substring(0, frstIndex) + placeholder + text.substring(lastIndex);
            System.out.println(text);
        }
        return text;
    }

}