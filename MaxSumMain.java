// JEFF BORDIGA
// 9/29/17
// PROJECT03

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MaxSumMain {

	private static final String OUTPUT = "test.txt"; // output file
	
	public static void main(String[] args) {
		
		String[] files = new String[6]; // list files is used for whole output file
		
		files[0] = "Data_8.txt";
		files[1] = "Data_16.txt";
		files[2] = "Data_64.txt";
		files[3] = "Data_1024.txt";
		files[4] = "Data_4096.txt";
		files[5] = "Data_65536.txt";
		
		PrintWriter outputStream = null;
		
		try{
			outputStream = new PrintWriter(new FileOutputStream(OUTPUT));

			for(int a = 0; a < files.length; a++) { // iterating for each file
				
				ArrayList<Integer> arr = createList(files[a]);
				int iter = files[a].length();
				
				// Brute Force

				BruteForce bF = new BruteForce();
				long sum1 = 0; // starting first timer
				CpuTimer timer1 = new CpuTimer();
				
				for (long i = 0; i < 100_000_000; ++i){
				      sum1 += i;
				}
				
				for(int i = 0; i < iter; i++){
					if(a != 5) { // n became too large
					bF.findMaxSubArrayBruteForce(arr);
					}
				}
			
				float totalTime1 = (float) timer1.getElapsedCpuTime();  // computing timing values
				float avgTime1 = totalTime1 / iter;
		
				outputStream.println(arr.size() + ", BF, " + avgTime1); 
	
				// Divide and Conquer
			
				DivideAndConquer dAC = new DivideAndConquer();
				long sum2 = 0; // starting second timer
				CpuTimer timer2 = new CpuTimer();
				
				for (long i = 0; i < 100_000_000; ++i){
				      sum2 += i;
				}
				
				for(int i = 0; i < iter; i++){
					dAC.findMaxSubArray(arr, 0, arr.size() - 1);
				}
			
				float totalTime2 = (float) timer2.getElapsedCpuTime();  // computing timing values
				float avgTime2 = totalTime2 / iter;
				
				outputStream.println(arr.size() + ", DAC, " + avgTime2);
				
				// Kadane
				
				Kadane k = new Kadane();
				long sum3 = 0; // starting third timer
				CpuTimer timer3 = new CpuTimer();
				
				for (long i = 0; i < 100_000_000; ++i){
				      sum3 += i;
				}
				
				for(int i = 0; i < iter; i++){
					k.maxSubSum(arr);
				}
			
				float totalTime3 = (float) timer3.getElapsedCpuTime();  // computing timing values
				float avgTime3 = totalTime3 / iter;
	
				outputStream.println(arr.size() + ", KAD, " + avgTime3);
				
				outputStream.println();
				
				System.out.println("Brute Force: " + totalTime1); // included for the sake of knowing the total times
				System.out.println("Divide and Conquer: " + totalTime2);
				System.out.println("Kadane: " + totalTime3);
				System.out.println();

			}
			
			System.out.println("Time trial session complete.");

			
			outputStream.close();
			
			
		} catch(FileNotFoundException e){
			System.out.println("ERROR: unable to open file " + OUTPUT);
			System.exit(0);
		}
		
	}
	
	public static ArrayList<Integer> createList(String fN){ // constructs ArrayList from given file name
		      
		Scanner inFile = null;
		ArrayList<Integer> arr = new ArrayList<>();
	
		try{
			inFile = new Scanner(new FileInputStream(fN));
		} catch(FileNotFoundException e){
			System.out.println("ERROR: unable to open file " + fN);
			System.exit(0);
		}
		
		try{
			
			for(Integer i = inFile.nextInt(); i != null; i = inFile.nextInt()){
				arr.add(i);
			}
			
			
		} catch(NoSuchElementException e){ //
			//
		}
		return arr;
	}
	
}
