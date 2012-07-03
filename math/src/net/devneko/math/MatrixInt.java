package net.devneko.math;

public class MatrixInt {
	private int width;
	private int height;
	private int[][] mat;
	public MatrixInt(int width, int height) {
		this.width = width;
		this.height = height;
		mat = new int[height][width];		
	}
	public int getValue(int x, int y) {
		return mat[y][x];
	}
	public void setValue(int x, int y, int value) {
		mat[y][x] = value;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public MatrixInt rotateRight() {
		MatrixInt m = new MatrixInt(height, width);
		for ( int y = 0; y < height; y++ ) {
			for ( int x = 0; x < width; x++ ) {
				int value = getValue(x,y);
				m.setValue(this.height - y, x, value);
			}
		}
		return m;
	}
	
	/**
	 * 単位行列を作成する.
	 * @param size
	 */
	public static MatrixInt unit(int size) {
		MatrixInt mat = new MatrixInt(size, size);
		for ( int i = 0; i < size; i++ ) {
			mat.setValue(i,i,1);
		}
		return mat;
	}
	
	/**
	 * 行列の積を計算する.
	 * @param m
	 * @return
	 */
	public MatrixInt intersect(MatrixInt m) {
		if ( getWidth() != m.getHeight() || getHeight() != m.getWidth() ) {
			throw new IllegalArgumentException("matrix size must be same.");
		}
		MatrixInt newMat = new MatrixInt(height, m.width);
		for ( int x = 0; x < m.width; x++ ) {
			for ( int y = 0; y < height; y++ ) {
				int sum = 0;
				for ( int i = 0; i < height; i++ ) {
					sum += getValue(x,i) * m.getValue(i,y);
				}
				newMat.setValue(x, y, sum);
			}
		}
		return newMat;
	}
}
