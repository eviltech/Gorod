import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class log4jExample {
    /* Get actual class name to be printed on */


    public void mainu()
            throws IOException,SQLException{
        Logger log = Logger.getLogger(
                log4jExample.class.getName());
        log.debug("Hello this is an debug message");
        log.info("Hello this is an info message");
    }
}