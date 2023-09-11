public class homework09{
	public static void main(String[] args){
		// 1 + (1+2) + (1+2+3) +..(1+2+..+100) sum;
		int Line = 1;
		int sum = 0;
		for (; Line <= 100; Line++){
			for(int count = 1; count <= Line; count++)
			sum = sum + count;

		}
		System.out.println(sum);

	}
}