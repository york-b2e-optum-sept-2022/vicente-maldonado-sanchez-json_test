package net.yorksolutions.jsontest;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JsonTestController {
    private JsonTestService jsonTestService;

    public JsonTestController(JsonTestService jsonTestService) {
        this.jsonTestService = jsonTestService;
    }

    @GetMapping("/IP")
    public HashMap getIP() throws UnknownHostException {
        HashMap IP = new HashMap();
        IP.put("IP", this.jsonTestService.getIP());
        return IP;
    }

    @GetMapping("/get-request-headers")


    public HashMap getRequestHeader(@RequestHeader Map<String, String> headers) {
        HashMap response = new HashMap();
        headers.forEach((key, value) -> {
            response.putIfAbsent(key, value);
            System.out.println(" Name:" + key + " Value:" + value);
        });
        return response;
    }

//    @GetMapping("/getResponseHeaders")
//
//
//    public String getResponseHeader() {
//
//
//        try {
//            URL url = new URL(
//                    "http://localhost:8080/getResponseHeaders"
//            );
//            URLConnection con = url.openConnection();
//            HashMap responseHeaders = new HashMap<>();
//            Map<String, List<String>> map = con.getHeaderFields();
//            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//                String key = entry.getKey();
//                List value = entry.getValue();
//            headers.forEach((key, value) -> {
//                responseHeaders.putIfAbsent(key, value)
//                return key;
//        }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return "error";
//
//
//    }
}
