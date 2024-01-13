import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PhysicsMouseListener implements MouseListener {
    private PhysicsPanel physics_panel;
    public PhysicsMouseListener(PhysicsPanel physics_panel){
        this.physics_panel = physics_panel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {
        this.physics_panel.addPhysicsBall(e.getX(),e.getY());
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
