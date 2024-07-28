package basepackage.com.config;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        event.getServletContext().setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);
        context.refresh();
    }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        if (context instanceof AnnotationConfigWebApplicationContext) {
            ((AnnotationConfigWebApplicationContext) context).close();
        }
    }
}