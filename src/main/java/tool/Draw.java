package tool;

import edu.princeton.cs.algs4.StdDraw;

public class Draw {
    public static void drawArray(double[] t){
        final int N=t.length;
        for(int i=0;i<N;i++){
            double x=1.0*i/N;
            double y=(double)t[i]/2.0;
            double rw=0.5/N;
            double rh=(double)t[i]/2.0;
            StdDraw.filledRectangle(x,y,rw,rh);
        }
    }
}
