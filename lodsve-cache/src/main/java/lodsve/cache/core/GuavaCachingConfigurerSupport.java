package lodsve.cache.core;

import java.util.List;
import lodsve.core.condition.ConditionalOnExpression;
import lodsve.core.utils.StringParse;
import lodsve.core.utils.StringUtils;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.stereotype.Component;

/**
 * guava.
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version V1.0, 16/4/1 上午9:49
 */
@Component
@ConditionalOnExpression("T(lodsve.cache.annotations.CacheModeHolder).getCacheMode() eq T(lodsve.cache.annotations.CacheMode).GUAVA")
public class GuavaCachingConfigurerSupport extends LodsveCachingConfigurerSupport {
    @Override
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();

        String cacheNames_ = cacheProperties.getCacheNames();
        List<String> cacheNames = StringUtils.convert(cacheNames_, new StringParse<String>() {
            @Override
            public String parse(String str) {
                return str;
            }
        });
        if (!cacheNames.isEmpty()) {
            cacheManager.setCacheNames(cacheNames);
        }

        cacheManager.setCacheSpecification(cacheProperties.getGuava().getSpec());
        return cacheManager;
    }
}
