import java.util.ArrayList;

public class String3 {
	
	/* Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in 
	   "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). 
	   We'll say that a y or z is at the end of a word if there is not an alphabetic letter 
	   immediately following it.*/
	
	public int countYZ(String str) {
		str = str.toLowerCase();
		int count = 0;

		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='y' || str.charAt(i)=='z') {
				if(i < str.length() -1 && !Character.isLetter(str.charAt(i+1))) {
					count++;
				}
				else if(i == str.length()-1) {
					count++;
				}
			}
		}
		return count;
	}
	
	
	/* Given two strings, base and remove, return a version of the base string where all instances 
	   of the remove string have been removed (not case sensitive). You may assume that the remove 
	   string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" 
	   leaves "x".*/

	public String withoutString(String base, String remove) {
		
		
		int blen = base.length();
		int rlen = remove.length();
		String blow = base.toLowerCase();
		String rlow = remove.toLowerCase();
		String temp="";
		  
		for (int j=0; j<rlen; j++) {
		 temp+="1";
		}
		
	    for(int i=0; i<blen-rlen; i++) {
			if(blow.substring(i,i+rlen).equals(rlow)) {
				base=base.replace(base.substring(i,i+rlen), temp);
				i++;
			}
		}
		base = base.replace("1", "");
			
		return base;
	}
	
	/* Given a string, return true if the number of appearances of "is" anywhere in 
	   the string is equal to the number of appearances of "not" anywhere in the string 
	   (case sensitive).*/
	
	public boolean equalIsNot(String str) {
		int is_count = 0;
		int not_count = 0;
		  
		for(int i=0; i<str.length()-1; i++){
		    if(str.substring(i,i+2).equals("is")){ 
		      is_count++;
		    }
		}
		  
		for(int j=0; j<str.length()-2; j++){
		    if(str.substring(j,j+3).equals("not")){
		        not_count++;
		    }
		}
	
		if(is_count == not_count){
		    return true;
		}
		return false;
	}
	
	/* We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' 
	   immediately to its left or right. Return true if all the g's in the given string 
	   are happy.*/
	
	public boolean gHappy(String str) {
		
		int g_count = 0;
		int happy_count = 0;

		for (int i=0; i<str.length(); i++){
		    if(str.charAt(i)=='g'){
		      g_count++;
		    }
		} 
		//Case 1: g at start
		if(str.length()>=2 && str.substring(0,2).equals("gg")){
		    happy_count++;
		}  
		//Case 2: g in middle
		for(int i=1; i<str.length()-1; i++){
		    if(str.substring(i,i+2).equals("gg") || str.substring(i-1,i+1).equals("gg")){
		      happy_count++;
		    }
		} 
		//Case 3: g at end
		if(str.length()>=2 && str.substring(str.length()-2,str.length()).equals("gg")){
		    happy_count++;
		}
		if(g_count == happy_count){
		    return true;
		}
		return false;
	}
	
	/* We'll say that a "triple" in a string is a char appearing three times in a row. Return the 
	   number of triples in the given string. The triples may overlap.*/

	public int countTriple(String str) {

		int triple_count = 0;
		  
		for(int i=0; i<str.length()-2; i++){
		    if(str.charAt(i)==str.charAt(i+1) && str.charAt(i+1)==str.charAt(i+2)){
		      triple_count++;
		    }
		}
		return triple_count;
	}
	
	/* Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other 
	   characters. Return 0 if there are no digits in the string.*/
	
	
	public int sumDigits(String str) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		int sum = 0;
			
		for(int i=0; i<str.length(); i++){
		    if(Character.isDigit(str.charAt(i))) {
			    arr.add((int) str.charAt(i)-48);
		    }
		}
		for(int j=0; j<arr.size(); j++) {
			sum+=arr.get(j);
		}
		return sum;
		  
	}
	
	/* Given a string, return the longest substring that appears at both the beginning and end of the string 
	   without overlapping. For example, sameEnds("abXab") is "ab".*/
	
	public String sameEnds(String string) {
		
		int slen = string.length();
		String result = "";
		String temp = "";
		  
		for(int i=0; i<slen; i++){
			
		    temp+=string.charAt(i);
		    int templen = temp.length();
		    if(i<slen/2 && temp.equals(string.substring(slen-templen, slen))){
		      result = temp;
		    }
		}
		return result;
	}
	
	/* Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string. 
	   In other words, zero or more characters at the very begining of the given string, and at the very end of the 
	   string in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".*/
	
	public String mirrorEnds(String string){

		int slen = string.length();
		String result = "";
		String reversed = "";
			  
		for(int i=slen-1; i>=0; i--){
			reversed+=string.charAt(i);
		}
		for(int j=0; j<slen; j++) {
		    if(string.charAt(j)==reversed.charAt(j)) {
			    result+=string.charAt(j);
		    }
		    if(string.charAt(j)!=reversed.charAt(j)) {
		        break;
		    }
	    }
		return result;
	}
	
	/* Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars 
	   that are the same.*/
	
	public int maxBlock(String str) {
		int count = 1;
		int temp = 1;
		int blocks = 0;

		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i)==str.charAt(i-1)){
				count++;
			}
		    if(str.charAt(i)!=str.charAt(i-1) && count>temp) {
		    	temp = count;
		    	count = 1;
		    } 
		    if(str.charAt(i)!=str.charAt(i-1) && count<=temp) {
		    	count = 1;
		    } 
		    blocks = Math.max(temp, count);
		}
			return blocks;
	}
	
	/* Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. 
	   A number is a series of 1 or more digit chars in a row.*/
	
	public int sumNumbers(String str) {

		String[] s = str.split("[\\D]");
		int sum = 0;
			
		for(int i=0; i<s.length; i++) {
			if(!s[i].isEmpty()) {
				sum+=Integer.parseInt(s[i]);
			}
		}
		return sum;
	}
	
	/* Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not". 
	   The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" 
	   does not count.*/
	
	public String notReplace(String str) {
		
		String result = "";
		int length = str.length();
		
		for(int i=0; i<length; i++) {
			if(i-1 >= 0 && Character.isLetter(str.charAt(i-1)) || i+2 < length && Character.isLetter(str.charAt(i+2))) {
				result += str.charAt(i);
			}
			else if(i+1 < length && str.substring(i,i+2).equals("is")) {
				result+= "is not";
				i++;
			}
			else {
				result += str.charAt(i);
			}
		}
		
		return result;
	}

}
