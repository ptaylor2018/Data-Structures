
/**
 * Write a description of class veggieStuff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VeggieStuff
{
    public static void main(String []args){    
        Vegetable a = new Vegetable();
        Vegetable b = new Vegetable("Yellow", 2, 7.2, "Maxine");
        
        Vegetable c = b;
        
        b.grow();
        
        System.out.println(c.getLength());
        System.out.println (a);
        /**
         * Prints 7.4 b/c
         * When you say c = b, c is the same object as b, NOT a copy
         * 
         * Object variables interally in java are POINTERS
         * (as are arrays)
         */
        
        
    }
}
