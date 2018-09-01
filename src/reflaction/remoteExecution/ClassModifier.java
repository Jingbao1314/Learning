package reflaction.remoteExecution;

/**
 * Created by jingbao on 18-5-8.
 */
public class ClassModifier {
    private  static final int CONSTANT_POLL_COUNT_INDEX=8;
    private static final int u1=1;
    private static final int u2=2;
    private static final int CONTANT_utf8_info=1;
    private static final int[] CONTENT_ITEM_LENGTH={-1,-1,-1,5,5,9,9,3,3,5,5,
            5,5};
    private byte[] classByte;
    public ClassModifier(byte[] classByte){
        this.classByte=classByte;
    }
    public byte[] modifyUTF8Constant(String newStr,String oldStr){
        int constantCount=getConstantPollCount();
        int offset=CONSTANT_POLL_COUNT_INDEX+u2;
        for(int i=0;i<constantCount;i++){
            int tag=ByteUtils.bytes2Int(classByte,offset,u1);
            if(tag==CONTANT_utf8_info){
                int len=ByteUtils.bytes2Int(classByte,offset+u1,u2);
                offset+=(u1+u2);
                String str=ByteUtils.byte2String(classByte,offset,len);
                if(str.equalsIgnoreCase(oldStr)){
                    byte[] strBytes=ByteUtils.string2Byte(newStr);
                    byte[] strLen=ByteUtils.int2Byte(newStr.length(),u2);
                    classByte=ByteUtils.bytesReplace(classByte,offset-u2,u2,
                            strLen);
                    classByte=ByteUtils.bytesReplace(classByte,offset,len,
                            strBytes);
                }else{
                    offset+=len;
                }
            }else {
                offset+=CONTENT_ITEM_LENGTH[tag];
            }

        }
        return classByte;

    }
    public int getConstantPollCount(){
        return ByteUtils.bytes2Int(classByte,CONSTANT_POLL_COUNT_INDEX,u2);
    }
}
