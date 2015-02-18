package Main;

import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, MouseListener, KeyListener{
	//initial dimensions
	//chosen at nearly random, 
	//though maybe we can have it correspond to BoardState.BoardWidth and BoardState.BoardHeight?
	private int width = 320;
	private int height = 240;
	
	//difficulty buttons buttons
	JButton easy = new JButton("Easy");
	JButton medium = new JButton("Medium"); 
	JButton hard = new JButton("Hard");
	
	//game thread
	private Thread thread;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();
		
		//creating functions to react to our buttons being clicked and adding them to our GamePanel
		easy.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	BoardState boardState = new BoardState(10, 5);
	     		boardState.printBoard();
	         }          
	      });
		this.add(easy);
		medium.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	BoardState boardState = new BoardState(15, 8);
	     		boardState.printBoard();
	         }          
	      });
		this.add(medium);
		hard.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	BoardState boardState = new BoardState(40, 15);
		     	boardState.printBoard();
	         }          
	      });
		this.add(hard);
		
		startGame();
	}
	
	//starting our game thread (not entirely sure how this works...)
	public void startGame(){
		if(thread == null){
			thread = new Thread(this);
			addMouseListener(this);
			thread.start();
		}
	}
	
	//just to show that run starts no matter wut...
	public void run(){
		System.out.println("no matter wut.");
	}
	
	//something I was previously going to use for buttons
	//prints out "wut." when you click outside of the buttons...
	public void mouseClicked(MouseEvent event) {
		Object object = event.getSource();
		if(object != easy){
			System.out.println("wut.");
		}
	}
	
	//in case we want to handle mouse events
	public void mouseReleased(MouseEvent event) {}
	public void mouseEntered(MouseEvent event) {}
	public void mousePressed(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}
	
	//and key events
	public void keyTyped(KeyEvent key) {}
	public void keyPressed(KeyEvent key) {}
	public void keyReleased(KeyEvent key) {}
}
