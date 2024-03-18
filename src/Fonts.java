import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.File;

public class Fonts {

    static Font create(String path,int size) {

        try { return Font.createFont(Font.TRUETYPE_FONT,new File(path)).deriveFont(size);} 
        catch ( FontFormatException e){ e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        return null;
    }

}
