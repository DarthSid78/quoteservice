package nl.jwse.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote {

    private final long id;

    private final String author;

    private final String content;

    public Quote(long id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getAuthor() {
        return author;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
