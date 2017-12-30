import java.util.ArrayList;

public class DivideAndConquer implements DivideAndConquerInterface{

	public DivideAndConquer() {
		//
	}
	
	@Override
	public Tuple findMaxSubArray(ArrayList<Integer> arr, int low, int high) { // computes the maximum sub-array using the Divide and Conquer approach

		if(low == high) {
			return new Tuple(low, high, arr.get(low)); // base case
		} else { //
			
			int mid = (low + high) / 2;
			Tuple t1 = findMaxSubArray(arr, low, mid);
			Tuple t2 = findMaxSubArray(arr, (mid + 1), high);
			Tuple t3 = findMaxCrossingSubArray(arr, low, mid, high);
			
			if((t1.getX3() >= t2.getX3()) && (t1.getX3() >= t3.getX3())) {
				return t1;
			} else if((t2.getX3() >= t1.getX3()) && (t2.getX3() >= t3.getX3())) {
				return t2;
			} else {
				return t3;
			}
			
		}
		
	}

	@Override
	public Tuple findMaxCrossingSubArray(ArrayList<Integer> arr, int low, int mid, int high) { // sub-routine
		
		int leftSum = -Integer.MAX_VALUE;
		int rightSum = -Integer.MAX_VALUE;
		int sum = 0;
		int maxLeft = 0;
		int maxRight = 0;
		
		for(int i = mid; i >= low; i--) {
			
			sum = sum + arr.get(i);
			
			if(sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
			
		}
		
		sum = 0;
		
		for(int j = (mid + 1); j <= high; j++) {
			
			sum = sum + arr.get(j);
			
			if(sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
			
		}
		
		return new Tuple(maxLeft, maxRight, (leftSum + rightSum));
		
	}

}
