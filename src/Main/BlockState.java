package Main;

public class BlockState {
	private boolean isMine;
	private boolean isFlagged;
	private boolean wasClicked;
	private int numMines;
	
	public BlockState(){
		isFlagged = false;
		wasClicked = false;
		numMines = 0;
	}
	
	//mutators
	public void addAdjacentMine(){
		numMines++;
		return;
	}
	public void setMine(){
		isMine = true;
	}
	public void setNotMine(){
		isMine = false;
	}
	public void setFlag(){
		isFlagged = true;
	}
	public void removeFlag(){
		isFlagged = false;
	}
	public void clicked(){
		wasClicked = true;
	}
	
	//accessors
	public boolean getWasClicked(){
		return wasClicked;
	}
	public boolean getIsMine(){
		return isMine;
	}
	public int getNumMines(){
		return numMines;
	}
	public boolean getIsFlagged(){
		return isFlagged;
	}
}