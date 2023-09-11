import java.util.Scanner;

public class homework02{
	public static void main(String[] args){
		Scanner	myscanner = new Scanner(System.in);
		System.out.println("Please input an int:");
		int a = myscanner.nextInt();
		if (a > 0) {
			System.out.println("This is an int that bigger than 0.");
		};
		if (a == 0){
			System.out.println("This is 0.");
		};
		if (a < 0){
			System.out.println("This is an int that smaller than 0.");
		};

	}

}
//check out if this int is bigger than 0 or other.