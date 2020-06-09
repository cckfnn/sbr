package com.sbt.jschool.lesson5;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.Scanner;

public class MainURL {

    private static void readContent(String url) throws IOException {
        Object content = new URL(url).getContent();

        if (content instanceof InputStream) {
            InputStream contentStream = (InputStream) content;
            try (Scanner contentScanner = new Scanner(contentStream)) {
                while (contentScanner.hasNext()) {
                    System.out.println(contentScanner.next());
                }
            }
        } else {
            throw new IOException("Unsupported content kind");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Type url: (q - exit)");
            String url = scanner.next();
            if (url.equals("q")) break;
            try {
                readContent(url);

            } catch (MalformedURLException e) {
                System.err.println("Malformed URL specified!");
            } catch (UnknownHostException e) {
                System.err.println("Unknown host!");
            } catch (UnknownServiceException e) {
                System.err.println("No content type!");
            } catch (IOException e) {
                System.err.println("Unable to get site content. " + e.getMessage());
                throw e;
            }
            System.out.println("Try again");
        }
    }
}
