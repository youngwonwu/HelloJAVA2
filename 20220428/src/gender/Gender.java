package gender;

public class Gender {

	public static void main(String[] args) {

		String[] arr = {"010102-4","991012-1","960304-1","881012-2","040403-3"};
		int secondNum;
		int countMen = 0;
		int countWomen = 0;
		
		for (int i = 0; i < arr.length; i++) {
			secondNum = Integer.parseInt(arr[i].substring(7));
			
			if (secondNum == 1) {
				countMen++;
			} else if (secondNum == 2) {
				countWomen++;
			} else if (secondNum == 3) {
				countMen++;
			} else if (secondNum == 4) {
				countWomen++;
			}
		}
		System.out.println("남" + countMen + "여" + countWomen);

	}

}
