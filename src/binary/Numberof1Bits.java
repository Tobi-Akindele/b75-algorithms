package binary;

public class Numberof1Bits {

	public static void main(String[] args) {
		System.out.println(new Numberof1Bits().hammingWeight(00000000000000000000000000001011));
		// should return 1
	}

	public int hammingWeight(int n) {
        int res = 0;
        
//         while(n != 0) { Exceeding time limit because we have to visit all the bits.
//             res += n % 2;
            
//             n = n >> 1;
//         }
//         return res;
        
        while(n != 0) {
            n = n & (n - 1);
            res += 1;
        }
        
        return res;
    }
}
