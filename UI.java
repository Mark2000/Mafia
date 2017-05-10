import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
		JLabel titleText = new JLabel("MAFIA");
		titleText.setHorizontalAlignment(JTextField.CENTER);
		titleText.setFont(new Font("Serif", Font.BOLD, 70));
		
		//button
		JPanel button = new JPanel();
		JButton startButton = new JButton("New Game");
		
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
				nameSetup();
				setVisible(true);
			}
		});
	}
	
	private void nameSetup()
	{
		//setup
		getContentPane().removeAll();
		
		setLayout(new GridLayout(2,1));
		
		JPanel peopleGrid = new JPanel(new GridLayout(0,4));
		peopleGrid.setBorder(new EmptyBorder(0, 20, 20, 20));
		
		JPanel text = new JPanel(new BorderLayout());
		text.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		//set names
		for (Player p:g.getPlayers())
		{
			if (p.getName() == null)
			{
				JPanel personSlot = new JPanel(new GridLayout(2,1));
				JTextField nameInput = new JTextField();
				nameInput.setHorizontalAlignment(JTextField.CENTER); 
				personSlot.add(nameInput);
				JButton nameSet = new JButton("Add Player");
				personSlot.add(nameSet);
				peopleGrid.add(personSlot);
				
				nameSet.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//Check name for valid
						String name = nameInput.getText();
						if (!name.matches("[a-zA-Z ]+"))//make more betterer
						{
							nameInput.setText("Blank or invalid character");
						}
						else if(g.getNames().indexOf(name) != -1)
						{
							nameInput.setText("Name already taken");
						}
						else
						{
							p.setName(name);
							nameSetup();
						}
					}
				
				});
			}
			else
			{
				JButton playerButton = new JButton(p.getName());
				playerButton.setEnabled(false);
				peopleGrid.add(playerButton);
			}
		}
		

		//text and start button
		text.add(new JTextArea("Set the player names."));
		
		JButton startGame = new JButton("Start Game");
		startGame.setHorizontalAlignment(JTextField.CENTER);
		text.add(startGame, BorderLayout.SOUTH);
		
		startGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean allSet = true;
				for (Player p : g.getPlayers())
				{
					allSet = allSet && p.getName() != null;
				}
				if (allSet) gameLoop();
				setVisible(true);
			}
		});
		
		//display
		add(text);
		add(peopleGrid);
		
		setVisible(true);
	}
	
	public void readNames()
	{
		//setup
		getContentPane().removeAll();
		
		setLayout(new GridLayout(2,1));
		
		JPanel peopleGrid = new JPanel(new GridLayout(0,4));
		peopleGrid.setBorder(new EmptyBorder(0, 20, 20, 20));
		JPanel text = new JPanel(new BorderLayout());
		text.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		//display
		add(text);
		add(peopleGrid);
		
		setVisible(true);
	}
	
	public void gameLoop()
	{
		getContentPane().removeAll();
		
		setLayout(new GridLayout(2,1));
		
		JPanel peopleGrid = new JPanel(new GridLayout(0,4));
		generateNameGrid(peopleGrid);
		
		JPanel text = new JPanel(new BorderLayout());
		text.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		//display
		add(text);
		add(peopleGrid);
				
		setVisible(true);
	}
	
	public void generateNameGrid(JPanel peopleGrid)
	{
		peopleGrid.setBorder(new EmptyBorder(0, 20, 20, 20));
		for (Player p : g.getPlayers())
		{
			JButton playerButton = new JButton(p.getName());
			if (p.getDead())
			{
				playerButton.setEnabled(false);
				playerButton.setName(p.getName() + "\n Dead");
			}
			peopleGrid.add(playerButton);
		}
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
