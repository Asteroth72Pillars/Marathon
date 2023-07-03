
package za.ac.cput.marathon;

/**
 *
 * @author zaihd
 */
public class Race 
{
    private String raceCode;
    private String firstName;
    private String lastName;
    private String raceType;

    public Race(String string, String firstName1, String lastName1) 
    {
    
    }
    
    public Race(String raceCode, String firstName, String lastName, String raceType) 
    {
        this.raceCode = raceCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.raceType = raceType;
    }

    public String getRaceCode() 
    {
        return raceCode;
    }

    public void setRaceCode(String raceCode) 
    {
        this.raceCode = raceCode;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public String getRaceType() 
    {
        return raceType;
    }

    public void setRaceType(String raceType) 
    {
        this.raceType = raceType;
    }
        
}
