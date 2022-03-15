package idv.fc.proxy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD })
public @interface Authority {
	idv.fc.enums.Authority value() default idv.fc.enums.Authority.DEFAULT;
}
