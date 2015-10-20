package cn.com.rexen.demo.entities;

/**
 * Simple object to test JSONB.
 */
public class JSONBDocument {

    private long created;
    private String description;

    public JSONBDocument() {
    }

    public long getCreated() {
        return created;
    }

    public JSONBDocument created(final long created) {
        this.created = created;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JSONBDocument description(final String description) {
        this.description = description;
        return this;
    }

}
