package com.userapp.core;

import com.userapp.model.enums.UserPipeline;
import com.userapp.processors.AppProcessors;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPipelineRegistry {
    private final ApplicationContext context;

    public AppProcessors get(UserPipeline pipeline) {
        return context.getBean(pipeline.getBeanName(), AppProcessors.class);
    }
}
