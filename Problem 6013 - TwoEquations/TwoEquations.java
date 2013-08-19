import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TwoEquations {

	public static String solve(String first, String second) {
		
		String regexp = "\\(?(-?\\d+)\\)?";
		
		Matcher matcher_first = Pattern.compile(regexp).matcher(first);
		
		matcher_first.find();
		int A = Integer.parseInt(matcher_first.group(1));
		
		matcher_first.find();
		int B = Integer.parseInt(matcher_first.group(1));
		
		matcher_first.find();
		int E = Integer.parseInt(matcher_first.group(1));
		
		Matcher matcher_second = Pattern.compile(regexp).matcher(second);
	
		matcher_second.find();
		int C = Integer.parseInt(matcher_second.group(1));
	
		matcher_second.find();
		int D = Integer.parseInt(matcher_second.group(1));
		
		matcher_second.find();
		int F = Integer.parseInt(matcher_second.group(1));
		
		//|A B||X| = |E|
		//|C D||Y| = |F|
		
		int det = (A*D - C*B);
		int detx = (E*D - B*F);
		int dety = (A*F - C*E);
			
		if (det == 0) {
		
			if (detx == 0 && dety == 0)
				return "MULTIPLE SOLUTIONS";
			else 
				return "NO SOLUTIONS";
		}
		else {
			
			
			
			
			int rx = gcd(Math.abs(detx), Math.abs(det));
			int ry = gcd(Math.abs(dety), Math.abs(det));
			
			if (det < 0) {
				rx *= -1;
				ry *= -1;
			}
			
			System.out.println("X=" + format_number(detx/rx) + "/" + format_number(det/rx) + " Y=" + format_number(dety/ry) + "/" + format_number(det/ry));
			
			
		}
		
		return "";
	}
	
	private static int gcd(int a, int b) {

		if (a == 0) return b;
		if (b == 0) return a;
		
		if (a > b) return gcd(b, a%b);
		
		return gcd(b, b%a);

	}




	private static String format_number(int x) {

		if (x < 0)
			return "("+x+")";
		else 
			return ""+x;
	}



	public static void main(String[] args) {
		
		//Test 1
		//*
		String first = "1*X + 2*Y = 6";
		String second = "1*X + (-4)*Y = (-3)";
		//Returns: "X=3/1 Y=3/2"
		//*/
		
		//Test 2
		/*
		String first = "(-3)*X + 0*Y = 7";
		String second = "0*X + 8*Y = 6";
		//Returns: "X=(-7)/3 Y=3/4"
		//*/
		
		//Test 3
		/*
		String first = "1*X + 0*Y = 1";
		String second = "1*X + 0*Y = 1";
		//Returns: "MULTIPLE SOLUTIONS"
		//*/
		
		//Test 4
		/*
		String first = "1*X + 3*Y = 1";
		String second = "2*X + 6*Y = (-1)";
		//Returns: "NO SOLUTIONS"
		//*/	
		
		//Test 5
		/*
		String first = "0*X + 0*Y = 0";
		String second = "(-3)*X + (-3)*Y = 0";
		//Returns: "MULTIPLE SOLUTIONS"
		//*/
			
		System.out.println(solve(first, second));

	}

}
