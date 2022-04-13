import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class Project04_C {
    public static void main(String[] args) {
        Document doc=new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("ImageDemo.pdf"));
            doc.open();

            String fileName="inflearn.png";
            Image image=Image.getInstance(fileName);
            doc.add(image);

            String url="https://cdn.inflearn.com/public/courses/328376/cover/6baa63b8-8f8f-473d-9b55-9047a521037e/328376-eng.jpg";
            image=Image.getInstance(url);
            doc.add(image);

            System.out.println("pdf created");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            doc.close();
        }
    }
}
