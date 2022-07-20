import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DAmazon2 {

	public static void main(String[] args) {
		List<String> logs = Arrays.asList(new String[] { "ykc 82 01", "e0 first qpx", "09z cat hamster", "06f 12 25 6",
				"az0 first qpx", "236 cat dog rabbit snake" });
		System.out.println(solve(logs));
	}

	public static List<String> solve(List<String> logs) {
		String[] logsArr = logs.stream().toArray(String[]::new);
		int old = logsArr.length - 1, nu = logsArr.length - 1;
		while (nu >= 0) {
			if (isDigitLog(logsArr[nu])) {
				String tmp = logsArr[nu];
				logsArr[nu] = logsArr[old];
				logsArr[old] = tmp;

				--old;
			}

			--nu;
		}

		Arrays.sort(logsArr, 0, old + 1, (x, y) -> {
			int sIdx = x.indexOf(' ');
			String xId = x.substring(0, sIdx);
			String xl = x.substring(sIdx + 1);

			sIdx = y.indexOf(' ');
			String yId = y.substring(0, sIdx);
			String yl = y.substring(sIdx + 1);

			if (xl.equals(yl)) {
				return xId.compareTo(yId);
			} else {
				return xl.compareTo(yl);
			}
		});

		logs = Arrays.asList(logsArr);
		return logs;
	}

	private static boolean isDigitLog(String log) {
		return Character.isDigit(log.charAt(log.indexOf(' ') + 1));
	}
}
