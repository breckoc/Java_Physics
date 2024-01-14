public class PhysicsBumper {
    private double x,y;
    private int size;
    public PhysicsBumper(double initial_x,double initial_y,int size){
        this.x = initial_x;
        this.y = initial_y;
        this.size = size;
    }
    public double getX(){   return this.x;  }
    public double getY(){   return this.y;  }
    public int getDrawX(){  return (int)this.x - this.size/2;   }
    public int getDrawY(){  return (int)this.y - this.size/2;   }
    public int getSize(){
        return this.size;
    }
    public int getRadius(){ return this.size/2; }

}
