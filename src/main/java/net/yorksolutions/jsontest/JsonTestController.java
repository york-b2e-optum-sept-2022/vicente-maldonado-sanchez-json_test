package net.yorksolutions.jsontest;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JsonTestController {
    private JsonTestService jsonTestService;



//    @GetMapping("/IP")
//    public HashMap getIP() throws UnknownHostException {
//        HashMap IP = new HashMap();
//        IP.put("IP", this.jsonTestService.getIP());
//        return IP;
//    }
//
    @GetMapping("/get-request-headers")


    public HashMap getRequestHeader(@RequestHeader Map<String, String> headers) {
        return this.jsonTestService.getRequestHeaders(headers);
    }

    @GetMapping("/get-response-headers")
    public Map <String, List<String>> getResponseHeaders(HttpServletResponse response) throws IOException {
       return this.jsonTestService.getResponseHeaders(response);
    }

    @GetMapping("/cookie")
    public String getCookie(@CookieValue(value = "username", defaultValue = "Atta") String username) {
       return this.jsonTestService.getCookie(username);
    }



    // Adam's Version

    public JsonTestController(JsonTestService jsonTestService) {
        this.jsonTestService = jsonTestService;
    }

    @GetMapping("/code")
    public String code(HttpServletRequest request) {
        return this.jsonTestService.code(request);
    }

    @GetMapping("/ip")
    public HashMap ip(HttpServletRequest request) {
        return this.jsonTestService.ip(request);
    }

    @GetMapping("/echo/**")
    public HashMap echo(HttpServletRequest request) {

        return this.jsonTestService.echo(request);

    }

    @GetMapping("/date")
    public HashMap time() {
        return this.jsonTestService.date();
    }

    @GetMapping("/headers")
        public HashMap getHeaders(HttpServletRequest request) {

        return this.jsonTestService.getHeaders(request);
        }

        @GetMapping("/set-cookie")
    public HashMap setCookie(HttpServletResponse response) {
        return this.jsonTestService.setCookie(response);
        }

        @GetMapping("/md5")
    public HashMap md5(@RequestParam String text) {
        return this.jsonTestService.md5(text);

        }

}
