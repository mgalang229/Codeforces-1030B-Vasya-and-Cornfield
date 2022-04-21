import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Author {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int n = fs.nextInt(), d = fs.nextInt();
			int m = fs.nextInt();
			int[] x = new int[m];
			int[] y = new int[m];
			for(int i = 0; i < m; i++) {
				x[i] = fs.nextInt();
				y[i] = fs.nextInt();
			}
			Point p1 = new Point(0, d);
			Point p2 = new Point(d, 0);
			Point p3 = new Point(n, n - d);
			Point p4 = new Point(n - d, n);
			double firstHalfArea = calculateTriangleArea(p1, p2, p3);
			double secondHalfArea = calculateTriangleArea(p1, p4, p3);
			double rectangleArea = firstHalfArea + secondHalfArea;
			for(int i = 0; i < m; i++) {
				boolean included = false;
				Point newPoint = new Point(x[i], y[i]);
				double firstTriangle = calculateTriangleArea(p1, newPoint, p2);
				double secondTriangle = calculateTriangleArea(p2, newPoint, p3);
				double thirdTriangle = calculateTriangleArea(p3, newPoint, p4);
				double fourthTriangle = calculateTriangleArea(p4, newPoint, p1);
				double totalArea = firstTriangle + secondTriangle + thirdTriangle + fourthTriangle;
				out.println(totalArea == rectangleArea ? "YES" : "NO");
			}
		}
		out.close();
	}
	
	static double calculateTriangleArea(Point p1, Point p2, Point p3) {
		return (double) Math.abs((p1.x * (p2.y - p3.y) +
				p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2.0);
	}
	
	static class Point {
		
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for(int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
		
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
