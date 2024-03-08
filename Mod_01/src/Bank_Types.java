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
        try{init(Files.readAllLines(Paths.get(uri)),-1);} 
        catch(IOException e){msg(e);}
    } 
    
    //  Category 
    // ==========
    
    void delete(Category ctg){ 
        try{ PreparedStatement pstt=cnt.prepareStatement(query.get(Sql.C_DELETE));
             pstt.setString(1,ctg.get_category_name());        
             pstt.executeUpdate();
        
        }catch(SQLException e){msg(e);}  
    }
    
    void insert(Category ctg){ 
        try{ PreparedStatement pstt=cnt.prepareStatement(query.get(Sql.C_INSERT));
             pstt.setString(1,ctg.get_category_name());                
             pstt.setString(2,ctg.get_category_brief());
             pstt.setString(3,ctg.get_color());           
             pstt.executeUpdate();
        
        }catch(SQLException e){msg(e);}
    }

    void update(Category ctg){ 
        try{ PreparedStatement pstt=cnt.prepareStatement(query.get(Sql.C_UPDATE));
             pstt.setString(1,ctg.get_category_name());                
             pstt.setString(2,ctg.get_category_brief());
             pstt.setString(3,ctg.get_color());           
             pstt.setString(4,ctg.get_category_name());    
             pstt.executeUpdate();
        
        }catch(SQLException e){msg(e);}
    }

    void select(Category ctg){ 
        try{ PreparedStatement pstt=cnt.prepareStatement(query.get(Sql.C_SELECT));
             pstt.setString(1,ctg.get_category_name());
             ResultSet rset=pstt.executeQuery(query.get(Sql.C_SELECT));
             ctg.set_color(rset.getString("_color"));
             ctg.set_category_name(rset.getString("_name"));    
             ctg.set_category_brief(rset.getString("_brief"));

        }catch(SQLException sql){msg(sql);}
    }
   
    //  Types 
    // =======
    
    void delete(Types type){ 
        try{ PreparedStatement pstt=cnt.prepareStatement(query.get(Sql.T_DELETE));
             pstt.setString(1,type.get_name());        
             pstt.executeUpdate();
        
        }catch(SQLException e){msg(e);}  
    }
    
    void insert(Types type){ 
        try{ PreparedStatement pstt=cnt.prepareStatement(query.get(Sql.T_INSERT));
             pstt.setString(1,type.get_name());
             pstt.setString(2,type.get_category_name());
             pstt.setString(3,type.get_icon());
             pstt.setString(4,type.get_example());
             pstt.setByte(5,type.get_size());
             pstt.setDouble(6,type.get_extension()[0]);
             pstt.setDouble(7,type.get_extension()[1]);
             pstt.executeUpdate();
        
        }catch(SQLException e){msg(e);}
    }

    void update(Types type){ 
        try{ PreparedStatement pstt=cnt.prepareStatement(query.get(Sql.T_UPDATE));
             pstt.setString(1,type.get_name());
             pstt.setString(2,type.get_category_name());
             pstt.setString(3,type.get_icon());
             pstt.setString(4,type.get_example());
             pstt.setByte(5,type.get_size());
             pstt.setDouble(6,type.get_extension()[0]);
             pstt.setDouble(7,type.get_extension()[1]);
             pstt.setString(8,type.get_name()); 
             pstt.executeUpdate();
        
        }catch(SQLException e){msg(e);}
    }

    void select(Types type){ 
        try{ PreparedStatement pstt=cnt.prepareStatement(query.get(Sql.T_SELECT));
             pstt.setString(1,type.get_name()); 
             ResultSet rset=pstt.executeQuery(query.get(Sql.T_SELECT));
             type.set_name(rset.getString("_name"));
             type.set_category_name(rset.getString("_name_ctg"));
             type.set_icon(rset.getString("_icon"));
             type.set_example(rset.getString("_exemple"));
             type.set_size(rset.getByte("_size"));
             type.set_extension(new double[]{rset.getDouble("_min"),rset.getDouble("_max")});

        }catch(SQLException sql){msg(sql);}
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
    Types get_type(){ return null; }
    */
} 
