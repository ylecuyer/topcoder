
public class PaperRockScisQuals {

	public static int whoPassed(String[] players) {
		
		float scores[] = new float[players.length];
		
		for(int i = 0; i < scores.length; i++)
			scores[i] = 0;
		
		for(int i = 0; i < players.length; i++) {
			
			for(int j = i+1; j < players.length; j++) {
							
				int score = match(players[i], players[j]);
								
				if (score == 0) {
					
					scores[i] += 1f/2f;
					scores[j] += 1f/2f;
				}
				else if (score == 1) {
					
					scores[i] += 1;
					scores[j] += 0;
				}
				else if (score == 2) {
					
					scores[i] += 0;
					scores[j] += 1;
				}
				
			}
			
		}
			
		float best_score = scores[0];
		int best_player = 0;
		
		for(int i = 1; i < players.length; i++) {
			
			if (scores[i] > best_score) {
				best_score = scores[i];
				best_player = i;
			}
		}
		
		return best_player;
	}
	
	private static int match(String player1, String player2) {
		
		int victory1 = 0;
		int victory2 = 0;
		
		for(int i = 0; i < player1.length(); i++) {
			
			int result = vs(player1.charAt(i), player2.charAt(i));
			
			if (result == 1)
				victory1++;
			if (result == 2)
				victory2++;
			
		}
		
		if (victory1 == victory2)
			return 0;
		if (victory1 > victory2)
			return 1;
		if (victory2 > victory1)
			return 2;
		
		return -1;
	}
	
	private static int vs(char player1, char player2) {
		
		if (player1 == player2)
			return 0;
		
		if (player1 == 'P' && player2 == 'R')
			return 1;
		if (player1 == 'R' && player2 == 'S')
			return 1;
		if (player1 == 'S' && player2 == 'P')
			return 1;
		
		if (player2 == 'P' && player1 == 'R')
			return 2;
		if (player2 == 'R' && player1 == 'S')
			return 2;
		if (player2 == 'S' && player1 == 'P')
			return 2;
	
		return -1;
	}

	public static void main(String[] args) {

		//Test 1
		/*
		String players[] = {"PPRRS","PPRRP","PPRSP","PPSSP"};
		//Returns: 0
		//*/
		
		//Test 2
		/*
		String players[] = {"RRRRR","PPPPP","RRRRR","PPPPP"};
		//Returns: 1
		//*/
		
		//Test 3
		/*
		String players[] = {"RRRRR","PPPPP","SSSSS","PPPPP"};
		//Returns: 2
		//*/
		
		//Test 4
		/*
		String players[] = {"RRRRR","PPPPP","SSSSS","SSSSS","RRRRR","RRRRR"};
		//Returns: 0
		//*/
		
		//Test 5
		//*
		String players[] = {"PPRPS","RRRPR","SSPRS","SSPRR","PPRSP","SPRPS","SPRSP","PRSPR","PRSPR"};
		//Returns: 6
		//*/
		
		System.out.println(whoPassed(players));
		
	}

}
