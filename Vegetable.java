public class Vegetable{
    String color;
    int numLeaves;
    double length;
    String name;
    /**
     * Constructors don't have a return type!
     */
    public Vegetable(){
    color = "red";
    numLeaves = 4;
    length = 4.3;
    name = "Mortimer";
    }
    /**
     * Constructors can be overloaded
     */
    public Vegetable(String c, int nL, double l, String n){
        color =c;
        numLeaves = nL;
        length = l;
        name = n;
    }
    public void grow(){
        length += .2;
    }
    public void becomeSentient(){
        name = "god";
    }
    public String getColor(){ return color;}
    public int getNumLeaves() { return numLeaves; }
    public double getLength() { return length; }
    public String getName() { return name; }
}