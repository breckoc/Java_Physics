import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class PhysicsPanel extends JPanel {
    private double gravity;
    private PhysicsMouseListener physics_mouse_listener;
    private List<PhysicsBall> physics_balls = new LinkedList<>();
    public PhysicsPanel(int width,int height,double gravity){
        setPreferredSize(new Dimension(width,height));
        setLayout(null);
        setVisible(true);
        this.physics_mouse_listener = new PhysicsMouseListener(this);
        addMouseListener(physics_mouse_listener);
        this.gravity = gravity;
        this.physics_balls.add(new PhysicsBall(50,50,0,0,40));
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
        for(PhysicsBall ball:this.physics_balls){
            g.fillOval(ball.getX(),ball.getY(),ball.getSize(),ball.getSize());
        }
    }
    public void update(){
        for(PhysicsBall ball:this.physics_balls){
            ball.applyGravity(this.gravity);
            ball.update();
        }
        repaint();
    }
    public void addPhysicsBall(int x,int y){
        this.physics_balls.add(new PhysicsBall(x,y,0,0,30));
    }
}
