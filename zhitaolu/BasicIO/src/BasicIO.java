// reference to the scanner class which handle input from users
import java.util.Scanner;
public class BasicIO {
	String InputSource = "";
	String OutputSource = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read from key board
		StringInOut();
		//return null;
	};
	
	public static void StringInOut()
	{
		Scanner UserInput = new Scanner( System.in);
		
		
		//read a whole line
		String Input, FirstName, LastName, FullName;
		String End = "Done";
		Input = "";
		while( Input.compareTo( End ) != 0 )
		{
			System.out.print( "Enter your First Name:");
			Input = UserInput.next();
			FirstName = Input;
			System.out.print( "Enter your Last Name:");
			Input = UserInput.next();
			LastName = Input;
			FullName = FirstName + " " + LastName;
			if( LastName.compareTo( End) != 0 )
				System.out.println( "Full Name is:" + FullName);
			
		};
		System.out.println( "Done");
		//return null;
	};
	
	
}
