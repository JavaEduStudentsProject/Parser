//package com.example.parseproject.controller;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
////@RestController
////@CrossOrigin("*")
//public class OrchestratorController {
////URL url = new URL("http://localhost:8082/api/products");
////
//    public static void main(String[] args) throws IOException {
//
//
//
//        URL url = new URL("http://localhost:8082/api/hello");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//        connection.setDoOutput(true);
//        connection.setRequestProperty("Cookie", "JSESSIONID=104200BBA2D1992976448F5E07A4BFF6");
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(
//                connection.getInputStream()))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (Exception e) {
//            assert e != null;
//            e.printStackTrace();
//        }
//    }
//
//}
