package base64ToImages;

import java.io.*;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class Word2PdfUtil {

    public static void main(String[] args) throws IOException {
        WordToPDF("/home/jingbao/文档/doc/纪仔涛-简历news(1).doc",
                "/home/jingbao/文档/pdf/纪仔涛-简历news(1).pdf");
//        PdfToWord("/home/jingbao/文档/pdf/纪仔涛-简历news.pdf",
//                "/home/jingbao/文档/doc/纪仔涛-简历news(1).doc");
    }

//    public static boolean getLicense() {
//        boolean result = false;
//        try {
//            InputStream is = Test.class.getClassLoader().getResourceAsStream("license.xml"); // license.xml应放在..\WebRoot\WEB-INF\classes路径下
//            License aposeLic = new License();
//            aposeLic.setLicense(is);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    public static void doc2pdf(String inPath, String outPath) {
//        if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
//            return;
//        }
        try {
            long old = System.currentTimeMillis();
            File file = new File(outPath); // 新建一个空白pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(inPath); // Address是将要被转化的word文档
            doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,
            // EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); // 转化用时
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 将word格式的文件转换为pdf格式
    public static void WordToPDF(String startFile, String overFile) throws IOException, IOException {
        // 源文件目录
        File inputFile = new File(startFile);
        if (!inputFile.exists()) {
            System.out.println("源文件不存在！");
            return;
        }

        // 输出文件目录
        File outputFile = new File(overFile);
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().exists();
        }
        //cd /opt/openoffice4/program/
        //启动openOffice server
        //soffice -headless -accept="socket,host=127.0.0.1,port=8100;urp;" -nofirststartwizard

        // 连接openoffice服务
        OpenOfficeConnection connection = new SocketOpenOfficeConnection("127.0.0.1", 8100);
        connection.connect();

        // 转换
        DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
        converter.convert(inputFile, outputFile);

        // 关闭连接
        connection.disconnect();

        // 关闭进程
//        p.destroy();
    }

    public static void PdfToWord(String pdfFile,String wordName){
        try
        {
            PDDocument doc = PDDocument.load(new File(pdfFile));
            int pagenumber = doc.getNumberOfPages();
            pdfFile = pdfFile.substring(0, pdfFile.lastIndexOf("."));
            File file = new File(wordName);
            if (!file.exists())
            {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(wordName);
            Writer writer = new OutputStreamWriter(fos, "UTF-8");
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);// 排序
            stripper.setStartPage(1);// 设置转换的开始页
            stripper.setEndPage(pagenumber);// 设置转换的结束页
            stripper.writeText(doc, writer);
            writer.close();
            doc.close();
            System.out.println("pdf转换word成功！");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}

