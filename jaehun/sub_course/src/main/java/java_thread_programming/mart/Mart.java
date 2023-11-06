package java_thread_programming.mart;

public class Mart {
    private Store[] stores;

    public Mart(int storesNum) {
        stores = new Store[storesNum];
        for (int i = 1; i <= storesNum; i++) {
            stores[i - 1] = new Store(i + "매장");
        }
    }

    public void enterStore(int storeIndex) throws InterruptedException {
        stores[storeIndex].enter();
    }

    public void exitStore(int storeIndex) throws InterruptedException {
        stores[storeIndex].exit();
    }

    public void buyInSelectedStore(int storeIndex) throws InterruptedException {
        stores[storeIndex].buy();
    }

    public void sellInSelectedStore(int storeIndex) throws InterruptedException {
        stores[storeIndex].sell();
    }

    public int storesNum() {
        return stores.length;
    }

}
