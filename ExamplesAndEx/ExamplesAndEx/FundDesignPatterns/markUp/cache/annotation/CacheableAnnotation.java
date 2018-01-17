package markUp.cache.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME) //to enable reflection. default is CLASS


public @interface CacheableAnnotation
{
	boolean isMarked();
}
