package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonFileReader {

    private static final Logger log = Logger.getLogger(JsonFileReader.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T readJsonFile(String path, Class<T> destionObject) {
        try {
            log.info("Read JSON file with test data. File path: "+path);
            File file = new File(path);
            if (!file.exists() || file.isDirectory()) {
                log.error("Can't find data. File path: " + path);
                throw new IOException();
            }
            return mapper.readValue(file, destionObject);
        } catch (IOException e) {
            log.error("Can't find data file. Error: " + e.getMessage());
        }
        return null;
    }
}

