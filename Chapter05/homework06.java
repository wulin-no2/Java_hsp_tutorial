public class homework06{
	public static void main(String[] args){
		// 1) print numbers between 1 ~ 100,can't be divided by 5.
		// 2) not print numbers between 1~100, can be divided by 5.
		// 3) every 5 numbers a line.
		int goalNumber = 1;
		int count = 0;
		for (; goalNumber <= 100; goalNumber++){
			if(goalNumber % 5 != 0){
				System.out.print(goalNumber + " ");
				count++;
				if(count % 5 == 0){
					System.out.print("\n");
				};
			}; 

		}

	}

}