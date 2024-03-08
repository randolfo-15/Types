/**
 *  Main 
 * ======
 * @author: Randolfo
 * @since:  02/02/24
 * @file:   Main.java 
 *
 * Classe dedicada para chamada e gestão do programa.
*/


public class Main{

    public static void main(String[] argv){
         
        Bank_Types bt=new Bank_Types(argv[0],argv[1]);
         
        Category ctg= new Category();
        ctg.set_category_name("Text");
        ctg.set_category_brief("Representa stream de string");
        ctg.set_color("#FF0000");

        bt.querys(Sql.C_INSERT,ctg);

        Types type= new Types();
        type.set_name("int");
        type.set_category_name("Numeric");
        type.set_icon("../images/icon/int.png");
        type.set_size((byte)1);
        type.set_example("int x = 1;");
        double[] ext={-2147483648,2147483647};
        type.set_extension(ext);
        
    }
}
