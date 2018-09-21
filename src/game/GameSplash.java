package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class GameSplash extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JLabel pvp;
	private JLabel pvea;
	private Director d;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GameSplash frame = new GameSplash();
//					frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GameSplash(Director d) {
		setTitle("Proyecto I - Dots");
		this.d = d;
		
		setMinimumSize(new Dimension(1000, 600));
		setMaximumSize(new Dimension(1000, 600));
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1000, 600));
		contentPane.setMaximumSize(new Dimension(1000, 600));
		contentPane.setPreferredSize(new Dimension(1000, 600));
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(700, 450));
		panel.setMinimumSize(new Dimension(700, 450));
		panel.setMaximumSize(new Dimension(700, 450));
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("    DOTS ");
		panel.add(lblNewLabel); 
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 60));
		lblNewLabel.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_4 = new JLabel("                                                                                                                               ");
		lblNewLabel_4.setToolTipText("                                ");
		panel.add(lblNewLabel_4);
		
		JLabel label = new JLabel("                                                                                                                               ");
		label.setToolTipText("                                ");
		panel.add(label);
		
		JLabel label_4 = new JLabel("                                                                                                                               ");
		label_4.setToolTipText("                                ");
		panel.add(label_4);
		
		JLabel label_3 = new JLabel("                                                                                                                               ");
		label_3.setToolTipText("                                ");
		panel.add(label_3);
		
		this.pvp = new JLabel(" Player v Player ");
		this.pvp.setFont(new Font("Courier New", Font.PLAIN, 33));
		this.pvp.setForeground(Color.WHITE);
		panel.add(this.pvp);
		
		JLabel label_1 = new JLabel("                                                                                                                               ");
		label_1.setToolTipText("                                ");
		panel.add(label_1);
		
		this.pvea = new JLabel(" Player v Easy AI ");
		this.pvea.setFont(new Font("Courier New", Font.PLAIN, 32));
		this.pvea.setForeground(Color.WHITE);
		panel.add(this.pvea);
		
		JLabel label_2 = new JLabel("                                                                                                                               ");
		label_2.setToolTipText("                                ");
		panel.add(label_2);
		
		
		this.pvp.addMouseListener(this);
		this.pvea.addMouseListener(this);
		
		
		this.setLocationRelativeTo(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.pvp)
		{
			this.d.setGameType(1);
			this.d.launchGame();
			
			
		}
		if(e.getSource() == this.pvea)
		{
			this.d.setGameType(2);
			this.d.launchGame();
			
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		//System.out.println(e.getSource());
		
		if(e.getSource() == this.pvp)
		{
			this.pvp.setForeground(Color.red);
			
		}
		if(e.getSource() == this.pvea)
		{
			this.pvea.setForeground(Color.red);
			
		}
		
		
		this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.pvp)
		{
			this.pvp.setForeground(Color.white);
			
		}
		
		if(e.getSource() == this.pvea)
		{
			this.pvea.setForeground(Color.white);
			
		}
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
