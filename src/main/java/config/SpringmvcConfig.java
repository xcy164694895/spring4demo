package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.DefaultTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import java.util.Properties;

/**
 * Created by yehao on 16/7/15.
 * springmvc配置类
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.idg"}, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Service.class)})
public class SpringmvcConfig extends WebMvcConfigurerAdapter {


    /**
     * 配置velocity
     *
     * @return
     */
//    @Bean
//    public VelocityConfigurer velocityConfigurer() {
//        VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
//        velocityConfigurer.setResourceLoaderPath("/WEB-INFO/view/");
//        Properties properties = new Properties();
//        properties.put("input.encoding", "UTF-8");
//        properties.put("output.encoding", "UTF-8");
//        velocityConfigurer.setVelocityProperties(properties);
//        return velocityConfigurer;
//    }

    /**
     * 配置velocity视图解析器
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        VelocityViewResolver velocityViewResolver = new VelocityViewResolver();
        velocityViewResolver.setSuffix(".vm");
        velocityViewResolver.setContentType("text/html;charset=UTF-8");
        return velocityViewResolver;
    }

    /**
     * 配置默认视图解析器
     *
     * @return
     */
//    @Bean
    public ViewResolver defaultViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INFO/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    /**
     * 配置静态资源处理
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean // 配置生成模板解析器
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过<span style="font-family:Arial, Helvetica, sans-serif;">WebApplicationContext 的方法获得</span>
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(
                webApplicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INFO/view/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        // 设置模板模式,也可用字符串"HTML"代替,此处不建议使用HTML5,原因看下图源码
//        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

    @Bean // 生成模板引擎并为模板引擎注入模板解析器
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    @Bean // 生成视图解析器并未解析器注入模板引擎
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setContentType("text/html; charset=utf-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }


}
