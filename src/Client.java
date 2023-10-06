public class Client {
    public static void main(String[] args) {
        Runnable task = () -> {
            Singleton storeInfo = Singleton.getInstance();
            System.out.println("Название магазина: " + storeInfo.getStoreName());
            System.out.println("Адрес магазина: " + storeInfo.getStoreAddress());
            System.out.println("Контакты: " + storeInfo.getStoreContact());
        };

        // Создаем несколько потоков, каждый из которых вызывает Singleton.getInstance()
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        // Запускаем потоки
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
