package tk.valoeghese.winterbiomemod;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(CLASS)
@Target({ FIELD, METHOD })
/**
 * Indicates a required field / builder method
 */
public @interface Required {
}
