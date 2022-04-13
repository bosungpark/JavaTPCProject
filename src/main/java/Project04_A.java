import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

public class Project04_A {
    public static void main(String[] args) {
        String[] title=new String[] {"제목", "저자", "출판사", "이미지URL"};
        String[][] rows=new String[][] {
                {"물리법칙의 이해1", "리처드 파인만", "해나무", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMjNfMjYg%2FMDAxNjQ4MDI1NzI3ODUx.vzt2n8yQnjwEGoaBwNh5w-sWSoLsYNzKKe2PPUwHnG8g.4NpNElrFsZl3YMKWdwj94k8amFqu0B-D6XSfMJhaEZcg.JPEG.bryam%2F1_%25283%2529.jpg&type=sc960_832"},
                {"물리법칙의 이해2", "리처드 파인만", "해나무", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMjNfMjYg%2FMDAxNjQ4MDI1NzI3ODUx.vzt2n8yQnjwEGoaBwNh5w-sWSoLsYNzKKe2PPUwHnG8g.4NpNElrFsZl3YMKWdwj94k8amFqu0B-D6XSfMJhaEZcg.JPEG.bryam%2F1_%25283%2529.jpg&type=sc960_832"},
                {"물리법칙의 이해3", "리처드 파인만", "해나무", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMjNfMjYg%2FMDAxNjQ4MDI1NzI3ODUx.vzt2n8yQnjwEGoaBwNh5w-sWSoLsYNzKKe2PPUwHnG8g.4NpNElrFsZl3YMKWdwj94k8amFqu0B-D6XSfMJhaEZcg.JPEG.bryam%2F1_%25283%2529.jpg&type=sc960_832"},
        };

        Document doc= new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(new File("book.pdf")));
            doc.open();

            BaseFont bf=BaseFont.createFont("NanumGothic.otf",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            Font fontTitle= new Font(bf,12);
            Font fontRows= new Font(bf,10);

            PdfPTable table=new PdfPTable(title.length);
            table.setWidthPercentage(100);

            float[] colwidth= new float[] {20f, 15f, 15f, 30f};
            table.setWidths(colwidth);

            for (String header : title) {
                PdfPCell cell=new PdfPCell();
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(10);
                cell.setGrayFill(0.9f);
                cell.setPhrase(new Phrase(header,fontTitle));

                table.addCell(cell);
            }
            table.completeRow();

            for (String[] row : rows) {
                for (String data : row) {
                    Phrase phrase= new Phrase(data, fontRows);
                    PdfPCell cell= new PdfPCell(phrase);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setPaddingTop(20);
                    cell.setPaddingRight(20);
                    cell.setPaddingLeft(20);
                    cell.setPaddingBottom(20);
                    table.addCell(cell);
                }
                table.completeRow();
            }

            PdfPCell cell4=new PdfPCell(new Phrase("Cell 5"));
            cell4.setColspan(2);

            PdfPCell cell5=new PdfPCell(new Phrase("Cell 6"));
            cell5.setColspan(2);

            table.addCell(cell4);
            table.addCell(cell5);

            doc.addTitle("PDF Table Demo");
            doc.add(table);
            System.out.println("table has created");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            doc.close();
        }
    }
}
