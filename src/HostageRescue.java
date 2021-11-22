public class HostageRescue {

    private static final Police police = new Police();
    private static final Criminal criminal = new Criminal();

    public static void main(String[] args){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                police.giveRansom(criminal);
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                criminal.releaseHostage(police);
            }
        });

        thread2.start();
    }
}
