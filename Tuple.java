public class Tuple { // assistant class that constructs custom tuples

	private int x1;
	private int x2;
	private int x3;
	
	public Tuple(int a, int b, int c) {
		
		this.x1 = a;
		this.x2 = b;
		this.x3 = c;
		
	}
	
	public int getX1() {
		return this.x1;
	}
	
	public int getX2() {
		return this.x2;
	}
	
	public int getX3() {
		return this.x3;
	}
	
	@Override
	public String toString() {
		return "(" + x1 + ", " + x2 + ", " + x3 + ")";
	}
	
}
