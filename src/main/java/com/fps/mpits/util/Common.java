package com.fps.mpits.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 */

public class Common {

    private static final Logger logger = LoggerFactory.getLogger(Common.class);

    private Common() {

    }

    public static String getStackTrace(Throwable e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        printWriter.close();
        try {
            stringWriter.close();
        } catch (IOException ex) {
            logger.error(Constant.ExceptionText.ERROR_PROCESS_DATA + e.getMessage());
            ex.getMessage();
        }
        return stringWriter.toString();
    }

    static String getPasswordWithSalt(String username, String rawPassword) {
        return String.format("%s ~!@#$%%^&*()_+ %s", username, rawPassword);
    }

}
