package com.userapp.config;

import com.userapp.model.context.UserContext;
import com.userapp.processors.AppProcessors;
import com.userapp.processors.ProcessorStep;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserPipelineConfig {

    @Bean("pipeline.user.create")
    public AppProcessors createPipeline(
            @Qualifier("step.user.validate") ProcessorStep<UserContext> validate,
            @Qualifier("step.user.save") ProcessorStep<UserContext> save,
            @Qualifier("step.user.errorLogger") ProcessorStep<UserContext> error) {
        return new AppProcessors(List.of(
                validate,
                save,
                error
        ));
    }

    @Bean("pipeline.user.update")
    public AppProcessors updatePipeline(
            @Qualifier("step.user.exists") ProcessorStep<UserContext> exists,
            @Qualifier("step.user.validate") ProcessorStep<UserContext> validate,
            @Qualifier("step.user.update") ProcessorStep<UserContext> save,
            @Qualifier("step.user.errorLogger") ProcessorStep<UserContext> error) {
        return new AppProcessors(List.of(
                exists,
                validate,
                save,
                error
        ));
    }

    @Bean("pipeline.user.findById")
    public AppProcessors findByIdPipeline(
            @Qualifier("step.user.findById") ProcessorStep<UserContext> find,
            @Qualifier("step.user.errorLogger") ProcessorStep<UserContext> error) {
        return new AppProcessors(List.of(
                find,
                error
        ));
    }

    @Bean("pipeline.user.findAll")
    public AppProcessors findAllPipeline(
            @Qualifier("step.user.findAll") ProcessorStep<UserContext> find,
            @Qualifier("step.user.errorLogger") ProcessorStep<UserContext> error) {
        return new AppProcessors(List.of(
                find,
                error
        ));
    }
}
