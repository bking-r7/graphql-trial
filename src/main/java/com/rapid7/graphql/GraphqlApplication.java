package com.rapid7.graphql;

import com.rapid7.graphql.model.ScanEngine;
import com.rapid7.graphql.model.Site;
import com.rapid7.graphql.repository.ScanEngineRepository;
import com.rapid7.graphql.repository.SiteRepository;
import com.rapid7.graphql.resolver.Mutation;
import com.rapid7.graphql.resolver.Query;
import com.rapid7.graphql.resolver.ScanEngineResolver;
import com.rapid7.graphql.service.DBService;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	public ScanEngineResolver scanEngineResolver(SiteRepository siteRepository)
	{
		return new ScanEngineResolver(siteRepository);
	}

	@Bean
	public Query query(DBService dbservice)
	{
		return new Query(dbservice);
	}

	@Bean
	public Mutation mutation(DBService dbservice)
	{
		return new Mutation(dbservice);
	}

	@Bean
	public CommandLineRunner demo(SiteRepository siteRepository, ScanEngineRepository scanEngineRepository)
	{
		return (args) -> {
			Site site = new Site("toronto office", "toronto");
			siteRepository.save(site);

			scanEngineRepository.save(new ScanEngine(UUID.randomUUID(), "NOT_STARTED", null, true, site));
		};
	}
}
