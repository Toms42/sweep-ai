package minesweeper;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class MineWindow implements ActionListener {

	JFrame frame;
	Minesweeper minesweeper;

	/**
	 * Create the application.
	 */
	public MineWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 399, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		frame.setFocusable(true);
		
		ImagePanel panel= new ImagePanel();
		panel.setBounds(20, 0, 341, 150);
		panel.setBackground(Color.black);
		frame.getContentPane().add(panel);
		
		JButton btnStart = new JButton("START");
		btnStart.setForeground(new Color(0, 128, 0));
		btnStart.setFont(new Font("Txt_IV25", Font.PLAIN, 28));
		btnStart.setToolTipText("Starts the AI.");
		btnStart.setBounds(20, 161, 341, 81);
		btnStart.setActionCommand("start");
		btnStart.addActionListener(this);
		frame.getContentPane().add(btnStart);
	      
		JTextArea consolePn = new JTextArea(16,44);
		consolePn.setEditable(false);
		consolePn.setForeground(Color.GREEN);
		consolePn.setBackground(Color.BLACK);
		frame.getContentPane().add(consolePn);
		
		JScrollPane scroller = new JScrollPane(consolePn);
		scroller.setBounds(10, 253, 363, 295);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        frame.getContentPane().add(scroller);
        
		DefaultCaret caret = (DefaultCaret)consolePn.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		TextAreaOutputStream taOutputStream = new TextAreaOutputStream(consolePn, "SweepAI");
		
		System.setOut(new PrintStream(taOutputStream));
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("start"))
		{
			minesweeper = new Minesweeper();
			minesweeper.start();
		}
	}
}

