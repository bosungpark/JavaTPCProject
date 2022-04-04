import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kr.inflearn.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class Project01_A {

    public static void main(String[] args){
        BookDTO dto= new BookDTO("java",21000,"aicon",670);
        Gson g=new Gson();

        String json= g.toJson(dto);
        System.out.println("json = " + json);

        BookDTO dto1=g.fromJson(json, BookDTO.class);
        System.out.println("dto1 = " + dto1);

        List<BookDTO> lst=new ArrayList<BookDTO>();
        lst.add(new BookDTO("java1",21000,"aicon",670));
        lst.add(new BookDTO("java2",31000,"aicon",770));
        lst.add(new BookDTO("java3",41000,"aicon",870));
        String lstJson= g.toJson(lst);
        System.out.println("lstJson = " + lstJson);

        List<BookDTO> lst1= g.fromJson(lstJson, new TypeToken<List<BookDTO>>(){}.getType());
        for (BookDTO bookDTO : lst1) {
            System.out.println("bookDTO = " + bookDTO);
        }
    }
}
