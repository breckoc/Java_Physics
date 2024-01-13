public class PhysicsMain {
    public static void main(String[] args){
        PhysicsPanel physics_panel = new PhysicsPanel(600,600,0.1);
        Canvas canvas = new Canvas("Physics Engine",physics_panel);
        PhysicsThread physics_thread = new PhysicsThread(physics_panel,60);
        physics_thread.start();
    }
}
