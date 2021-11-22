public class Criminal {

    private boolean hostageReleased = false;

    public void releaseHostage(Police police){
        while(!police.isMoneySent()){
            System.out.println("Criminal: waiting for police to give ransom");

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Criminal: released hostage");
        hostageReleased = true;
    }

    public boolean isHostageReleased(){
        return hostageReleased;
    }
}
