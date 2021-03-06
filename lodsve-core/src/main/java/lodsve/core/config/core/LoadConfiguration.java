package lodsve.core.config.core;

import lodsve.core.condition.ConditionalOnWebApplication;
import lodsve.core.config.loader.ini.IniLoader;
import lodsve.core.config.loader.properties.ConfigurationLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version V1.0, 16/5/5 下午2:53
 */
@Component
@ConditionalOnWebApplication
public class LoadConfiguration implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(LoadConfiguration.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            ConfigurationLoader.init();
            IniLoader.init();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
