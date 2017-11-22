package nl.jwse;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.jwse.db.QuoteRepository;
import nl.jwse.resources.QuoteResource;

public class QuoteServiceApplication extends Application<QuoteServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new QuoteServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "quoteservice";
    }

    @Override
    public void initialize(final Bootstrap<QuoteServiceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final QuoteServiceConfiguration configuration,
                    final Environment environment) {


        QuoteRepository quoteRepository = new QuoteRepository();

        environment.lifecycle().manage(quoteRepository);

        QuoteResource quoteResource = new QuoteResource(quoteRepository);

        environment.jersey().register(quoteResource);

    }

}
