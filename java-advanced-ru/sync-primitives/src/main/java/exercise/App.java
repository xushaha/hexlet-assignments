package exercise;

class App {

    public static void main(String[] args) throws InterruptedException {
        // BEGIN
        SafetyList safetyList  = new SafetyList();
        Thread thread1 = new Thread(new ListThread(safetyList));
        Thread thread2 = new Thread(new ListThread(safetyList));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(safetyList.getSize());

        // END
    }
}
