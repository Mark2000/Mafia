public class Player
{
    private String name;
    private boolean isDead = false;
    private boolean killed = false;

    public void setName(String n)
    {
        name = n;
    }
    public String getName()
    {
    	return name;
    }
    public String getRole()
    {
        return "civilian";
    }
    public void kill()
    {
        killed = true;
    }
    
    public void revive()
    {
    	killed = false;
    }
    
    public void makeDead()
    {
    	if (killed) isDead = true; 
    }
    
    public boolean getDead()
    {
    	return isDead;
    }
    
    public void investigate()
    {
    }
}
