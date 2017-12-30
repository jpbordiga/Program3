import java.util.ArrayList;

public class Kadane implements KadaneInterface{

	public Kadane() {
		//
	}
	
	@Override
	public int maxSubSum(ArrayList<Integer> arr) { // computes the maximum sub-array using Kadane's method
		
		int maxSumSoFar = 0;
		int maxSumToK = 0;
		
		for(int k = 0; k <= arr.size() - 1; k++) { // incremental
			
			maxSumToK = maxSumToK + arr.get(k);
			
			if(maxSumToK < 0) {
				maxSumToK = 0;
			}
			
			if(maxSumSoFar < maxSumToK) {
				maxSumSoFar = maxSumToK;
			}
			
		}
		
		return maxSumSoFar;
		
	}
	
}
