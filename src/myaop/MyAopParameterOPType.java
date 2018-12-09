package myaop;

/**
 * Created by jingbao on 18-12-5.
 */
public enum MyAopParameterOPType {
    checkForDB("DB"),//特殊字符处理 ,通用转码或者其他处理
    checkForSecurity("security"),//参数是否合法等操作
    checkDeleteAuthority("DeleteAuthority"),
    checkUpdateAuthority("UpdateAuthority");
    private String value;
    private MyAopParameterOPType(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
}
