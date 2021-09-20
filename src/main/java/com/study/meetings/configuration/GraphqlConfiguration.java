package com.study.meetings.configuration;

import com.study.meetings.resolvers.Mutation;
import com.study.meetings.resolvers.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public Query query() {
        return new Query();
    }

    @Bean
    public Mutation mutation() {
        return new Mutation();
    }

}
