/**
 *  Types
 * =======
 * @author: Randolfo A Gonçalves
 * @since:  03/02/24
 * @file:   Types.java 
 *
 * Classe dedicada para representação de tipos de dados.
*/


public class Types extends Category{
   // Fields
   // ======
   private String  name    = "",
                   example = "";
   
   private byte size = 0;
   
   private double[] extension = { 0, 0 }; 

   // Setting
   // =======
   public void set_size(byte size)               { this.size=size;           }
   public void set_name(String name)             { this.name=name;           }
   public void set_example(String example)       { this.example=example;     }
   public void set_extension(double[] extension) { this.extension=extension; }

   // Getting
   // =======
   public byte     get_size()      { return size;      }
   public String   get_name()      { return name;      }
   public String   get_example()   { return example;   }
   public double[] get_extension() { return extension; }
}

