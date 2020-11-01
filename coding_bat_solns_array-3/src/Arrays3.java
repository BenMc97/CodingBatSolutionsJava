import java.util.*;

public class Arrays3 {

	/* Consider the leftmost and rightmost appearances of some value in an array. 
	   We'll say that the "span" is the number of elements between the two inclusive. 
	   A single value has a span of 1. Returns the largest span found in the given array. 
	   (Efficiency is not a priority.) */
	
	
	public int maxSpan(int[] nums) {
		  int max=0;
		  for (int i=0; i<nums.length;i++){
		    for (int j=0; j<nums.length;j++){
		      if(nums[i]==nums[j] && j-i+1>max){
		        max=j-i+1;
		      }
		    }
		  }
		  return max;
		}
	
	
	/*Return an array that contains exactly the same numbers as the given array, but rearranged 
      so that every 3 is immediately followed by a 4. Do not move the 3's, but every other number 
      may move. The array contains the same number of 3's and 4's, every 3 has a number after it 
      that is not a 3, and a 3 appears in the array before any 4.*/
	
	
	public int[] fix34(int[] nums) {
		  for(int i=0; i<nums.length-1; i++){
		    if(nums[i]==3){
		      int temp = nums[i+1];
		      nums[i+1]=4;
		      for (int j=i+2; j<nums.length; j++){
		        if(nums[j]==4){
		          nums[j]=temp;
		        }
		      }
		    }
		  }
		  return nums;
		}
	
	
	/*(This is a slightly harder version of the fix34 problem.) Return an array that contains exactly 
	   the same numbers as the given array, but rearranged so that every 4 is immediately followed by a 5. 
	   Do not move the 4's, but every other number may move. The array contains the same number of 4's 
	   and 5's, and every 4 has a number after it that is not a 4. In this version, 5's may appear anywhere 
	   in the original array.*/
	
	
	public int[] fix45(int[] nums) {
		
		  for(int i=0; i<nums.length; i++){
				    if(nums[i]==5 && i==0 || nums[i]==5 && nums[i-1]!=4){
				      int pos5 = i;
				      for(int j=0; j<nums.length; j++){
				        if(nums[j]==4 && nums[j+1]!=5){
				          int temp=nums[j+1];
				          nums[j+1]=5;
				          nums[pos5]=temp;
				          break;
				        }
				      }
				    }
				  }
		  return nums;
		}
	
	
	/*Given a non-empty array, return true if there is a place to split the array so that the sum of the 
	  numbers on one side is equal to the sum of the numbers on the other side.*/
	
	
	public boolean canBalance(int[] nums) {
		  double sum=0;
		  double sumSoFar=0;
		  for(int i=0; i<nums.length; i++){
		    sum+=nums[i];
		  }
		  for (int j=0; j<nums.length; j++){
		    sumSoFar+=nums[j];
		    if(sumSoFar==sum/2){
		      return true;
		    }
		  }
		  return false;
		}
	
	
	/*Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers 
	  in inner appear in outer. The best solution makes only a single "linear" pass of both arrays, taking 
	  advantage of the fact that both arrays are already in sorted order.*/
	
	
	public boolean linearIn(int[] outer, int[] inner) {
		  HashSet<Integer> s1 = new HashSet<Integer>();
		  HashSet<Integer> s2 = new HashSet<Integer>();
		  
		  for(int i=0; i<outer.length; i++){
		      s1.add(outer[i]);
		  }
		  for(int j=0; j<inner.length; j++){
		      s2.add(inner[j]);
		  }
		  if(s1.containsAll(s2)){
		    return true;
		  }
		  return false;
		}
	
	
	/*Given n>=0, create an array length n*n with the following pattern, shown here for 
	  n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).*/
	
	
	public int[] squareUp(int n) {
		  int[] arr = new int[n*n];
		  
		  for(int i=0; i<n; i++){
		    for(int j=0; j<n; j++){
		      if(j<n-i-1){
		        continue;
		      }
		      arr[i*n +j]=n-j;
		    }
		  }
		  return arr;

		}
	
	
	/*Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} 
	  (spaces added to show the grouping). Note that the length of the array will be 1 + 2 + 3 ... + n, 
	  which is known to sum to exactly n*(n + 1)/2.*/
	
	
	public int[] seriesUp(int n) {
		  
		  ArrayList<Integer> arr= new ArrayList<>();
				
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=i; j++) {
					arr.add(j);
				}
			}

			Object[] arr1= arr.toArray();
			
			int[] arr2 = new int[arr1.length];
			
			for(int i=0; i<arr1.length;i++) {
				arr2[i]=(int)arr1[i];
			}
			return arr2;
		}
	
	
	/*We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere 
	  in the array, the same group appears in reverse order. For example, the largest mirror section in 
	  {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the largest mirror section 
	  found in the given array.*/
	
	
	public int maxMirror(int[] nums) {
		
	    ArrayList<Integer> a = new ArrayList<>(); 
	    ArrayList<Integer> b = new ArrayList<>();
		
		
		for(int i=0;i<nums.length;i++) {
			a.add(nums[i]);
		}
		for(int j=nums.length-1; j>=0; j--) {
			b.add(nums[j]);
		}	

		ArrayList<List> c = new ArrayList<>();
		ArrayList<List> d = new ArrayList<>();
		
		for(int i=0; i<a.size();i++) {
			for(int j=i; j<a.size();j++) {
				c.add(a.subList(i,j+1));
			}
		}
		for(int i=0; i<b.size();i++) {
			for(int j=i; j<b.size();j++) {
				d.add(b.subList(i,j+1));
			}
		}
		
		ArrayList<List> e = new ArrayList<>();
		
		for(int i=0; i<d.size();i++) {
			if(c.contains(d.get(i))) {
				e.add(d.get(i));
			}
		}
		
		int max=0;
		
		for(int i=0; i<e.size(); i++) {
			if(e.get(i).size()>max) {
				max = e.get(i).size();
			}
		}
		return max;
		}
	
	
	/* Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. 
	   Return the number of clumps in the given array.*/
	
	
	public int countClumps(int[] nums) {
		  int clumps=0;
		  boolean isClump=false;
		  for(int i=0; i<nums.length-1; i++){
		    if(isClump){
		      if(nums[i]!=nums[i+1]){
		        isClump=false;
		      }
		    }
		    else if(nums[i]==nums[i+1]){
		      isClump=true;
		      clumps++;
		    }
		  }
		  return clumps;
		}

}
