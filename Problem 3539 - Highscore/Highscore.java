import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Highscore {

	public static int getRank(int[] scores, int newscore, int places) {
		

		if (scores.length == 0)
			return 1;
		
		for(int i = 0; i < scores.length; i++) {
			
			if (newscore >= scores[i])
				if (!(i == scores.length-1 && scores[i] == newscore)) return i+1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {

		int[] scores = {2000000000, 19539, 19466, 19146, 17441, 17002, 16348, 16343,
				15981, 15346, 14748, 14594, 13752, 13684, 13336, 13290, 12939,
				12208, 12163, 12133, 11621, 11119, 10872, 10710, 10390, 9934,
				9296, 8844, 8662, 8653, 8168, 7914, 7529, 7354, 6016, 5428,
				5302, 5158, 4853, 4538, 4328, 3443, 3222, 2107, 2107, 1337,
				951, 586, 424, 31};
		int newscore = 1337;
		int places = 50;
		
		System.out.println(getRank(scores, newscore, places));
		
	}

}
