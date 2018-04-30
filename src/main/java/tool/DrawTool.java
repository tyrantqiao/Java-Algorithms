package tool;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @author tyrantqiao
 */
public class DrawTool {
    public static void drawArray(double[] t){
        final int n=t.length;
        for(int i=0;i<n;i++){
            double x=1.0*i/n;
            double y=(double)t[i]/2.0;
            double rw=0.5/n;
            double rh=(double)t[i]/2.0;
            StdDraw.filledRectangle(x,y,rw,rh);
        }
    }
}
