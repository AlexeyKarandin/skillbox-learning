public class Main {

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        boolean isHaveMasking;
        int firstIndex;
        int lastIndex;
        while (true) {
            isHaveMasking = (text.indexOf('<') != -1) && (text.indexOf('>') != -1);
            if (!isHaveMasking) {
                break;
            }
            firstIndex = text.indexOf('<');
            // +1 т.к. last не входит в диапазон
            lastIndex = text.indexOf('>') + 1;
            text = text.substring(0, firstIndex) + placeholder + text.substring(lastIndex);
            System.out.println(text);
        }
        return text;
    }

}