package com.starv.micro.goods.conf;

import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.starv.micro.goods.model.AppCassandraConnectionDetails;
import org.springframework.boot.autoconfigure.cassandra.CassandraConnectionDetails;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.ReactiveSession;
import org.springframework.data.cassandra.ReactiveSessionFactory;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.cql.ReactiveCqlTemplate;

import java.util.List;

@Configuration
public class CassandraConfig {

    @Bean
    @Primary
    public CassandraConnectionDetails getCassandraConnectionDetails(List<CassandraConnectionDetails> details) {
        final List<CassandraConnectionDetails.Node> nodes = details.stream()
                .flatMap(detail -> detail.getContactPoints().stream())
                .toList();
        return new AppCassandraConnectionDetails(nodes, "datacenter1");
    }


    @Bean
    public ReactiveCqlTemplate createReactiveCqlTemplate(ReactiveSessionFactory sessionFactory) {
        ReactiveCqlTemplate template = new ReactiveCqlTemplate(sessionFactory);
        template.setConsistencyLevel(ConsistencyLevel.ALL);
        return template;
    }

}
