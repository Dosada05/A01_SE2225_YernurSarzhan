import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void addProduct(Product product) {
        items.add(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : items) {
            totalPrice += product.getTotalPrice();
        }
        return totalPrice;
    }


    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        double totalAmount = calculateTotalPrice();
        System.out.println("Общая сумма заказа: " + totalAmount + " тенге");

        if (paymentStrategy != null) {
            paymentStrategy.processPayment(totalAmount);
            System.out.println("Заказ успешно оформлен.");
        } else {
            System.out.println("Ошибка: метод оплаты не выбран.");
        }
    }
}
