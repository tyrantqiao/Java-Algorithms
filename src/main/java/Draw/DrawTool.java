package Draw;


import Tool.RandomTool;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;
import java.util.Random;

/**
 * @author qiao
 * email: tyrantqiao@icloud.com
 * time: 2017/9/28 13:25
 */
public class DrawTool {
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

	public static void main(String[] args){
//		Arrays.asList("dwdw");
		drawArray(RandomTool.getArray(50));
	}
}
