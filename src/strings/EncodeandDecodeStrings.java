package strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings {

	public static void main(String[] args) {
		EncodeandDecodeStrings obj = new EncodeandDecodeStrings();
		String encoded = obj.encode(new String[] {"lint","code","love","you"});
		System.out.println("Encoded: " + encoded); // should return 4#lint4#code4#love3#you
		
		System.out.println("Decoded: " + obj.decode(encoded)); // should return [lint, code, love, you]
	}

	public String encode(String[] strs) {
		String res = "";
		
		for(String s: strs) {
			res += s.length() + "#" + s;
		}
		return res;
	}
	
	public List<String> decode(String str) {
		List<String> res = new ArrayList<>();
		int i = 0;
		
		while (i < str.length()) {
			int length = Integer.parseInt(Character.toString(str.charAt(i)));
			res.add(str.substring(i + 2, length + 2 + i));
			i += length + 2;
		}
		return res;
	}
}
