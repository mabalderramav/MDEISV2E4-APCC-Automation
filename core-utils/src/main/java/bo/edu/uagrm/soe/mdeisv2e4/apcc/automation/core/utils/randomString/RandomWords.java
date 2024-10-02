package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.utils.randomString;

import java.util.UUID;

/**
 * Handles RandomWords util.
 */
public final class RandomWords {

    /**
     * Private constructor for {@link RandomWords} utility class.
     */
    private RandomWords() {
    }

    /**
     * Generates word with UUID.
     *
     * @return a words with Uuid format.
     */
    public static String generateWordWithUuid() {
        return UUID.randomUUID().toString();
    }
}
