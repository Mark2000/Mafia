public class Player
{
    private String name;
    private boolean isDead = false;

    public void setName(String n)
    {
        name = n;
    }
    public String getRole()
    {
        return "civilian";
    }
    public void kill()
    {
        isDead = true;
    }
}
