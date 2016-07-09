
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;


public final class Embebidor {
	private Font Fuente = null;
	static Font Russo = null;
	public Embebidor(){
		
		try {
			InputStream ISF = getClass().getResourceAsStream("Russo_One.ttf");
			Fuente = Font.createFont(Font.TRUETYPE_FONT, ISF);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Russo = Fuente.deriveFont(1,20f);
	}
}
