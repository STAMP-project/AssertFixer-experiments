package fr.ird.osmose.web.api.process;

/**
 * Accepts value candidates and provides a way to select value from those accepted.
 */

public interface ValueSelector {
    void accept(String value);
    String select();
}
