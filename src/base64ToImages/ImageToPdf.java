package base64ToImages;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jijngbao
 * @date 19-3-9
 */
public class ImageToPdf {
    /**
     * 使用pdfbox将jpg转成pdf
//     * @param jpgStream jpg输入流
     * @param pdfPath pdf文件存储路径
     * @throws IOException IOException
     */
    public static void jpgToPdf(String jpgPath, String
            pdfPath)
            throws IOException {
        FileInputStream jpgStream=new FileInputStream(new File(jpgPath));

        PDDocument pdDocument = new PDDocument();
        BufferedImage image = ImageIO.read(jpgStream);

        PDPage pdPage = new PDPage(new PDRectangle(image.getWidth(), image.getHeight()));
        pdDocument.addPage(pdPage);
        PDImageXObject pdImageXObject = LosslessFactory.createFromImage(pdDocument, image);
        PDPageContentStream contentStream = new PDPageContentStream(pdDocument, pdPage);
        contentStream.drawImage(pdImageXObject, 0, 0, image.getWidth(), image.getHeight());
        contentStream.close();
        pdDocument.save(pdfPath);
        pdDocument.close();
    }

    public static void main(String[] args) throws IOException {
        jpgToPdf("/home/jingbao/IdeaProjects/untitled4/src/base64ToImages/preview.jpg", "/home/jingbao/文档/xxx.pdf");
    }
}
