public class PhysicsThread extends Thread{
    private PhysicsPanel active_panel;
    private int frame_rate;
    public PhysicsThread(PhysicsPanel active_panel,int frame_rate){
        this.active_panel = active_panel;
        this.frame_rate = frame_rate;
    }
    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(1000 / this.frame_rate);
                active_panel.update();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
