/**
 *  Rules SQL 
 *  =========
 * @author: Randolfo A Gonçalves
 * @since:  06/02/24
 * @file:   Category.java 
 *
 * Enumerador para regras sql precarregadas.
*/


enum Sql{
    insert_ctg,   // ctg  = Category
    insert_type,  // type = Tipo
    update_ctg,    
    update_type,                
    delete_ctg,    
    delete_type;   

    public static int size=6; //< Número de instruções.
}
