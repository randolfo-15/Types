/*!*****************************************************************
 *   Data 
 *  ======
 * @author: Randolfo A Gonçalves
 * @since:  06/02/24
 * @file:   Category.java 
 *
 * Classe dedicada para interfaciar dados entre classes.
*******************************************************************/

import java.sql.PreparedStatement;

public interface Data{
    void insert(PreparedStatement pstt);
    //void update(PreparedStatement pstt);
    //void delete(PreparedStatement pstt);
    //void select(Statement stt);
}
