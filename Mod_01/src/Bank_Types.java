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
    void init(List<String> line,int i){ while(++i<Sql.size) query.put(Sql.values()[i],line.get(i));} 
    
    //! Build Class Bank_Types:
    Bank_Types(String url,String uri){ 
        super(url);
        try{ init(Files.readAllLines(Paths.get(uri)),-1);} catch(IOException e){msg_erro(e);}
    } 
    
    //! Insert or Update Category
    void change(Category ctg,Sql rule){
        try{
            pstt=cnt.prepareStatement(query.get(rule));
            
            pstt.setString(1,ctg.get_category_name());    
            pstt.setString(2,ctg.get_category_brief());
            pstt.setString(3,ctg.get_color());
            
            if(rule==Sql.update_ctg) pstt.setString(4,ctg.get_category_name()); 
            pstt.executeUpdate();                        

        }catch(SQLException bug){msg_erro(bug);}

    }

    //! Insert or Update Types
    void insert(Types type,Sql rule){
        try{
            pstt=cnt.prepareStatement(query.get(rule));

            pstt.setString(1,type.get_category_name());
            pstt.setString(2,type.get_name());
            pstt.setString(3,type.get_icon());
            pstt.setString(4,type.get_example());
            pstt.setByte(5,type.get_size());
            pstt.setDouble(6,type.get_extension()[0]);
            pstt.setDouble(7,type.get_extension()[1]);

            if(rule==Sql.update_type) pstt.setString(8,type.get_name()); 
            pstt.executeUpdate();

        }catch(SQLException bug){msg_erro(bug);}

    }
} 
