
/*
ID: allenlu2
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

public class beads {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		File file = new File("beads.out");
		PrintWriter out = new PrintWriter(file);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int length = Integer.parseInt(st.nextToken()), i = 0, j, max = 0, rightnum = 1, leftnum = 1, x = i;
		String necklace = f.readLine();
		char[] order = necklace.toCharArray();
		boolean blue = false, red = false, full = false;
		for (i = 0; i < length; i++) {
			// Determining first right char
			if (order[(i) % length] == 'r') {
				red = true;
			} else if (order[(i) % length] == 'b') {
				blue = true;
			} else {
				for (x = (i + 1) % length; x < length; x = (x + 1) % length) {
					if (x == length - 1) {
						full = true;
						break;
					}
					if (order[(x) % length] == 'r') {
						rightnum++;
						red = true;
						break;
					} else if (order[(x) % length] == 'b') {
						rightnum++;
						blue = true;
						break;
					}
					rightnum++;
				}
			}
			if (full == true) {
			}
			// Checking right side
			else {
				for (j = (x + 1) % length; j < length; j = (j + 1) % length) {
					if (j == x) {
						full = true;
						max = length;
						break;
					}
					if (blue == true && ((order[(j) % length]) == 'r')) {
						break;
					} else if (red == true && ((order[(j) % length]) == 'b')) {
						break;
					} else if (blue == true && ((order[(j) % length]) == 'b')) {
						rightnum++;
						red = false;
					} else if (blue == true && ((order[(j) % length]) == 'w')) {
						rightnum++;
					}
					else if (red == true && ((order[(j) % length]) == 'r')) {
						rightnum++;
						blue = false;
					} else if (red == true && ((order[(j) % length]) == 'w')) {
						rightnum++;
					}
				}
			}
			red = false;
			blue = false;
			x = i + (length);
			if (full == true) {
			} else {
				// Determining first left char
				if (order[(i + (length - 1)) % length] == 'r') {
					red = true;
				} else if (order[(i + (length - 1)) % length] == 'b') {
					blue = true;
				} else {
					for (x = (i + (length - 1)) % length; x < length; x = (x + (length - 1)) % length) {
						if (order[(x + (length - 1)) % length] == 'r') {
							leftnum++;
							red = true;
							break;
						} else if (order[(x + (length - 1)) % length] == 'b') {
							leftnum++;
							blue = true;
							break;
						}
						leftnum++;
					}
				} // Checking left side
				for (j = (x + (length - 2)) % length; j < length; j = (j + (length - 1)) % length) {
					if ((j + 1) == x) {
						max = length;
						break;
					}
					if (blue == true && ((order[(j) % length]) == 'r')) {
						break;
					} else if (red == true && ((order[(j) % length]) == 'b')) {
						break;
					} else if (blue == true && ((order[(j) % length]) == 'b')) {
						leftnum++;
						red = false;
					} else if (blue == true && ((order[(j) % length]) == 'w')) {
						leftnum++;
					}
					else if (red == true && ((order[(j) % length]) == 'r')) {
						leftnum++;
						blue = false;
					} else if (red == true && ((order[(j) % length]) == 'w')) {
						leftnum++;
					}
				}
			}
			if (rightnum + leftnum > max) {
				max = rightnum + leftnum;
			}
			if (max > length) {
				max = length;
			}
			rightnum = 1;
			leftnum = 1;
			red = false;
			blue = false;
			x = i + 1;
		}
		out.println(max);
		out.close();
	}
}
