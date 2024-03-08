/**
 *  Bank 
 * =====
 * @author: Randolfo A Gonçalves
 * @since:  06/02/24
 * @file:   Category.java 
 *
 * Classe dedicada para connect ao banco:
*/

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Bank{
// Fields
// ======
    private Connection        cnt  = null;    
    private Statement         stt  = null;

// Build
// =====
    Bank(String url){ connect(url); }

// Connection
// ==========
    private 
    void connect(String url){
        try{ 
            cnt=DriverManager.getConnection(url);
            stt=cnt.createStatement();            
        } 
        catch(SQLException e){ msg(e);   }
    }

    void disconnet(){
        try{ if(cnt != null) cnt.close();       }
        catch(SQLException e){ msg(e); }
    }
    
    
    protected void msg(SQLException e){ System.err.println(e);}
    protected void msg(IOException e){  System.err.println(e);}

    protected
    PreparedStatement Pstt(String sql){
        try{ return cnt.prepareStatement(sql); }catch(SQLException e){msg(e); return null; }
    }
    
    protected
    ResultSet Rstt(String sql){
        try{ return stt.executeQuery(sql); }catch(SQLException e){msg(e); return null; }
    }
}
