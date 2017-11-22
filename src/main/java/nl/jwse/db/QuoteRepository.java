package nl.jwse.db;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import io.dropwizard.lifecycle.Managed;
import nl.jwse.api.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuoteRepository implements Managed {


    private static final Logger LOGGER = LoggerFactory.getLogger(QuoteRepository.class);

    private List<Quote> quotes = Collections.synchronizedList(new ArrayList<Quote>());

    private Random randomGenerator = new Random();

    public Quote getQuote() {
        int index = randomGenerator.nextInt(quotes.size());
        return quotes.get(index);
    }


    @Override
    public void start() throws Exception {
        LOGGER.debug("Populating quoterepository");
        CSVReader reader = new CSVReader(new FileReader("quotes.csv"));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            quotes.add(new Quote(Integer.parseInt(nextLine[0]),nextLine[2], nextLine[1]));
        }
    }

    @Override
    public void stop() throws Exception {

    }
}
