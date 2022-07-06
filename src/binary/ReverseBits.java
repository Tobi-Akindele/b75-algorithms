package binary;

public class ReverseBits {

	public static void main(String[] args) {
//		System.out.println(new ReverseBits().reverseBits(00000010100101000001111010011100));
	}

	public int reverseBits(int n) {
		int res = 0;
		
		for(int i = 0; i < 32; i++) {
			int bit = (n >> i) & 1;
			res = res | (bit << (31 - i));
		}
		return res;
	}
}
