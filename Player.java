public class Player
{
    private String name;
    private boolean isDead = false;

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
        isDead = true;
    }
    
    public boolean getDead()
    {
    	return isDead;
    }
}
