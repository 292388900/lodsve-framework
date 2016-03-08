package message.swagger2.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import message.swagger2.config.CosmosSwagger2Configuration;
import org.springframework.context.annotation.Import;

/**
 * 启用cosmos-mvc中得swagger2.
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version V1.0, 16/1/18 下午10:50
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({CosmosSwagger2Configuration.class})
public @interface EnableCosmosSwagger2 {
}
