import java.util.*;
public class Game
{
    private List<Player> players = new ArrayList<Player>();
    
    public Game(int n)//n = number of players; min 5
    {
        //1 detective, 1 medic, 2 mafia, 1 innocent
    	players.add(new Detective());
    	players.add(new Medic());
    	for (int k = 0; k < Math.round((double)n / 3); k++)
    		players.add(new Mafia());
    	for (int k = 0; k < Math.round((double)2 * n / 3 - 2); k++)
    		players.add(new Player());
    	Collections.shuffle(players);
    }
    
    public List<String> getNames()
    {
    	List<String> names = new ArrayList<String>();
    	for (Player p : players)
    	{
    		names.add(p.getName());
    	}
    	return names;
    }
    
    public List<Player> getPlayers()
    {
    	return players;
    }
}
