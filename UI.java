import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.concurrent.*;

public class UI extends JFrame
{
	Game g;
	public UI()
	{
		super("Mafia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		startScreen();
	}
	
	private void startScreen()
	{
		//setup
		getContentPane().removeAll();
		
		setLayout(new GridLayout(2,1));
		
		//title
		JPanel title = new JPanel();
		JTextArea titleText = new JTextArea("MAFIA", 1,5);//Stylize
		titleText.setEditable(false);
		title.add(titleText, BorderLayout.CENTER);
		
		//button
		JPanel button = new JPanel();
		JButton startButton = new JButton("New Game");
		titleText.setEditable(false);
		
		//numbers
		SpinnerModel playerModel = new SpinnerNumberModel(5,5,20,1);
		JSpinner playerNumber = new JSpinner(playerModel);
		//playerNumber.setColumns(2);
		
		button.add(playerNumber,BorderLayout.CENTER);
		button.add(startButton,BorderLayout.CENTER);
		
		add(titleText);
		add(button);
		setVisible(true);
		
		//leave
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				g = new Game((int)playerNumber.getValue());
				gameScreen();
				setVisible(true);
			}
		});
	}
	
	private void gameScreen()
	{
		getContentPane().removeAll();
		
		setLayout(new GridLayout(2,1));
		
		JPanel people = new JPanel(new GridLayout(0,4,5,5));
		people.setBorder(new EmptyBorder(0, 20, 20, 20));
		JPanel text = new JPanel(new BorderLayout());
		text.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		for (Player p:g.getPlayers())
		{
			people.add(new JButton(p.getRole()));
		}
		
		text.add(new JTextArea("This is sample text for the game of mafia. This is sample text for the game of mafia. This is sample text for the game of mafia. \n\n This is sample text for the game of mafia."));
		
		add(text);
		add(people);
		
		setVisible(true);
	}
	
	public static void main(String[] args)
    {
		new UI();
    }
	
	//SETUP
    //get names
    //assign roles
    //show roles
    //intro
    //MAIN LOOP
    //night
    //day
    //END

}
