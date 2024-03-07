/**
 *  Bank_Types 
 *  ==========
 * @author: Randolfo A Gonçalves
 * @since:  06/02/24
 * @file:   Category.java 
 *
 * Classe dedicada para operações CRUD no banco de dados:
*/

import java.sql.SQLException;

public class Bank_Types extends Bank{
    
    private final int insert_ctg  = 0,
                      insert_type = 1;
    
    private final String[] query={
        /*---------------------Categories----------------------*/
        /*  Insert  */
        "INSERT INTO Categories" 
            +"(_name,_brief,_color)"+
        "VALUES" 
            +"(?,?,?)",

        /*------------------------Types------------------------*/
        /*  Insert  */
        "INSERT INTO Kinds"
            +"(_name_ctg,_name,_icon,_exemple,_size,_min,_max)"+
        "VALUES"
            +"(?,?,?,?,?,?,?)"
    };
    public Bank_Types(String path){ super(path); } 

    public void insert(Category ctg){
        try{
            pstt=cnt.prepareStatement(query[insert_ctg]);// Inicializa query

            pstt.setString(1,ctg.get_category_name());   // Subistitui ? 
            pstt.setString(2,ctg.get_category_brief());
            pstt.setString(3,ctg.get_color());
            
            pstt.executeUpdate();                        // Exeuta query

        }catch(SQLException bug){msg_erro(bug);}

    }
    public void insert(Types type){
        try{
            pstt=cnt.prepareStatement(query[insert_type]);

            pstt.setString(1,type.get_category_name());
            pstt.setString(2,type.get_name());
            pstt.setString(3,type.get_icon());
            pstt.setString(4,type.get_example());
            pstt.setByte(5,type.get_size());
            pstt.setDouble(6,type.get_extension()[0]);
            pstt.setDouble(7,type.get_extension()[1]);

            pstt.executeUpdate();

        }catch(SQLException bug){msg_erro(bug);}

    }
} 
