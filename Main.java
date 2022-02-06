package programmers_lv2;

import java.util.*;

public class Main {
	// static ArrayList<> arr = new ArrayList<>(); //전역변수
	static HashSet<Integer> hs = new HashSet<Integer>();

	public static void main(String[] args) {
		String numbers = "8118";
		int answer = solution(numbers);
		System.out.println("answer = " + answer);

	}

	public static int solution(String numbers) {
		int answer = 0;
		// String을 int배열로 변환하자.
		int[] num = new int[numbers.length()];
		for (int i = 0; i < num.length; i++) {
			num[i] = numbers.charAt(i) - '0';
			// System.out.println("num[" + i + "] = " + num[i]);
		}

		// 순열 알고리즘으로 숫자 뽑기
		int n = num.length;

		for (int i = 1; i <= n; i++) {
			LinkedList<Integer> perArr = new LinkedList<>();
			int[] perCheck = new int[n];
			permutation(n, i, perArr, perCheck, num);
		}

		Iterator<Integer> it = hs.iterator();
		
		while (it.hasNext()) {
			boolean flag = true;
			int isprimeNum = it.next();
			System.out.println("str = " + isprimeNum);
			if (isprimeNum== 0 || isprimeNum == 1 || isprimeNum == 2) {
				//System.out.println("continue");
				flag = false;
				continue;
			} else {
				for (int i = 2; i < isprimeNum; i++) {
					if(isprimeNum % i == 0) {
						flag = false;
						break;
					}
				}
			}
			if(flag) answer++;
		}
	

	return answer;

	}

	private static void permutation(int n, int r, LinkedList<Integer> perArr, int[] perCheck, int[] arr) {
		if (perArr.size() == r) {
			String str = "";
			for (int i : perArr) {
				str += i;
			}

			hs.add(Integer.parseInt(str));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (perCheck[i] == 0) {
				perArr.add(arr[i]); // 값을 넣는 부분
				perCheck[i] = 1;
				permutation(n, r, perArr, perCheck, arr);
				perCheck[i] = 0;
				perArr.removeLast();
			}
		}
	}

}
