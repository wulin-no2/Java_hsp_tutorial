public class homework04{
	public static void main(String[] args){
		//exists an array, ascending order
		// the request is, if insert an element, the array is still an ascending order.
		// analyz:
		//insert and sort;

		// 1) int arr1,num;
		// 2) int arr2,lenth + 1;


		int[] arr1 = {10, 12, 45, 90};
		int num = 23;
		int[] arr2 = new int[arr1.length + 1];

		// 3) insert num to the last number of arr2;

		for( int i = 0;i < arr2.length ;i++){
			if (i < arr2.length - 1){
				arr2[i] = arr1[i];			
			}
			else if( i == arr2.length - 1){
				arr2[i] = num;
			}
		}

		// 4)compare num with arr2[i] and sort them.
		for(int i = arr2.length - 1; i >= 0; i--) {
			if (arr2[i] < arr2[i - 1]){
				int temp = arr2[i];
				arr2[i] = arr2[i - 1];
				arr2[i - 1] = temp;
			} 
			else{
				break;
			}

		}

		// 5) output the arr2:
		for(int i = 0; i < arr2.length; i++){
			System.out.print(arr2[i] + " ");

		}
		System.out.println(" ");


	}
}