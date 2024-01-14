import java.awt.*;

public class PhysicsBall {
    private double x,y,x_velocity,y_velocity;
    private int size;
    public PhysicsBall(double initial_x, double initial_y,double initial_x_velocity,double initial_y_velocity,int size){
        this.x = initial_x;
        this.y = initial_y;
        this.x_velocity = initial_x_velocity;
        this.y_velocity = initial_y_velocity;
        this.size = size;
    }
    public void applyGravity(double gravity_value){
        this.y_velocity += gravity_value;
    }
    public void update(){
        this.x += this.x_velocity;
        this.y += this.y_velocity;
    }
    public int getX(){
        return (int) this.x;
    }
    public int getY(){
        return (int) this.y;
    }
    public int getSize(){
        return this.size;
    }

    public boolean outOfBounds(int width,int height){
        return this.x < -this.size || this.x > width || this.y < 0 || this.y > height;
    }
}
