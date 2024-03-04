import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Bank{
// Fields
// ======
    String url="jdbc:sqlite:a.db";
    Connection cnt=null;    

// Build
// =====
    public Bank(){ connect(url); }
    public Bank(String url){ connect(url); }

// Connection
// ==========
    private void connect(String url){
        try{ cnt=DriverManager.getConnection(url);}
        catch(SQLException bug){ msg_erro(bug);   }
    }

    public void disconnet(){
        try{ if(cnt != null) cnt.close();       }
        catch(SQLException bug){ msg_erro(bug); }
    }
    
    private void msg_erro(SQLException bug){ System.out.println(bug);}

}
