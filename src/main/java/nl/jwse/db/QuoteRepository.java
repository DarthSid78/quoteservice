package nl.jwse.db;

import com.opencsv.CSVReader;
import io.dropwizard.lifecycle.Managed;
import nl.jwse.api.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Repository containing quotes.
 */
public class QuoteRepository implements Managed {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuoteRepository.class);

    private final List<Quote> quotes = Collections.synchronizedList(new ArrayList<Quote>());

    private final Random randomGenerator = new Random();

    @Override
    public void start() throws Exception {
        LOGGER.info("Start populating quote repository");
        CSVReader reader = new CSVReader(new FileReader("quotes.csv"));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            quotes.add(new Quote(Integer.parseInt(nextLine[0]),nextLine[2], nextLine[1]));
        }
        LOGGER.info("Finished populating repository with " + quotes.size() + " quotes");
    }

    @Override
    public void stop() throws Exception {

    }

    /**
     * Returns a random quote.
     * @return quote
     */
    public Quote getQuote() {
        int index = randomGenerator.nextInt(quotes.size());
        return quotes.get(index);
    }
}
