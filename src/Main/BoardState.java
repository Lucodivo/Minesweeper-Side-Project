package Main;

import java.util.Random;

public class BoardState {
	//declare an array for the blocks on the board
	public BlockState[] blockStates;
	//width used for length of rows
	public int boardWidth;
	
	private Random rndGen;
	
	public BoardState(int gameWidth){
		//to be more dynamic later
		blockStates = new BlockState[gameWidth * gameWidth];
		boardWidth = gameWidth;
		rndGen = new Random();
		init();
	}
	
	private void init(){
		//we need to initiate each block before we can announce to them of existing mines
		for(int j = 0; j < blockStates.length; j++){
			blockStates[j] = new BlockState();
		}
		//setting the attributes for each mine
		for(int i = 0; i < blockStates.length; i++){
			//turns every four blocks into a mine
			if(rndGen.nextInt() % 4 == 0){
				blockStates[i].isMine = true;
				//if i is passed the first row
				if(i >= boardWidth){
					//announce to north block there is an adjacent mine
					blockStates[i - boardWidth].addAdjacentMine();
					//if i is not the bottom row
					if(i <= (blockStates.length - boardWidth - 1)){
						//announce to south block there is an adjacent mine
						blockStates[i + boardWidth].addAdjacentMine();
						//if i doesn't hug the left wall
						if(i % boardWidth != 0){
							//announce to west block that there is an adjacent mine
							blockStates[i - 1].addAdjacentMine();
							//announce to northwest block that there is an adjacent mine
							blockStates[i - (boardWidth + 1)].addAdjacentMine();
							//announce to southwest block that there is an adjacent mine
							blockStates[i + (boardWidth - 1)].addAdjacentMine();
						}
						//if i doesn't hug right wall
						if(i % boardWidth != (boardWidth - 1)){
							//announce to east block there is a mine
							blockStates[i + 1].addAdjacentMine();
							//announce to northeast block there is a mine
							blockStates[i - (boardWidth - 1)].addAdjacentMine();
							//announce to southeast block there is a mine
						    blockStates[i + (boardWidth + 1)].addAdjacentMine();
						}
					}
					//else i is bottom row
					else{
						//if i is not lower left corner
						if(i > (blockStates.length - boardWidth - 1)){
							//announce to west block that there is an adjacent mine
							blockStates[i - 1].addAdjacentMine();
							//announce to northhwest block that there is an adjacent mine
							blockStates[i - (boardWidth + 1)].addAdjacentMine();
						}
						//if i is not lower right corner
						if(i < (blockStates.length - 1)){
							//announce to east block there is an adjacent mine
							blockStates[i + 1].addAdjacentMine();
							//announce to northeast block that there is adjacent mine
							blockStates[i - (boardWidth - 1)].addAdjacentMine();
						}
					}
				}
				//else i is on the first row
				else{
					//announce to south block there is an adjacent mine
					blockStates[i + boardWidth].addAdjacentMine();
					//if block is not upper left corner
					if(i > 0){
						//announce to west block that there is an adjacent mine
						blockStates[i - 1].addAdjacentMine();
						//announce to southwest block that there is an adjacent mine
						blockStates[i + (boardWidth - 1)].addAdjacentMine();
					}
					//if block is not upper right corner
					if(i < (boardWidth - 1)){
						//announce to east block that there is an adjacent mine
						blockStates[i + 1].addAdjacentMine();
						//announce to southeast block that there is adjacent mine
						blockStates[i + (boardWidth + 1)].addAdjacentMine();
					}
				}
			}
			else{

				blockStates[i].isMine = false;
			}
		}
	}
	
	public void printBoard(){
		for(int i = 0; i < blockStates.length; i++){
			if(i % boardWidth == 0){
				System.out.printf("\n");
			}
			if(blockStates[i].isMine){
				System.out.printf("X");
			}
			else{
				System.out.printf("%d", blockStates[i].numMines);
			}
		}
	}
}
