package nio.socket.netty.ssl.https;

/**
 * Created by andilyliao on 16-6-9.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

import sun.misc.*;
public class ExportPrivateKey {
    private File keystoreFile;
    private String keyStoreType;
    private char[] password;
    private String alias;
    private File prifile;
    private static File certfile;
    private static File pubfile;
    public static KeyPair getPrivateKey(KeyStore keystore, String alias, char[] password) {
        try {
            Key key=keystore.getKey(alias,password);
            if(key instanceof PrivateKey) {
                Certificate cert=keystore.getCertificate(alias);
                BASE64Encoder encoder=new BASE64Encoder();
                String encoded=encoder.encode(cert.getEncoded());
                FileWriter fw=new FileWriter(certfile);
                fw.write("-----BEGIN CERTIFICATE-----\n");
                fw.write(encoded);
                fw.write("\n");
                fw.write("-----END CERTIFICATE-----\n");
                fw.close();
                PublicKey publicKey=cert.getPublicKey();
                encoded=encoder.encode(publicKey.getEncoded());
                fw=new FileWriter(pubfile);
                fw.write("-----BEGIN RSA PUBLIC KEY-----\n");
                fw.write(encoded);
                fw.write("\n");
                fw.write("-----END RSA PUBLIC KEY-----\n");
                fw.close();
                return new KeyPair(publicKey,(PrivateKey)key);
            }
        } catch (UnrecoverableKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (KeyStoreException e) {
        } catch (CertificateEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void export() throws Exception{
        KeyStore keystore=KeyStore.getInstance(keyStoreType);//存密钥格式
        BASE64Encoder encoder=new BASE64Encoder();
        keystore.load(new FileInputStream(keystoreFile),password);
        KeyPair keyPair=getPrivateKey(keystore,alias,password);
        PrivateKey privateKey=keyPair.getPrivate();
        String encoded=encoder.encode(privateKey.getEncoded());
        FileWriter fw=new FileWriter(prifile);
        fw.write("-----BEGIN RSA PRIVATE KEY-----\n");
        fw.write(encoded);
        fw.write("\n");
        fw.write("-----END RSA PRIVATE KEY-----\n");
        fw.close();
    }
    public static void main(String args[]) throws Exception{
        ExportPrivateKey export=new ExportPrivateKey();
        export.keystoreFile=new File("/disk/test/iotest/src/org/nio/netty/ssl/https/ssltest.jks");
        export.keyStoreType="JKS";//XPS PSX
        export.password="123456".toCharArray();
        export.alias="ssltest.com";
        export.prifile=new File("/disk/test/iotest/src/org/nio/netty/ssl/https/luke");
        certfile=new File("/disk/test/iotest/src/org/nio/netty/ssl/https/luke1");
        pubfile=new File("/disk/test/iotest/src/org/nio/netty/ssl/https/luke2");
        export.export();
    }
}
