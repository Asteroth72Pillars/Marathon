
package za.ac.cput.marathon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author zaihd
 */
public class RaceDAO 
{
    private Connection con;
    private Statement stmt;
    private PreparedStatement psmt;
    
    public RaceDAO()
    {
        try
        {
            this.con = DBConnection.derbyConnection();
        }catch(Exception ex)
        {
            
        }
    }
    
    public Race save(Race races)
    {
        int ok;
    
        String insertSql = "INSERT INTO RACETABLE VALUES(?,?,?,?)";
        
        try
        {
            stmt = this.con.createStatement();
            psmt = this.con.prepareStatement(insertSql);
            psmt.setString(1, races.getRaceCode());
            psmt.setString(2, races.getFirstName());
            psmt.setString(3, races.getLastName());
            psmt.setString(4, races.getRaceType());
            ok = psmt.executeUpdate();
            if(ok > 0)
            {
                return races;
            }
            else
            {
                return null;
            }
        }catch (SQLException sqlexception) 
        {
            // Handle the SQL exception appropriately
        } catch (Exception e) 
        {
            // Handle the exception appropriately
        } finally 
        {
            try {
                  if (stmt != null) {
                        stmt.close();
                }
            } catch (Exception exception) 
            {
                // Handle the exception appropriately
            }
        }
        
        return null;
    }

    
    public ArrayList<Race> getAll()
    {
        ArrayList<Race> raceList = new ArrayList<>();
        try
        {
            String getAllSql = "select * from racetypetable";
            psmt = this.con.prepareStatement(getAllSql);
            psmt.setString(1, "Ultra Marathon");
            psmt.setString(2, "Full Marathon");
            psmt.setString(3, "Half Marathon");
            
            ResultSet rs = psmt.executeQuery();
                if(rs != null)
                {
                    while(rs.next() )
                    {
                        System.out.println("BD table Record: "
                        + rs.getString(1) + " " +rs.getString(2));
                    
                        //raceList.add(new Race(rs.getString("marthon type"), rs.getString("distance") ));
                    }    
                rs.close();        
                }
        }//close try
        catch(Exception exception)
        {
        
        }finally
        {
            try
            {
                if(psmt != null)
                    psmt.close();
            }catch(Exception exception)
            {
                
            }
        }
        return raceList;
    }





}
