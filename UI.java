import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class UI extends JFrame
{
	Game g;
	boolean continueGame = false;
	public UI()
	{
		super("Mafia");
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		startScreen();
		nameSetup();
	}
	
	private void startScreen()
	{
		//setup				
		getContentPane().setBackground(Color.BLACK);
		setResizable(false);
		setSize(800,600);
		setTitle("MAFIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[40%,grow][30%:n,center][40%]", "[110.00][20%,top][20%][grow]"));
		
		JLabel title = new JLabel("Mafia");
		title.setForeground(new Color(178, 34, 34));
		title.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 70));
		getContentPane().add(title, "cell 1 1,alignx center,aligny bottom");
		
		SpinnerModel numPlayersModel = new SpinnerNumberModel(5,5,20,1);
		JSpinner numPlayers = new JSpinner(numPlayersModel);
		numPlayers.setFont(new Font("Bodoni 72", Font.PLAIN, 16));
		getContentPane().add(numPlayers, "flowx,cell 1 2,alignx center");
		
		JButton startButton = new JButton("Start Game");
		startButton.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		getContentPane().add(startButton, "cell 1 2,alignx center");

		setVisible(true);
		
		//leave
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				g = new Game((int)numPlayers.getValue());
				setVisible(true);
			}
		});
		while (true)
		{
			System.out.println("looping . . .");
			if (g != null){
				return;
			}
		}
	}
	
	public boolean continueLoop;
	
	private void nameSetup()
	{
		//setup
		continueLoop = false;
		continueGame = false;
		getContentPane().removeAll();
		
		getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel top = new JPanel(new BorderLayout());
		top.setBorder(new EmptyBorder(0, 20, 20, 20));
		JLabel displayText = new JLabel("Select player names.");
		displayText.setHorizontalAlignment(SwingConstants.CENTER);
		displayText.setFont(new Font("Bodoni 72", Font.PLAIN, 24));
		JButton startGame = new JButton("Continue");
		startGame.setEnabled(true);
		startGame.setFont(new Font("Bodoni 72", Font.PLAIN, 20));
		startGame.setBackground(new Color(0, 0, 0));
		top.add(startGame, BorderLayout.SOUTH);
		top.add(displayText);
		setResizable(false);
		setSize(800,600);
		setTitle("MAFIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JPanel peopleGrid = new JPanel(new GridLayout(0,4));
		peopleGrid.setBorder(new EmptyBorder(0, 20, 20, 20));
	
		for (Player p:g.getPlayers())
		{
			if (p.getName() == null)
			{
				startGame.setEnabled(false);
				
				JPanel personSlot = new JPanel(new GridLayout(2,1));
				JTextField nameInput = new JTextField();
				nameInput.setHorizontalAlignment(JTextField.CENTER);
				nameInput.setFont(new Font("Bodoni 72", Font.PLAIN, 14));
				personSlot.add(nameInput);
				JButton nameSet = new JButton("Add Player");
				nameSet.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 14));
				personSlot.add(nameSet);
				peopleGrid.add(personSlot);
				setVisible(true);
				
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
				playerButton.setFont(new Font("Bodoni 72", Font.PLAIN, 14));
				playerButton.setEnabled(false);
				peopleGrid.add(playerButton);
			}
		}
		
		//display
		getContentPane().add(top);
		getContentPane().add(peopleGrid);
		
		setVisible(true);
		

		//start button
		startGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (g.namesSet()) continueGame = true;
				setVisible(true);
				gameLoop();
			}
		});
	}
	/*
	private String showText;
	private String readText;
	
	public void readNames()
	{
		//setup
		continueGame = false;

		getContentPane().removeAll();
				
		JPanel top = new JPanel(new BorderLayout());
		JLabel textDisplay = new JLabel("firsttext");
		textDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		textDisplay.setFont(new Font("Bodoni 72", Font.PLAIN, 24));
		textDisplay.setBorder(new EmptyBorder(0, 20, 20, 20));
		top.add(textDisplay, BorderLayout.CENTER);
		
		setResizable(false);
		setSize(800,600);
		setTitle("MAFIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel peopleGrid = new JPanel(new GridLayout(0,4));
		peopleGrid.setBorder(new EmptyBorder(0, 20, 20, 20));
		
		//generateNameGrid(peopleGrid);
		
		//display
		getContentPane().add(top);
		getContentPane().add(peopleGrid);
		
			try {
	            Thread.sleep(1000);
	        } catch (InterruptedException ie){}
			
		showText = "Put down your head.";
		textDisplay.setText(showText);
		
		try {
            Thread.sleep(1000);
        } catch (InterruptedException ie){}
		
		showText = "testeroo";
		textDisplay.setText(showText);

		//read 'put heads down' and pause

		for (Player p: g.getPlayers())
		{
			readText = p.getName() + ", look up.";
			//read
			try {
	            Thread.sleep(1000);
	        } catch (InterruptedException ie){}
			
			showText = p.getName() + ", you are a " + p.getRole() + ".";
			textDisplay.setText(showText);
			try {
	            Thread.sleep(5000);
	        } catch (InterruptedException ie){}
			
			readText = "Put down your head.";
			
			showText = "";
			textDisplay.setText(showText);
			//read
			try {
	            Thread.sleep(1000);
	        } catch (InterruptedException ie){}
		}
		
		gameLoop();
	}
	*/
	public void gameLoop()
	{
		getContentPane().removeAll();
		
		getContentPane().setLayout(new GridLayout(2,1));
		
		JPanel peopleGrid = new JPanel(new GridLayout(0,4));
		
		JPanel top = new JPanel(new BorderLayout());
		JLabel textDisplay = new JLabel("Click to learn your role.");
		textDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		textDisplay.setFont(new Font("Bodoni 72", Font.PLAIN, 24));
		textDisplay.setBorder(new EmptyBorder(0, 20, 20, 20));
		top.add(textDisplay, BorderLayout.CENTER);
		
		generateNameGrid(peopleGrid);
	
		//display
		getContentPane().add(top);
		getContentPane().add(peopleGrid);
			
		setVisible(true);
		
	}
	
	public void mafiaTurn()
	{
		//call to rise
	}
	
	public void medicTurn()
	{
		
	}
	
	public void detectiveTurn()
	{
		
	}
	
	public void generateNameGrid(JPanel peopleGrid)
	{
		peopleGrid.setBorder(new EmptyBorder(0, 20, 20, 20));
		for (Player p : g.getPlayers())
		{
			JButton playerButton = new JButton(p.getName());
			playerButton.setFont(new Font("Bodoni 72", Font.PLAIN, 14));
			playerButton.setEnabled(true);
			
			playerButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.out.println(p.getName() + " is a " + p.getRole());
				}
			
			});
			
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
	
}
