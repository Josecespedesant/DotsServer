package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameFrame {
	private JFrame frmDotsBoxes;
	private JLabel p1Score;
	private JLabel p2Score;
	private JLabel p1NameLabel;
	private JLabel p2NameLabel;
	private int gameType;
	
	public GameFrame() {
		initialize();
	}
	
	public GameFrame(int i) {
		this.gameType = i;
		initialize();
	}
	
	public int getGameType()
	{
		return this.gameType;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//System.out.println("MADE IT TO INITIALIZE");
		frmDotsBoxes = new JFrame();
		frmDotsBoxes.setTitle("Dots & Boxes");
		frmDotsBoxes.setSize(new Dimension(1000, 600));
		frmDotsBoxes.setResizable(false);
		frmDotsBoxes.setBounds(100, 100, 1000, 600);
		frmDotsBoxes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDotsBoxes.setLocationRelativeTo(null); //myline

		
		//URL url = this.getClass().getClassLoader().getResource("dblogo.jpg");
		//ImageIcon i = new ImageIcon(url);
		
		//this.frmDotsBoxes.setIconImage(i.getImage());
		
		
		frmDotsBoxes.setVisible(true);
		JPanel InfoPanel = new JPanel();
		InfoPanel.setPreferredSize(new Dimension(195, 400));
		InfoPanel.setBackground(Color.white);
		frmDotsBoxes.getContentPane().add(InfoPanel, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("Score");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(190, 14));
		InfoPanel.add(lblNewLabel);
		
		this.p1NameLabel = new JLabel(">  Player 1   ");
		this.p1NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		InfoPanel.add(this.p1NameLabel);
		
		this.p1Score = new JLabel("0");
		p1Score.setFont(new Font("Tahoma", Font.PLAIN, 16));
		InfoPanel.add(p1Score);
		
		this.p2NameLabel = new JLabel("   Player 2   ");
		
		//Handle AI Situations
		if(this.gameType == 2)
		{
			this.p2NameLabel.setText("  Easy CPU  ");
		}
		if(this.gameType == 3)
		{
			this.p2NameLabel.setText("  Hard CPU  ");
		}
		
		this.p2NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		InfoPanel.add(this.p2NameLabel);
		
		this.p2Score = new JLabel("0");
		p2Score.setFont(new Font("Tahoma", Font.PLAIN, 16));
		InfoPanel.add(this.p2Score);
		
		GameBoard gameBoard = new GameBoard(this);
		frmDotsBoxes.getContentPane().add(gameBoard, BorderLayout.WEST);
		this.getFrame().revalidate();
	}
	
	public JLabel getP1Label()
	{
		return this.p1Score;
	}
	public JLabel getP2Label()
	{
		return this.p2Score;
	}
	
	public JFrame getFrame()
	{
		return this.frmDotsBoxes;
	}
	
	public void setP1TurnPointer()
	{
		this.p1NameLabel.setText(">  Player 1   ");
	}
	public void setP1TurnPointerOff()
	{
		this.p1NameLabel.setText("   Player 1   ");
	}
	public void setP2TurnPointer()
	{
		this.p2NameLabel.setText(">  Player 2   ");
		if(this.gameType == 2)
		{
			this.p2NameLabel.setText("> Easy CPU  ");
		}
		if(this.gameType == 3)
		{
			this.p2NameLabel.setText("> Hard CPU  ");
		}
	}
	public void setP2TurnPointerOff()
	{
		this.p2NameLabel.setText("   Player 2   ");
		if(this.gameType == 2)
		{
			this.p2NameLabel.setText("  Easy CPU  ");
		}
		if(this.gameType == 3)
		{
			this.p2NameLabel.setText("  Hard CPU  ");
		}
	}

}
