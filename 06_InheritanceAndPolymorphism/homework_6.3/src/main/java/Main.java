public class Main {
    public static void main(String[] args) {
        IndividualBusinessman individualBusinessman = new IndividualBusinessman(1000.0);
        LegalPerson legalPerson = new LegalPerson(1000.0);

        // протестируем методы которые переопределили
        legalPerson.take(100.0);
        System.out.println("После снятия: " + legalPerson.getAmount());
        individualBusinessman.put(100.0);
        System.out.println("После пополнения на сумму менее 1000р: " + individualBusinessman.getAmount());
        individualBusinessman.put(1001.0);
        System.out.println("После пополнения на сумму менее 1000р: " + individualBusinessman.getAmount());
    }
}
