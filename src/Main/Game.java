package Main;

import javax.swing.JFrame;

public class Game {
	public static void main(String[] args){
		//making a window with the title "Minesweeper"
		JFrame window = new JFrame("Minesweeper");
		
		//putting our game panel within the Window
		window.setContentPane(new GamePanel());
		
		//making it so the window will close when we click the close button
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//resizing windows is for squares and the elderly
		window.setResizable(false);
		
		/*"Causes this Window to be sized to fit the preferred size and layouts of its subcomponents. 
		 * If the window and/or its owner are not yet displayable, both are made displayable before 
		 * calculating the preferred size. The Window will be validated after the preferredSize is calculated.*/
		window.pack();
		
		//makes the window visible...
		window.setVisible(true);
	}
}
