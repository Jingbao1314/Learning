package myhttp.ssl;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

//keytool -genkey -keystore cmkey -keyalg rsa -alias SSL
public class ServerSsl {
	// 抛出异常
	// javax.net.ssl.SSLException: No available certificate or key corresponds
	// to the SSL cipher suites which are enabled.
	public static void notOk() throws IOException {
		SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory
				.getDefault();
		SSLServerSocket server = (SSLServerSocket) factory
				.createServerSocket(10000);
		System.out.println("ok");
		server.accept();
	}

	// 启动一个ssl server socket
	// 配置了证书, 所以不会抛出异常
	public static void sslSocketServer() throws Exception {

		// key store相关信息
		String keyName = "cmkey";
		char[] keyStorePwd = "123456".toCharArray();
		char[] keyPwd = "123456".toCharArray();
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

		// 装载当前目录下的key store. 可用jdk中的keytool工具生成keystore
		InputStream in = null;
		keyStore.load(in = ServerSsl.class.getClassLoader().getResourceAsStream(
				keyName), keyPwd);
		in.close();

		// 初始化key manager factory
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory
				.getDefaultAlgorithm());
		kmf.init(keyStore, keyPwd);

		// 初始化ssl context
		SSLContext context = SSLContext.getInstance("SSL");
		context.init(kmf.getKeyManagers(),
				new TrustManager[] { new MyX509TrustManager() },
				new SecureRandom());

		// 监听和接收客户端连接
		SSLServerSocketFactory factory = context.getServerSocketFactory();
		SSLServerSocket server = (SSLServerSocket) factory
				.createServerSocket(10002);
		System.out.println("ok");
		Socket client = server.accept();
		System.out.println(client.getRemoteSocketAddress());

		// 向客户端发送接收到的字节序列
		OutputStream output = client.getOutputStream();

		// 当一个普通 socket 连接上来, 这里会抛出异常
		// Exception in thread "main" javax.net.ssl.SSLException: Unrecognized
		// SSL message, plaintext connection?
		InputStream input = client.getInputStream();
		byte[] buf = new byte[1024];
		int len = input.read(buf);
		System.out.println("received: " + new String(buf, 0, len));
		output.write(buf, 0, len);
		output.flush();
		output.close();
		input.close();

		// 关闭socket连接
		client.close();
		server.close();
	}

	public static void main(String[] args) throws Exception {
		// notOk();
		sslSocketServer();
	}

	public static class MyX509TrustManager implements X509TrustManager {

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

	}
}
