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
    Map<rules,String> query = new HashMap<rules,String>();
    
    //! Inicializa o conteiner lendo o file querys.sqlite
    private void init_querys(String uri,int i){
        try{ List<String> line=Files.readAllLines(Paths.get(uri)); 
             while((++i)<rules.size) query.put(rules.values()[i],line.get(i)); 
        }catch(IOException bug){ msg_erro(bug); }
    } 
    
    //! Build Class Bank_Types:
    public Bank_Types(String path_bank,String path_querys){ 
        super(path_bank); 
        init_querys(path_querys,-1); 
    } 
    
    //! Insert or Update Category
    public void change(Category ctg,rules rule){
        try{
            pstt=cnt.prepareStatement(query.get(rule));
            
            pstt.setString(1,ctg.get_category_name());    
            pstt.setString(2,ctg.get_category_brief());
            pstt.setString(3,ctg.get_color());
            
            if(rule==rules.update_ctg) pstt.setString(4,ctg.get_category_name()); 
            
            pstt.executeUpdate();                        

        }catch(SQLException bug){msg_erro(bug);}

    }

    //! Insert or Update Types
    public void insert(Types type,rules rule){
        try{
            pstt=cnt.prepareStatement(query.get(rules.insert_type));

            pstt.setString(1,type.get_category_name());
            pstt.setString(2,type.get_name());
            pstt.setString(3,type.get_icon());
            pstt.setString(4,type.get_example());
            pstt.setByte(5,type.get_size());
            pstt.setDouble(6,type.get_extension()[0]);
            pstt.setDouble(7,type.get_extension()[1]);

            if(rule==rules.update_type) pstt.setString(8,type.get_name()); 
            pstt.executeUpdate();

        }catch(SQLException bug){msg_erro(bug);}

    }
} 
