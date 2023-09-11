// 1) random generate 10 integers between 1~100.
// 2) save them to an array;
// 3) print in a reserve order;
// 4) give the average;
// 5) give the max;
// 6) give the max's index;
// 7) find if there is a 8;

public class homework05{
	public static void main(String[] args){


		//define an array to save the 10 integers;
		int[] arr = new int[10];
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = (int)Math.round(100 * Math.random());
		}
		//print the array;
		System.out.println("The original array is:");
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println(" ");

		//save the original arr;
		int[] arrOriginal = new int[arr.length];
		for(int i = 0; i < arr.length ; i++){
			arrOriginal[i] = arr[i];
		}

		//sort in a reserve order;
		for( int i = 0; i < arr.length - 1; i++ ){
			for(int j = 0; j < arr.length - i - 1; j++){
				if(arr[j] < arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		//print the array;
		//give the average;
		System.out.println("The reserve order array is:");
		int sum = 0;
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
			sum += arr[i];
		} 
		System.out.println(" ");
		System.out.println("The average is " + sum / arr.length);
		System.out.println("The max number is " + arr[0]);

		//give the max's index;
		int index = 0;
		for(int i = 0 ; i < arrOriginal.length; i++){
			if (arrOriginal[i] == arr[0]){
				index = i;
			}
		}
		System.out.println("The max number is in the index " + index);

		//find if there is a 8;
		int index1 = -1;
		for(int i = 0 ; i < arrOriginal.length; i++){
			if (arrOriginal[i] == 8){
				System.out.println("There is a 8.");
				index1 = i;
			}
		}
		if (index1 == -1){
			System.out.println("There is no 8.");
			

		}







	}	

}