package hourglass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Hourglass {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<List<Integer>> arr = new ArrayList<>();
		Integer[][] rowcol = new Integer[6][];
		IntStream.range(0, 6).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
				Integer[] row = arr.get(i).toArray(new Integer[arr.get(i).size()]);
				rowcol[i] = row;
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		bufferedReader.close();
		int max = Integer.MIN_VALUE;
		int temp;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				temp = rowcol[i][j] + rowcol[i][j + 1] + rowcol[i][j + 2] + rowcol[i + 1][j + 1] + rowcol[i + 2][j]
						+ rowcol[i + 2][j + 1] + rowcol[i + 2][j + 2];
				if (temp > max) {
					max = temp;
				}
			}
		}
		System.out.println(max);
	}

}
