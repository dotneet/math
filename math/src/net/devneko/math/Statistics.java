package net.devneko.math;

public class Statistics {
	/** •½‹Ï‚ğ‹‚ß‚é */
	public static double average(double[] datas) {
		double sum = 0;
		for ( double d : datas ) {
			sum += d;
		}
		return sum / datas.length;
	}
	/** •ªU‚ğ‹‚ß‚é */
	public static double variance(double[] datas) {
		double avg = average(datas);
		double sum = 0;
		for ( double d : datas ) {
			double diff = (d - avg);
			sum += diff * diff;
		}
		return sum / datas.length;
	}
	/** •W€•Î·‚ğ‹‚ß‚é */
	public static double stddev(double[] datas) {
		return Math.sqrt(variance(datas));
	}
	/** ‹¤•ªU‚ğ‹‚ß‚é */
	public static double covariance(double[] datas1, double[] datas2) {
		assert(datas1.length == datas2.length);
		double avg1 = average(datas1);
		double avg2 = average(datas2);
		double sum = 0;
		for ( int i = 0; i < datas1.length; i++ ) {
			sum += (datas1[i] - avg1) * (datas2[i] - avg2);
		}
		return sum / datas1.length;
	}
	/** ‘ŠŠÖŒW”‚ğ‹‚ß‚é */
	public static double correlation(double[] datas1, double[] datas2) {
		double stddev1 = stddev(datas1);
		double stddev2 = stddev(datas2);
		double covari = covariance(datas1, datas2);
		return covari / (stddev1 * stddev2);
	}
}
