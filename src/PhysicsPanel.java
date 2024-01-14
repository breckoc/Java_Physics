import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class PhysicsPanel extends JPanel {
    private double gravity;
    private PhysicsMouseListener physics_mouse_listener;
    private PhysicsKeyListener physics_key_listener;
    private List<PhysicsBall> physics_balls = new LinkedList<>();
    private List<PhysicsBumper> physics_bumpers = new LinkedList<>();
    public PhysicsPanel(int width,int height,double gravity){
        setPreferredSize(new Dimension(width,height));
        setLayout(null);
        setVisible(true);
        setFocusable(true);
        this.physics_mouse_listener = new PhysicsMouseListener(this);
        addMouseListener(this.physics_mouse_listener);
        this.physics_key_listener = new PhysicsKeyListener(this);
        addKeyListener(this.physics_key_listener);
        this.gravity = gravity;
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
        for(PhysicsBall ball:this.physics_balls){
            g.fillOval(ball.getDrawX(),ball.getDrawY(),ball.getSize(),ball.getSize());
        }
        for(PhysicsBumper bumper:this.physics_bumpers){
            g.fillOval(bumper.getDrawX(), bumper.getDrawY(), bumper.getSize(), bumper.getSize());
        }

    }
    public void update(){
        PhysicsBall ball;
        for(int i = 0; i < this.physics_balls.size(); i++){
            ball = this.physics_balls.get(i);
            ball.applyGravity(this.gravity);
            ball.update();
            if(ball.outOfBounds(this.getWidth(),this.getHeight())) {
                physics_balls.remove(ball);
                i--;
            }
        }
        for(PhysicsBall curr_ball:this.physics_balls){
            for(PhysicsBumper curr_bumper:this.physics_bumpers){
                if(distance(curr_ball.getX(),curr_ball.getY(),curr_bumper.getX(),curr_bumper.getY())
                        <= curr_ball.getRadius() + curr_bumper.getRadius()){
                    curr_ball.handleCollision(curr_bumper);
                }
            }
        }
        repaint();
    }
    public void addPhysicsBall(int x,int y){
        this.physics_balls.add(new PhysicsBall(x,y,0,0,30));
    }
    public void addPhysicsBumper(int x,int y){
        this.physics_bumpers.add(new PhysicsBumper(x,y,50));
    }
    public void clearPanel(){
        this.physics_balls.clear();
        this.physics_bumpers.clear();
    }
    public double distance(double x1,double y1,double x2, double y2){
        double x_diff = x2-x1;
        double y_diff = y2-y1;
        return Math.sqrt(x_diff * x_diff + y_diff * y_diff);
    }
}
