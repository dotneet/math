package net.devneko.math;

public class Statistics {
	/** ���ς����߂� */
	public static double average(double[] datas) {
		double sum = 0;
		for ( double d : datas ) {
			sum += d;
		}
		return sum / datas.length;
	}
}
