
import jdk.jfr.Timespan;

public class rectangle {
    class Rectangle{
        private double length;
        private double width;
    
    public Rectangle(double length,double width){
        this.length=length;
        this.width=width;

    }
    public double getArea(){
        return length*width;
    }
    public double getPerimeter(){
        return2*(length+width);
    }
    public void displayinfo(){
        System.out.println("Rectangle[Length:"+length+",width:"+width+"]");
        System.out.println("Area:"+)
    }
}
