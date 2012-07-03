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
	public int getWidht() {
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
}
