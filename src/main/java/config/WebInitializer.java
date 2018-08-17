package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author xiongchenyang
 * @version [1.0 , 2018/8/17]
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 配置spring 的上下文
     */
    protected Class<?>[] getRootConfigClasses() {
        //这个是激活当前环境生效的配置文件，最好不要这样写，用spring.profiles.default就行了，选择默认生效环境
        //System.setProperty("spring.profiles.active", "pro");
        System.setProperty("spring.profiles.default","dev");
        return new Class<?>[]{SpringConfig.class};
    }

    /**
     * 配置springmvc的上下文
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringmvcConfig.class};
    }

    /**
     * Dispatcher对应的处理器映射
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
