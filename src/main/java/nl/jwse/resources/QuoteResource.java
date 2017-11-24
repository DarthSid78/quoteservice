package nl.jwse.resources;

import com.codahale.metrics.annotation.Timed;
import nl.jwse.api.Quote;
import nl.jwse.db.QuoteRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/quote")
@Produces(MediaType.APPLICATION_JSON)
public class QuoteResource {

    private final QuoteRepository repository;

    public QuoteResource(QuoteRepository repository) {
        this.repository = repository;
    }

    @GET
    @Timed
    public Quote getQuote() {
        return repository.getQuote();
    }
}
