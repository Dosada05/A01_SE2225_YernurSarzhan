public class Singleton {
    private String storeName;
    private String storeAddress;
    private String storeContact;

    // Приватный конструктор для предотвращения создания экземпляров извне
    private Singleton() {
        // Инициализация данных магазина
        this.storeName = "Донерная";
        this.storeAddress = "Улица Магазинная, 123";
        this.storeContact = "Телефон: 111111111, Email: mailmail";
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getStoreContact() {
        return storeContact;
    }

    // Приватный внутренний класс для ленивой инициализации экземпляра Singleton
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
