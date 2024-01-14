import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PhysicsKeyListener implements KeyListener {
    private PhysicsPanel physics_panel;
    private Point mouse;
    public PhysicsKeyListener(PhysicsPanel physics_panel){
        this.physics_panel = physics_panel;
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_B){
            this.mouse = this.physics_panel.getMousePosition();
            if(this.mouse != null)
                this.physics_panel.addPhysicsBumper(this.mouse.x,this.mouse.y);
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.physics_panel.clearPanel();
        }
    }
}
