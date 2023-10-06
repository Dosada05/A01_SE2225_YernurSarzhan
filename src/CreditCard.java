public class CreditCard implements PaymentStrategy {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Оплачено " + amount + " тенге используя кредитную карту " + cardNumber);
    }
}