package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.utils.properties;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.utils.commons.ReservedWords;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Properties;

public final class PropertiesFileReader {
    private static final Logger LOGGER = LogManager.getLogger(PropertiesFileReader.class.getSimpleName());
    private static final String ENCODING = "UTF-8";

    private Properties properties;

    /**
     * Initializes an instance of {@link PropertiesFileReader}.
     *
     * @param filePath properties file path String.
     */
    public PropertiesFileReader(final String filePath) {
        LOGGER.info("Reading config file from path:{}", filePath);
        this.init(filePath);
    }

    /**
     * Reads the config file.
     *
     * @param filePath config properties file path String.
     */
    private void init(final String filePath) {
        String path = filePath;

        if (!new File(filePath).exists()) {
            path = filePath.replace(ReservedWords.DOUBLE_DOT_AND_SLASH.val(), ReservedWords.STRING_EMPTY.val());
        }
        try (InputStreamReader inputFile = new InputStreamReader(new FileInputStream(path), ENCODING)) {
            this.properties = new Properties();
            this.properties.load(inputFile);
        } catch (FileNotFoundException e) {
            LOGGER.warn("The properties file couldn't be found", e);
            throw new ExceptionInInitializerError(e);
        } catch (IOException e) {
            LOGGER.warn("A problem of type", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Gets a property value from properties config file.
     *
     * @param propertyName property name as string.
     * @return value of specified property.
     */
    public String getPropertyValue(final String propertyName) {
        String property = System.getProperty(propertyName);
        if (Objects.isNull(property)) {
            property = properties.getProperty(propertyName);
            LOGGER.info("properties.getProperty({}) -> value: {}", propertyName, property);
            return property;
        }

        LOGGER.info("System.getProperty({}) -> value: {}", propertyName, property);
        return property;
    }
}
