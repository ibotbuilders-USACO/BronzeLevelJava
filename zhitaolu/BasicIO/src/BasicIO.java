// reference to the scanner class which handle input from users
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BasicIO {
	String InputSource = "";
	String OutputSource = "";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// read from key board
		//StringInOut();
		FileInOut();
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
	
	public static void FileInOut() throws IOException
	{
		FileInputStream in = null;
        FileOutputStream out = null;

        try {
 
				in = new FileInputStream("src/xanadu.txt");
				out = new FileOutputStream("src/outagain.txt");	
				int c;

				while ((c = in.read()) != -1) {
					//display read in
					System.out.println( "reading in:"+c );					
					out.write(c);
				}
        	} finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

	};
}
