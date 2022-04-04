import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;

public class Project01_B {

    public static void main(String[] args) {
        JSONArray students=new JSONArray();
        JSONObject student= new JSONObject();

        student.put("name","bosung");
        student.put("phone","010-1111-1111");
        student.put("address","seoul");
        System.out.println("student = " + student);

        students.put(student);
        JSONObject object=new JSONObject();
        object.put("students",students);
        System.out.println("object = " + object.toString(2));

    }
}
