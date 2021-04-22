/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon4;

/**
 *
 * @author Ahmad
 */
public class Dragon {
    private Turtle turtle;
    
    private Dragon(int n){
        int [] left ={0,0,0,2,4,5,5,5,5,5,10,42,74,81,85,85};
        int [] right={1,1,1,1,1,1,2,10,18,21,21,21,21,21,57,170};
        int [] up   ={0,1,2,2,2,2,2,2,5,21,37,42,42,42,42,42};
        int [] down ={0,0,0,0,1,5,9,10,10,10,10,10,23,85,149,165};
        
        double size = Math.max(left[n]+right[n], up[n]+down[n]);
        double x    =(right[n] - left[n]) / 2.0;
        double y    =(up[n] - down[n]) / 2.0;
        
        turtle = new Turtle(0.0, 0.0, 0.0);
        turtle.setXscale(x - size/2, x + size/2);
        turtle.setXscale(y - size/2, y + size/2);
    }   
    
    private void dragon(int n){
        if (n == 0){
            turtle.goForward(1.0);
        }
        
        else {
            dragon(n-1);
            turtle.turnLeft(90);
            nogard(n-1);
        }
    }
    
    private void nogard(int n){
        if (n == 0){
            turtle.goForward(1.0);
        }
        
        else {
            dragon(n-1);
            turtle.turnLeft(-90);
            nogard(n-1);
        }
    }
        
    
    /**
     * @param args the command line arguments
     */
    
    public static class player{
        static boolean havepotion;
        public int life;

        
        
    }
    
    private class Turtle {

        public Turtle() {
        }
        
        private Turtle(double d, double d0, double d1){
    }
        private void setXscale(double d, double d0) {
        }
        
        private void setYscale(double d, double d0) {
        }
        
        private void goForward(double d) {
        }
        
        private void turnLeft(int i) {
        }
        
     
    }
}
    

