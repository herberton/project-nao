package br.com.nao.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.nao.enumerator.Separator;

@Documented
@Target(value={ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface View {
	String menu() default "";
	String name() default "";
	String description() default "";
	Separator separator() default Separator.NONE;
	String[] permissions() default {};
}
