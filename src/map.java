import java.util.Map;
import java.util.HashMap;
public class map {

    //dwarf fortress my beloved
    private Map<String, Character> tileset = new HashMap<>() {
        {
            tileset.put("OUTERWALL",'║');
            tileset.put("OUTERNW", '╔');
            tileset.put("OUTERNE", '╗');
            tileset.put("OUTERSW",'╚');
            tileset.put("OUTERSE",'╝');
        }
    };

}
