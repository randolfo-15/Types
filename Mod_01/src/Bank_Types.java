/*!*****************************************************************
 *  Bank_Types 
 *  ==========
 * @author: Randolfo A Gonçalves
 * @since:  06/02/24
 * @file:   Category.java 
 *
 * Classe dedicada para operações CRUD no banco de dados:
*******************************************************************/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank_Types extends Bank{
    //! Conteiner de regras sql:
    private 
    Map<Sql,String> query = new HashMap<Sql,String>();
    
    //! Inicializa o conteiner lendo o file querys.sqlite
    private
    void init(List<String> line,int i){ while(++i<Sql.size)query.put(Sql.values()[i],line.get(i));} 
    
    //! Build Class Bank_Types:
    Bank_Types(String path_bank,String uri){ 
        super(path_bank); 
        try{ init(Files.readAllLines(Paths.get(uri)),-1); } 
        catch(IOException e){ msg(e); }
    } 

    //! Selecionar query para Category
    void querys(Sql sql,Category ctg){
        switch (sql){
        //  Cases Category
        // ================
            case C_INSERT: ins(Pstt(query.get(sql)),ctg); break;
            case C_UPDATE: upd(Pstt(query.get(sql)),ctg); break; 
            case C_DELETE: del(Pstt(query.get(sql)),ctg); break; 
            case C_SELECT: sel(Rstt(query.get(sql)),ctg); break; 
            
        //  Cases Types
        // =============
            //    case T_INSERT: ins(Pstt(query.get(sql)),type).execute(); 
            //    case T_UPDATE: upd(Pstt(query.get(sql)),type).execute(); 
            //    case T_DELETE: del(Pstt(query.get(sql)),type).execute(); 
            //    case T_SELECT: sel(Rstt(query.get(sql)),type);                  
        }
}

    private
    void del(PreparedStatement pstt,Category ctg){ 
        try{ pstt.setString(1,ctg.get_category_name());        
             pstt.executeUpdate();

        }catch(SQLException e){msg(e);}  
    }
    
    private 
    void ins(PreparedStatement pstt,Category ctg){ 
        try{ pstt.setString(1,ctg.get_category_name());                
             pstt.setString(2,ctg.get_category_brief());
             pstt.setString(3,ctg.get_color());           
             pstt.executeUpdate();

        }catch(SQLException e){msg(e);}
         
    }
    
    private
    void upd(PreparedStatement pstt,Category ctg){ 
        try{ pstt.setString(1,ctg.get_category_name());                
             pstt.setString(2,ctg.get_category_brief());
             pstt.setString(3,ctg.get_color());           
             pstt.setString(4,ctg.get_category_name());    
             pstt.executeUpdate();

        }catch(SQLException e){msg(e);}
    }
    
    private
    void sel(ResultSet rset,Category ctg){ 
        try{ ctg.set_category_name(rset.getString("_name"));    
             ctg.set_category_brief(rset.getString("_brief"));    
             ctg.set_color(rset.getString("_color"));           

        }catch( SQLException e ){ msg(e); }
    }
   
    private
    void del(PreparedStatement pstt,Types type){ 
        try{ pstt.setString(1,type.get_category_name());        
             pstt.executeUpdate();

        }catch(SQLException e){msg(e);}  
    }
    
    private 
    void ins(PreparedStatement pstt,Types type){ 
        try{ pstt.setString(1,type.get_category_name());                
             pstt.setString(2,type.get_category_brief());
             pstt.setString(3,type.get_color());           
             pstt.executeUpdate();

        }catch(SQLException e){msg(e);}
         
    }
    
    private
    void upd(PreparedStatement pstt,Types type){ 
        try{ pstt.setString(1,type.get_category_name());                
             pstt.setString(2,type.get_category_brief());
             pstt.setString(3,type.get_color());           
             pstt.setString(4,type.get_category_name());    
             pstt.executeUpdate();

        }catch(SQLException e){msg(e);}
    }
    
    private
    void sel(ResultSet rset,Types type){ 
        try{ type.set_category_name(rset.getString("_name_ctg"));    
             type.set_category_brief(rset.getString("_brief"));    
             type.set_color(rset.getString("_color"));           

        }catch( SQLException e ){ msg(e); }
    }








/*

    //! Insert or Update Category
    void change(Category ctg,Sql rule){
        try{
            pstt=cnt.prepareStatement(query.get(rule));
            
            pstt.setString(1,ctg.get_category_name());    

            if(rule==Sql.delete_ctg){ pstt.executeUpdate(); return; } 
            
            pstt.setString(2,ctg.get_category_brief());
            pstt.setString(3,ctg.get_color());
            
            if(rule==Sql.update_ctg) pstt.setString(4,ctg.get_category_name()); 
            pstt.executeUpdate();                        

        }catch(SQLException e){msg(e);}

    }

    //! Insert or Update Types
    public void change(Types type,Sql rule){
        try{
            pstt=cnt.prepareStatement(query.get(rule));

            pstt.setString(1,type.get_name());
            
            if(rule==Sql.delete_type){ pstt.executeUpdate(); return; } 
            
            pstt.setString(2,type.get_category_name());
            pstt.setString(3,type.get_icon());
            pstt.setString(4,type.get_example());
            pstt.setByte(5,type.get_size());
            pstt.setDouble(6,type.get_extension()[0]);
            pstt.setDouble(7,type.get_extension()[1]);

            if(rule==Sql.update_type) pstt.setString(8,type.get_name()); 
            pstt.executeUpdate();

        }catch(SQLException e){msg(e);}

    }
    //! Select to Category
    Category get_ctg(String name){
        try{
            rset=stt.executeQuery(query.get(Sql.select_ctg));
        }catch(SQLException e){msg(e);}
        return null;
    }

    //! Select to Types
    Types get_type(){ return null; }*/
} 
