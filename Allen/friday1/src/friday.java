
/*
ID: allenlu2
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

public class friday {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		File file = new File("friday.out");
		PrintWriter out = new PrintWriter(file);
		String day[] = { "Saturday ", "Sunday ", "Monday ", "Tuesday ", "Wednesday ", "Thursday ", "Friday " };
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numdays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, numtimes[] = { 0, 0, 0, 0, 0, 0, 0 };
		int startyear = 1900, startday = 0, startmonth = 1, startdate = 1, currentyear = 1900;
		int endyear = 1900 + (Integer.parseInt(st.nextToken())), i, currentday = 0, currentmonth = 1;
		boolean start = true;
		int prevday = 0, advance = 0; // 0 is Monday

		for (currentyear = 1900; currentyear < endyear; currentyear++) {
			if ((((currentyear % 4) == 0) && ((currentyear % 100) != 0)) || ((currentyear % 400) == 0)) {
				numdays[1] = 29;
			} else {
				numdays[1] = 28;
			}
			for (currentmonth = 0; currentmonth < 12; currentmonth++) {
				if (start == true) {
					advance = 12;
					start = false;
				} else {
					advance = numdays[(currentmonth + 11) % 12];

				}
				currentday = (advance + prevday) % 7;
				numtimes[currentday]++;
				prevday = currentday;
			}

		}
		for (i = 0; i < 7; i++) {
			if (i == 6) {
				out.print(numtimes[(i + 5) % 7] + "\n");
			} else {
				out.print(numtimes[(i + 5) % 7] + " ");
			}
		}
		out.close();

	}

}
