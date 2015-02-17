package Main;

import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, MouseListener, KeyListener{
	//initial dimensions
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
		
		easy.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	BoardState boardState = new BoardState(8);
	     		boardState.printBoard();
	         }          
	      });
		medium.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	BoardState boardState = new BoardState(12);
	     		boardState.printBoard();
	         }          
	      });
		hard.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	BoardState boardState = new BoardState(15);
		     	boardState.printBoard();
	         }          
	      });
		
		this.add(easy);
		this.add(medium);
		this.add(hard);
	}
	
	public void addNotify(){
		super.addNotify();
		if(thread == null){
			thread = new Thread(this);
			addMouseListener(this);
			thread.start();
		}
	}
	
	public void run(){
		/*BoardState boardState = new BoardState(10);
		boardState.printBoard();*/
		System.out.println("wut.");
	}
	
	public void mouseClicked(MouseEvent event) {
		Object object = event.getSource();
		if(object != easy){
			System.out.println("wut.");
		}
	}
	public void mouseReleased(MouseEvent event) {}
	public void mouseEntered(MouseEvent event) {}
	public void mousePressed(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}
	
	public void keyTyped(KeyEvent key) {}
	public void keyPressed(KeyEvent key) {}
	public void keyReleased(KeyEvent key) {}
}
