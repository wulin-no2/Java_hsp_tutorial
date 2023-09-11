public class homework08{
	public static void main(String[] args){
		Double sum = 0d;
		int numbers = 1;
		for (; numbers <= 100; numbers++ ){
			if (numbers % 2 != 0){
				sum = sum + 1.0/numbers;
			}
			else {
				sum = sum - 1.0/numbers;
			}


		}
		System.out.println(sum);
	}
}
