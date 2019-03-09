package base64ToImages;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.itextpdf.text.pdf.PdfReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
/**
 * 将pdf 转化成 图片
 * @author yangnuo
 * 创建时间：2017年3月16日
 */
public class PDFToImage {

    // 水印透明度
    private static float alpha = 0.5f;
    // 水印横向位置
    private static int positionWidth = 150;
    // 水印纵向位置
    private static int positionHeight = 300;
    // 水印文字字体
    private static Font font = new Font("仿宋", Font.BOLD, 26);
    // 水印文字颜色
    private static Color color = Color.GRAY;



//    /**
//     * 生成pdf的缩略图
//     * @param zoom  缩略图显示倍数，1表示不缩放，0.5表示缩小到50%
//     * @param inputFile        需要生成缩略图的书籍的完整路径
//     * @param outputFile    生成缩略图的放置路径
//     */
//    public List<String> pdftoIamge(float zoom,String inputFile, String outputFile) {
//        List<String> list = null;
//        Document document = null;
//        try {
//            list = new ArrayList(0);
//            document = new Document();
//            document.setFile(inputFile);
//            float rotation = 0;
//            int maxPages = document.getPageTree().getNumberOfPages();
//            for (int i = 0; i < maxPages; i++) {
//                BufferedImage bfimage = (BufferedImage) document.getPageImage(i,  GraphicsRenderingHints.SCREEN,Page.BOUNDARY_CROPBOX, rotation, zoom);
//
//                bfimage = setGraphics(bfimage);
//
//                RenderedImage rendImage = bfimage;
//                ImageIO.write(rendImage, "jpg", new File(outputFile+i+".jpg"));
//                bfimage.flush();
//                list.add(outputFile+i+".jpg");
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if(document!=null){
//            document.dispose();
//        }
//        return list;
//    }



    public BufferedImage setGraphics(BufferedImage bfimage){
        Graphics2D g = bfimage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        // 5、设置水印文字颜色
        g.setColor(color);
        // 6、设置水印文字Font
        g.setFont(font);
        // 7、设置水印文字透明度
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha));
        //设置旋转
        g.rotate(-Math.PI/6);
        g.drawString("落花雨科技", 0, (bfimage.getHeight()/2)*1);
        // 9、释放资源
        g.dispose();
        return bfimage;
    }

    /***
     * PDF文件转PNG图片，全部页数
     *
     * @param PdfFilePath pdf完整路径
//     * @param imgFilePath 图片存放的文件夹
     * @param dpi dpi越大转换后越清晰，相对转换速度越慢
     * @return
     */
    public static void pdf2Image(String PdfFilePath, String dstImgFolder, int dpi) {
        File file = new File(PdfFilePath);
        PDDocument pdDocument;
        try {
            String imgPDFPath = file.getParent();
            int dot = file.getName().lastIndexOf('.');
            String imagePDFName = file.getName().substring(0, dot); // 获取图片文件名
            String imgFolderPath = null;
            if (dstImgFolder.equals("")) {
                imgFolderPath = imgPDFPath + File.separator + imagePDFName;// 获取图片存放的文件夹路径
            } else {
                imgFolderPath = dstImgFolder + File.separator + imagePDFName;
            }

            if (createDirectory(imgFolderPath)) {

                pdDocument = PDDocument.load(file);
                PDFRenderer renderer = new PDFRenderer(pdDocument);
				/* dpi越大转换后越清晰，相对转换速度越慢 */
                PdfReader reader = new PdfReader(PdfFilePath);
                int pages = reader.getNumberOfPages();
                StringBuffer imgFilePath = null;
                for (int i = 0; i < pages; i++) {
                    String imgFilePathPrefix = imgFolderPath + File.separator + imagePDFName;
                    imgFilePath = new StringBuffer();
                    imgFilePath.append(imgFilePathPrefix);
                    imgFilePath.append("_");
                    imgFilePath.append(String.valueOf(i + 1));
                    imgFilePath.append(".jpg");
                    File dstFile = new File(imgFilePath.toString());
                    BufferedImage image = renderer.renderImageWithDPI(i, dpi);
                    ImageIO.write(image, "jpg", dstFile);
                }
                System.out.println("PDF文档转PNG图片成功！");

            } else {
                System.out.println("PDF文档转PNG图片失败：" + "创建" + imgFolderPath + "失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean createDirectory(String folder) {
        File dir = new File(folder);
        if (dir.exists()) {
            return true;
        } else {
            return dir.mkdirs();
        }
    }

    public static void main(String[] args) {
        pdf2Image("/home/jingbao/文档/吕文静.pdf", "/home/jingbao/文档", 500);
    }



}

