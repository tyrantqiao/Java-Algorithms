package tool;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author qiao
 * email: tyrantqiao@icloud.com
 * time: 2017/9/28 14:21
 */
public class RandomTool {
	public static double[] getArray(int size){
		double[] a=new double[size];
		for(int i=0;i<size;i++){
			a[i]= StdRandom.uniform();
		}
		return a;
	}
}
