import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.*;

public class UI extends JFrame
{
	
	public UI()
	{
		super("Mafia");
		setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		
		
		JPanel people = new JPanel(new GridLayout(0,4));
		JPanel text = new JPanel();
		
		for (int i = 1; i < 14; i++)
		{
			people.add(new JButton("Player" + i));
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
