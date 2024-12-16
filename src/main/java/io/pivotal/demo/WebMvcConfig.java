package io.pivotal.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final WebProperties resourceProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
            .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
            .addResourceLocations("classpath:static/static/")
            .resourceChain(this.resourceProperties.getResources().getChain().isCache())
            .addResolver(new PathResourceResolver());
        registry.addResourceHandler("/**")
            .addResourceLocations(this.resourceProperties.getResources().getStaticLocations())
            .resourceChain(false)
            .addResolver(getResourceResolver());
    }

    private PathResourceResolver getResourceResolver() {
        return new PathResourceResolver() {
            @Override
            public Resource resolveResource(HttpServletRequest request,
                                            @NonNull String requestPath,
                                            @NonNull List<? extends Resource> locations,
                                            @NonNull ResourceResolverChain chain) {

                Resource requestedResource = super.resolveResource(
                    request,
                    requestPath,
                    locations,
                    chain);
                return requestedResource != null ? requestedResource : super.resolveResource(
                    request,
                    "/index.html",
                    locations,
                    chain);
            }
        };
    }
}
