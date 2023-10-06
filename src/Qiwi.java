public class Qiwi implements PaymentStrategy {
    private String email;

    public Qiwi(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Оплачено " + amount + " тенге используя Qiwi " + email);
    }
}