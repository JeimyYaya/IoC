package com.ejemplo.framework;

import java.io.*;
import java.net.*;

public class HttpServer {

    public static void start(int port) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server running on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleRequest(clientSocket);
        }
    }

    private static void handleRequest(Socket clientSocket) {

        try (
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()))
        ) {

            String inputLine;
            String path = "";
            String query = null;
            boolean firstLine = true;

            while ((inputLine = in.readLine()) != null) {

                if (firstLine) {
                    String[] tokens = inputLine.split(" ");
                    String uriStr = tokens[1];

                    URI uri = new URI(uriStr);
                    path = uri.getPath();
                    query = uri.getQuery();
                    firstLine = false;
                }

                if (!in.ready()) break;
            }

            Request req = new Request(path, query);
            Response res = new Response();

            Route route = Router.getRoute(path);

            if (route != null) {

                String body = route.handle(req, res);

                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: " + res.getContentType());
                out.println();
                out.println(body);

            } else {

                byte[] fileData = StaticFileHandler.getFile(path);

                if (fileData != null) {
                    OutputStream rawOut = clientSocket.getOutputStream();
                    BufferedOutputStream dataOut = new BufferedOutputStream(rawOut);

                    String headers = "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/html\r\n" +
                            "Content-Length: " + fileData.length + "\r\n" +
                            "\r\n";

                    dataOut.write(headers.getBytes());
                    dataOut.write(fileData);
                    dataOut.flush();
                } else {
                    out.println("HTTP/1.1 404 Not Found");
                    out.println();
                    out.println("404 Not Found");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}