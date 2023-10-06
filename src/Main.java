import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Singleton storeInfo = Singleton.getInstance();


        Scanner scanner = new Scanner(System.in);

        PaymentStrategy paymentStrategy = null;

        while (true) {
            // Выводим список доступных товаров
            System.out.println("Доступные товары:");
            System.out.println("1. Донер - 1500 тенге");
            System.out.println("2. Айран - 200 тенге");
            System.out.println("3. Завершить выбор товаров и перейти к оформлению заказа");
            System.out.print("Введите номер товара (1/2) или 3 для завершения выбора: ");

            int choice = scanner.nextInt();

            if (choice == 3) {
                break; // Завершаем выбор товаров
            }

            if (choice < 1 || choice > 2) {
                System.out.println("Неверный выбор товара.");
                continue;
            }

            System.out.print("Введите количество товара: ");
            int quantity = scanner.nextInt();

            if (quantity <= 0) {
                System.out.println("Количество товара должно быть положительным.");
                continue;
            }

            // Добавляем выбранный товар в корзину
            if (choice == 1) {
                Product doner = new Product("Донер", 1500.0, quantity);
                cart.addProduct(doner);
            } else if (choice == 2) {
                Product ayran = new Product("Айран", 200.0, quantity);
                cart.addProduct(ayran);
            }
        }

        while (paymentStrategy == null) {
            System.out.println("Выберите метод оплаты:");
            System.out.println("1. Кредитная карта");
            System.out.println("2. PayPal");
            System.out.print("Введите номер выбранного метода: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтение перевода строки после ввода числа

            switch (choice) {
                case 1:
                    System.out.print("Введите номер кредитной карты: ");
                    String cardNumber = scanner.nextLine();
                    paymentStrategy = new CreditCard(cardNumber);
                    break;
                case 2:
                    System.out.print("Введите адрес электронной почты для Qiwi: ");
                    String email = scanner.nextLine();
                    paymentStrategy = new Qiwi(email);
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }

        cart.setPaymentStrategy(paymentStrategy);
        cart.checkout();
        // Получение и вывод информации о магазине
        String storeName = storeInfo.getStoreName();
        String storeAddress = storeInfo.getStoreAddress();
        String storeContact = storeInfo.getStoreContact();

        System.out.println("Название магазина: " + storeInfo.getStoreName());
        System.out.println("Адрес магазина: " + storeInfo.getStoreAddress());
        System.out.println("Контакты: " + storeInfo.getStoreContact());
    }
}
