import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr = new int[]{99, -90, 24, 10, -122, -98, 19, 9, 75};
		System.out.println("Given unsorted array: [99, -90, 24, 10, -122, -98, 19, 9, 75]");
		System.out.println("ShellSort:");
		System.out.println(Arrays.toString(shellSort(arr)));
	}

	public static int[] shellSort(int[] arr) {
		int gap = arr.length / 2;		// 4
		int end = arr.length / 2;
		int multiplier = 0;

		// First run should be once
		// Runs in log(n) time
		while (gap >= 1) {

			// First pass, gap = 4
			// Second pass, gap = 2
			// Third pass, gap = 1

			// [24, -90, 99, 10]

			// While end doesn't reach the end and there's a swap
			// Runs in n time
			while (end <= arr.length - 1) {
				if (end - (++multiplier * gap) < 0) {
					end++;
					multiplier = 0;
				} else {
					if (arr[end - (multiplier * gap)] > arr[end - (--multiplier * gap)]) {
						int tmp = arr[end - (multiplier * gap)];
						arr[end - (multiplier * gap)] = arr[end - (++multiplier * gap)];
						arr[end - (multiplier * gap)] = tmp;
					} else {
						end++;
						multiplier = 0;
					}
				}
			}

			gap /= 2;
			end = gap;
		}
		// ShellSort runtime = nlog(n)
		return arr;
	}
}