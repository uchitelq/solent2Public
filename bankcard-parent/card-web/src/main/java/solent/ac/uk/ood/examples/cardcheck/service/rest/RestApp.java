package solent.ac.uk.ood.examples.cardcheck.service.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class RestApp extends ResourceConfig {

	public RestApp() {
		packages("solent.ac.uk.ood.examples.cardcheck.service.rest");
	}
}
