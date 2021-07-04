package com.example.jackson.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Objects;

/**
 * @author xiaoxuxuy
 */
public class IoUtil {
    public static byte[] readInputStream(InputStream inputStream, String inputStreamName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[16 * 1024];
        try {
            int bytesRead = inputStream.read(buffer);
            while (bytesRead != -1) {
                outputStream.write(buffer, 0, bytesRead);
                bytesRead = inputStream.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    public static String readFileAsString(String filePath) {
        byte[] buffer = new byte[(int) Objects.requireNonNull(getFile(filePath)).length()];
        BufferedInputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(Objects.requireNonNull(getFile(filePath))));
            inputStream.read(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IoUtil.closeSilently(inputStream);
        }
        return new String(buffer);
    }

    public static File getFile(String filePath) {
        URL url = IoUtil.class.getClassLoader().getResource(filePath);
        try {
            return new File(Objects.requireNonNull(url).toURI());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeStringToFile(String content, String filePath) {
        BufferedOutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(Objects.requireNonNull(getFile(filePath))));
            outputStream.write(content.getBytes());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IoUtil.closeSilently(outputStream);
        }
    }

    /**
     * Closes the given stream. The same as calling {@link InputStream#close()}, but errors while
     * closing are silently ignored.
     */
    public static void closeSilently(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException ignore) {
            // Exception is silently ignored
        }
    }

    /**
     * Closes the given stream. The same as calling {@link OutputStream#close()} , but errors while
     * closing are silently ignored.
     */
    public static void closeSilently(OutputStream outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException ignore) {
            // Exception is silently ignored
        }
    }
}
