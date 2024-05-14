package ra.orm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // đây là lớp hình
@EnableWebMvc
@ComponentScan(basePackages = "ra.orm") // quét package để phát hiện các thành phần (component) và tạo bean
// (@Component,@Controller, @Service , @Repository)
public class WebMVCConfig implements WebMvcConfigurer {
    // view , model, controller
    // bean ViewResolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver; // truy cập thông qua tên view
    }

    // cấu hình khác
}
