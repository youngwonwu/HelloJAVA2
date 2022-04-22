package co.micol.prj;
//public범위지시자
public class SelectionSort {
	
	private int i;
	private int j;
	private int min;
	
//	public int[] sort(int[] arr) {
//		for(i = 0; i < arr.length-1; i++) {	//-1을 빼도됨...왜//
//			min = i;
//			for(j = i + 1; j < arr.length; j++) {	//요소 비교
//				if(arr[min] > arr[j]) {	//오름차순으로 보이고 < 으로 하면 내림차순
//					min = j;
//				}
//			}
//			if(min != i) {	//swap,		if문은 한번에 해결하도록 써야함
//				int temp = arr[i];
//				arr[i] = arr[min];
//				arr[min] = temp;
//			}
//		}
//		return arr;
//	}
	
	
	//메인에서 출력하지 않고 여기서 출력할려면
	public void sort(int[] arr) {
		//초기데이터 출력
		arrPrint(arr);
		
		for(i = 0; i < arr.length-1; i++) {	//-1 마지막 배열은 비교 안해도 되니까,	근데 -1을 빼도됨 
			min = i;
			for(j = i + 1; j < arr.length; j++) {	//요소 비교
				if(arr[min] > arr[j]) {	//오름차순으로 보이고 < 으로 하면 내림차순
					min = j;
				}
			}
			if(min != i) {	//swap,		if문은 한번에 해결하도록 써야함
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		resultPrint(arr);
	}
	
	private void arrPrint(int[] arr) {
		System.out.println("========초기데이터========");
		for(int i : arr) {
			System.out.println(i + " ");
		}
		System.out.println("=======================");
	}
	
	
	private void resultPrint(int[] arr) {
		System.out.println("========결과데이터========");
		for(int i : arr) {
			System.out.println(i + " ");
		}
		System.out.println("=======================");
	}

}
