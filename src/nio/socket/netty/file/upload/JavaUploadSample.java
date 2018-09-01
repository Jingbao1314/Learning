package nio.socket.netty.file.upload;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.List;

/**
 * Created by andilyliao on 17-4-8.
 */
public class JavaUploadSample {
    private static final String BOUNDARY = "---------------------------7db1c523809b2";// 数据分割线

    private static final String DIRECTORY = "e:\\";

    /**
     * @see java Socket 模拟 http上传文件
     * <p/>
     * 多文件上传
     */
    public static void upload(String name, List<File> files) throws Exception {
        // 表单字段和文件的数据
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n\r\n--" + BOUNDARY + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"name\"" + "\r\n");
        sb.append("\r\n");
        sb.append(name + "\r\n");

        sb.append("--" + BOUNDARY + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"age\"" + "\r\n");
        sb.append("\r\n");
        sb.append(30 + "\r\n");

        // 文件之前的数据
        byte[] before = sb.toString().getBytes("UTF-8");
        // 文件之后的数据
        byte[] after = ("--" + BOUNDARY + "--\r\n").getBytes("UTF-8");
        String uploadURL = "/PosAxis/servlet/UploadServlet"; //上传文件的Servlet

        URL url = new URL("http://192.168.210.251:8080" + uploadURL);
        Socket socket = new Socket(url.getHost(), url.getPort());
        socket.setSoTimeout(30000);
        socket.setKeepAlive(true);
        socket.setSendBufferSize(262144);
        socket.setReceiveBufferSize(262144);
        OutputStream out = socket.getOutputStream();
        PrintStream ps = new PrintStream(out, true, "UTF-8");

        long length = 0;
        int blen = 0;
        for (int i = 0; i < files.size(); i++) {
            length += files.get(i).length();

            sb = new StringBuilder();
            sb.append("--" + BOUNDARY + "\r\n");
            sb.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + files.get(i).getName() + "\"" + "\r\n");
            sb.append("Content-Type: image/pjpeg" + "\r\n");
            sb.append("\r\n");

            blen += sb.toString().getBytes("UTF-8").length;
        }//请求头
        StringBuffer header = new StringBuffer();
        header.append("POST " + uploadURL + " HTTP/1.1\r\n");
        header.append("Host: 192.168.210.251:8080\r\n");
        header.append("Accept: */*\r\n");
        header.append("Accept-Language: zh-cn\r\n");
        header.append("Accept-Charset: utf-8\r\n");
        header.append("Content-Type: multipart/form-data; boundary=" + BOUNDARY + "\r\n");
        header.append("Content-Length: " + String.valueOf(before.length + blen + length + after.length));
        ps.print(header);


        out.write(before);
        byte[] buf = new byte[2048];
        int len;
        for (int i = 0; i < files.size(); i++) {
            sb = new StringBuilder();
            sb.append("--" + BOUNDARY + "\r\n");
            sb.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + files.get(i).getName() + "\"" + "\r\n");
            sb.append("Content-Type: image/pjpeg" + "\r\n");
            sb.append("\r\n");
            out.write(sb.toString().getBytes("UTF-8"));
            InputStream in = new FileInputStream(files.get(i));
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
                out.flush();
                in.close();
                out.write("\r\n".getBytes("UTF-8"));
            }

            out.write(after);
            out.flush();
            out.close();
        }

    }
}
