package app.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;

public class Base64DecodedMultipartFile implements MultipartFile {
    private final byte[] imgContent;

    public Base64DecodedMultipartFile(byte[] imgContent) {
        this.imgContent = imgContent;
    }

    @Override
    public String getName() {
        return "base64";
    }

    @Override
    public String getOriginalFilename() {
        return "base64";
    }

    @Override
    public String getContentType() {
        return "image/jpeg"; // or other image type
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(imgContent);
    }

    public static MultipartFile base64ToMultipart(String base64) {
        // Splitting the string, in case it has "data:image/jpeg;base64," before the actual encoded content
        String[] base64Components = base64.split(",");
        String base64String;
        if (base64Components.length > 1) {
            base64String = base64Components[1];
        } else {
            base64String = base64Components[0];
        }

        byte[] fileBytes = Base64.getDecoder().decode(base64String);
        return new Base64DecodedMultipartFile(fileBytes);
    }
}