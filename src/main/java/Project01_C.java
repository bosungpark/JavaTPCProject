import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class Project01_C {
    public static void main(String[] args) {
        String src= "info.json";
        InputStream is=Project01_C.class.getResourceAsStream(src);
        if (is==null){
            throw new NullPointerException("can not find resource file");
        }
        JSONTokener tokener=new JSONTokener(is);
        JSONObject object= new JSONObject(tokener);
        JSONArray students=object.getJSONArray("students");
        for (Object o : students) {
            System.out.println("o = " + o);
        }
    }
}
