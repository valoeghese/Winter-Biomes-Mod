package tk.valoeghese.winterbiomemod.biome.util;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface NoiseSurface {
	// I was bored so I made it an annotation instead of an interface
	public int value();
}
