package reflaction.remoteExecution;

/**
 * Created by jingbao on 18-5-8.
 */
public class ByteUtils {
    public static int bytes2Int(byte[] b,int start,int len){//查看tag的类型
        int sum=0;
        int end=start+len;
        for(int i=start;i<end;i++){
            int n=((int)b[i]) & 0xff;
            n<<=(--len)*8;
            sum=n+sum;
        }
        return sum;
    }
    public static byte[] int2Byte(int value,int len){
        byte[] b=new byte[len];
        for(int i=0;i<len;i++){
            b[len-i-1]=(byte)((value>>8*i)&0xff);
        }
        return b;

    }
    public static String byte2String(byte[] b,int start,int len){
        return new String(b,start,len);
    }
    public static byte[] string2Byte(String string){
        return string.getBytes();
    }
    public static byte[] bytesReplace(byte[] originalBytes,int offset,int
            len,byte[] replaceBytes){
        byte[] newBytes=new byte[originalBytes.length+(replaceBytes
                .length-len)];
        System.arraycopy(originalBytes,0,newBytes,0,offset);
        System.arraycopy(replaceBytes,0,newBytes,offset,replaceBytes.length);
        System.arraycopy(originalBytes,offset+len,newBytes,
                offset+replaceBytes.length,originalBytes.length-offset-len);
        return newBytes;
    }
}
