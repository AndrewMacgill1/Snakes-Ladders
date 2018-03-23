

public class Player {
	
	int position=0;
	
	public void playerPiece() {
		
	}
	
	public boolean win(int a) {
		if (position == a) {
			return true;
		}
		
		else return false;
	}
	
}

