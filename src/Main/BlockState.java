package Main;

public class BlockState {
	public boolean isMine;
	public boolean isFlagged;
	public boolean wasClicked;
	public boolean northIsMine;
	public boolean northWestIsMine;
	public boolean westIsMine;
	public boolean southWestIsMine;
	public boolean southIsMine;
	public boolean southEastIsMine;
	public boolean eastIsMine;
	public boolean northEastIsMine;
	public int numMines;
	
	public BlockState(){
		numMines = 0;
	}
	
	public void addAdjacentMine(){
		numMines++;
		return;
	}
}