/**
 *  Rules SQL 
 *  =========
 * @author: Randolfo A Gonçalves
 * @since:  06/02/24
 * @file:   Category.java 
 *
 * Enumerador para regras sql precarregadas.
*/


enum rules{
    insert_ctg,   //< Key:inserir uma nova categoria no banco de dados.
    insert_type,  //< Key:inserir um novo tipo no banco de dados.
    update_ctg,   //< Key:Update em uma categoria
    update_type;  //< Key:Update em um tipo.

    public static int size=4; //< Número de instruções.
}
