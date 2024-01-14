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
    public double getX(){
        return this.x;
    }
    public int getDrawX(){
        return (int) this.x - this.size/2;
    }
    public double getY(){
        return this.y;
    }
    public int getDrawY(){
        return (int) this.y - this.size/2;
    }
    public int getSize(){
        return this.size;
    }
    public int getRadius(){ return this.size/2; }
    public boolean outOfBounds(int width,int height){
        return this.x < -this.size || this.x > width || this.y < 0 || this.y > height;
    }
    public void handleCollision(PhysicsBumper collided_bumper){
        int m = 1;
        double total_velocity = Math.sqrt(this.x_velocity * this.x_velocity + this.y_velocity * this.y_velocity);
        if(collided_bumper.getY() > this.getY())
            m = -1;
        double x_diff = this.getX() - collided_bumper.getX();
        double y_diff = this.getY() - collided_bumper.getY();
        double angle_of_collision = Math.atan(x_diff/y_diff);
        this.x_velocity = m * total_velocity * Math.sin(angle_of_collision);
        this.y_velocity = m * total_velocity * Math.cos(angle_of_collision);


    }
}
