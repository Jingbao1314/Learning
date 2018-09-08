package jdk18.org.language.iv;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
public class RepeatingAnnotations {
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    };
//    注释Filter被@Repeatable( Filters.class )注释。Filters 只是一个容器，它持有Filter,
// 编译器尽力向程序员隐藏它的存在。通过这样的方式，Filterable接口可以被Filter注释两次。
    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {
    }
    public static void main(String[] args) {
        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
    }
}

