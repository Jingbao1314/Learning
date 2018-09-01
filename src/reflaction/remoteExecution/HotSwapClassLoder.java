package reflaction.remoteExecution;

/**
 * Created by jingbao on 18-5-8.
 */
public class HotSwapClassLoder extends  ClassLoader{
    public HotSwapClassLoder(){
        super(HotSwapClassLoder.class.getClassLoader());
    }
    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }
}
