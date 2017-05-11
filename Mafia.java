public class Mafia extends Player
{
	private boolean isDetected = false;
	
    public String getRole()
    {
        return "mafia";
    }
    
    public void investigate()
    {
    	isDetected = true;
    }
}