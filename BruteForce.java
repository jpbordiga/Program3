import java.util.ArrayList;

public class BruteForce implements BruteForceInterface {

	public BruteForce() {
		//
	}
	
	@Override
	public Tuple findMaxSubArrayBruteForce(ArrayList<Integer> arr) { // tests every possible combination
		
		int largestSum = 0;
		int currentSum = 0;
		int i = 0;
		int j = 0;
		
		for(int a = 0; a < arr.size() - 1; a++) {
			
			currentSum = arr.get(a);
			
			largestSum = Integer.max(largestSum, currentSum);
				
			for(int b = a; b < arr.size() - 1; b++) {
				
				currentSum = currentSum + arr.get(b);
				
				if(currentSum >= largestSum) {
					
					largestSum = currentSum;
					
					i = a;
					j = b;
					
				}
			
			}
		}
		
		Tuple t = new Tuple(i, j, largestSum);
		
		return t;
		
	}
	
}
