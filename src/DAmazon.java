import java.util.HashMap;
import java.util.Map;

public class DAmazon {

	public static void main(String[] args) {
		System.out.println(new DAmazon().waysToSelect3("10111"));
		System.out.println(new DAmazon().waysToSelect3("01001"));
	}

	public int numberOfWays(String book) {
		
		if(book.length() <= 0 || book.length() > 2000000)
			return 0;
		
		int[] count0List = new int[book.length()];
		int[] count1List = new int[book.length()];

		int c0 = 0;
		int c1 = 0;

		for (int i = 0; i < book.length(); i++) {
			count0List[i] = c0;
			count1List[i] = c1;

			if (String.valueOf(book.charAt(i)).equals("1")) {
				c1++;
			}

			if (String.valueOf(book.charAt(i)).equals("0")) {
				c0++;
			}
		}

		int res = 0;
		for (int i = 1; i < book.length() - 1; i++) {
			
			if(String.valueOf(book.charAt(i)).equals("1")) {
				int m = count0List[i];
				int n = c0 - m;
				res += m * n;
			} else if (String.valueOf(book.charAt(i)).equals("0")) {
				int m = count1List[i];
				int n = c1 - m;
				res += m * n;
			}
			
		}
		
		return res;
	}
	
	public int waysToSelect3(String s) {
		Map<Integer, Integer> count1fromleft = new HashMap<Integer, Integer>();
		Map<Integer, Integer> count0fromleft = new HashMap<Integer, Integer>();
		int count0=0, count1=0;
    
    	for(int i=0; i<s.length(); i++) {
    		count1fromleft.put(i, count1);
    		count0fromleft.put(i, count0);
    		if(s.charAt(i) =='1') count1++;
        	if(s.charAt(i) =='0') count0++;        
    	}
    
    	int ans=0;
        //for 001001, on 1st iteration will produce m=0, but on 2nd iteration 1 will take care of that 0 possible cases. Like Heads Tails Heads
    	for(int i=1; i<s.length()-1; i++) {
            // check no of 0 from left of i and right of i, if s[i]==1 
        	if(s.charAt(i) =='1') {
	        	int m=count0fromleft.get(i), n=count0-m;        //multiplying number of 0s before (aka m) and after (aka n) this index
            	ans+=m*n;
        	} else if(s.charAt(i) =='0') {
        		int m=count1fromleft.get(i), n=count1-m;
        		ans+=m*n;
            }        
    	}    
    	return ans;
	}
}
