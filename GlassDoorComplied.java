package interview.cerner;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.*;

public class GlassDoorComplied {
	
	public static boolean jollyJumper(int[] arr) {
		
		int n= arr.length;
		boolean[] diff= new boolean[n];
		for(int i=0;i<n-1;i++) {
			int d=Math.abs( arr[i+1]-arr[i]);
			if(d==0||d>n-1||diff[d]) {
	
				
				return false;
			}
			diff[d]=true;
		}
		System.out.print(Arrays.toString(diff));
		return true;
	}
	public  static long reverse(long num) {
		long reversed=0;
		while(num!=0) {
			long lsb= num%10;
			reversed=reversed*10+lsb;
			num=num/10;
		}
		return reversed;
	}
	
	public static void revSumPalindrome(long  num) {
		//int sum= num+ reverse(num);
		while(num< 4294967295l) {
			num+= reverse(num);
			if(num>4294967295l) {
				System.out.println("No palindrome exist");
			}
			if(num==reverse(num)) {
				System.out.println(num); 
				break;
			}
		}
	}
	public static String reverseWords(String str) {
		String[] arr= str.split("\\W+");
		int i=0;
		int j=arr.length-1;
		while(i<j) {
			String temp=arr[i];
			arr[i]=arr[j]; 
			arr[j]=temp;
			i++;
			j--;
		}
		String reversed="";
		for(String s:arr) {
			reversed+=s+ " ";
		}
		return reversed;
	}
	
	public static String wordToNumber(String str) {
		
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(Character.isAlphabetic(ch)) {
				sb.append(ch-'a');
			}
			else {
				return "none";
				
			}
		}
		return sb.toString();
	}
	public static void removeVowel(String str) {
		char[] arr=str.toCharArray();
		ArrayList<Character> vowelList= new ArrayList<>();
		vowelList.add('a');
		vowelList.add('e');
		vowelList.add('i');
		vowelList.add('o');
		vowelList.add('u');
		vowelList.add('A');
		vowelList.add('E');
		vowelList.add('I');
		vowelList.add('O');
		vowelList.add('U');
		
		for(char c:arr) {
			if(!vowelList.contains(c)) {
				System.out.print(c);
			}
		}
		
		
	}
	public static void printPascalTriangle(int rows) { 
		for (int i = 0; i < rows; i++) { 
			int number = 1; 
			System.out.printf("%" + (rows - i) * 2 + "s", ""); 
			for (int j = 0; j <= i; j++) { 
				System.out.printf("%4d", number); 
				number = number * (i - j) / (j + 1); 
			} 
			System.out.println(); 
			} 
		}

	
	public static void pascalTriangle(int n) {
		int[][] triangle= new int[n][n];
		for(int line=0;line<n;line++) {
			for(int i=0;i<=line;i++ ) {
				if(i==0||line==i) {
					triangle[line][i]=1;
				}
				else {
					triangle[line][i]=triangle[line-1][i-1]+triangle[line-1][i];
				}
				System.out.print(triangle[line][i]+" ");	
			}
			System.out.println();
		}
		
	}
	public static void KMP(char[] arr) {
		int[] p= new int[arr.length];
		int index=0;
		int i=1;
		while(i<arr.length) {
			if(arr[index]==arr[i]) {
				p[i]=index+1;
				index++;
				i++;
			}
			else {
				if(index==0) {
					i++;		
				}
				else {
					index=p[index-1];
				}
			}
		}
		System.out.print(Arrays.toString(p));
	}
	public static int binaryToDecimal(int num) {
		int pow_val=0;
		int decimal_num=0;
		
		while(num>0) {
			int lsb=num%10;
			System.out.println(num);
			if(lsb==1) {
				decimal_num+=Math.pow(2, pow_val);
			}
			pow_val++;
			num=num/10;
		}
		return decimal_num;
	}
	
	public static int binaryToDecimal(String num) {
		int decimal_num=0;
		int index=num.length()-1;
		int base=1;
		while(index>=0) {
			int lsb= num.charAt(index)-'0';
			decimal_num+= base*lsb;
			base=base*2;
			index--;	
			
		}
		return decimal_num;
	}
	
	public static String direction(int x1,int y1,int x2,int y2) {
		String dir="";
		if(y2>y1) {
			dir+="N";
		}
		if(y1>y2) {
			dir+="S";
		}
		if(x2>x1) {
			dir+="E";
		}
		if(x1>x2) {
			dir+="W";
		}
		if(dir.length()==0) return "here";
		return dir;
	}
	
	
	static int maxSum = 110; 
    static int arrSize = 5; 
  
    // variable to store 
    // states of dp 
    static int[][] dp = new int[arrSize][maxSum]; 
    static boolean[][] visit = new boolean[arrSize][maxSum]; 
	static int SubsetCnt(int i, int s, int arr[], int n) 
	    { 
	        // Base cases 
	        if (i == n)  
	        { 
	            if (s == 0) 
	            { 
	                return 1; 
	            } 
	            else
	            { 
	                return 0; 
	            } 
	        } 
	  
	        // Returns the value if a state is already solved 
	        if (visit[i][s + arrSize])  
	        { 
	            return dp[i][s + arrSize]; 
	        } 
	  
	        // If the state is not visited, then continue 
	        visit[i][s + arrSize] = true; 
	  
	        // Recurrence relation 
	        dp[i][s + arrSize] = SubsetCnt(i + 1, s + arr[i], arr, n) 
	                + SubsetCnt(i + 1, s, arr, n); 
	  
	        // Returning the value 
	        return dp[i][s + arrSize]; 
	    } 
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1= {5 ,1, 4, 2, -1, 6};
		//System.out.print(reverseWords("My Name, is sonet"));
//		revSumPalindrome(196);
//		removeVowel("Print this withOUt vowel");
//		printPascalTriangle(5);
//		KMP("abcabcabc".toCharArray());
//		System.out.print(isArm(1634));
		//abcd 0123        
		int arr[] = { 100, 2, 2, -4, -4 }; 
		//int arr[] = {2, 2, 2, -4, -4}; 
	    int n = arr.length; 
	    //findSets(arr);
	    System.out.println(SubsetCnt(0, 0, arr, n)); 
	    System.out.println(Character.isAlphabetic('a'));
	    System.out.println(Character.isDigit('1'));
	    System.out.print(direction(3,2,1,1));
		

	}

}
