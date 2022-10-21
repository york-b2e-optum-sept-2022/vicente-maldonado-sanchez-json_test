package net.yorksolutions.jsontest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.*;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Service
public class JsonTestService {
//
// String test = "";
//
// public String getIP() {
//  try {
//   InetAddress local = InetAddress.getLocalHost();
//   return local.getHostAddress();
//  } catch (Exception ex) {
//   System.out.println(ex.getMessage());
//  }
// return this.test;
// }

// Adam's Version

public String code(HttpServletRequest request) {
    return "alert(\"your IP Address is:" + request.getRemoteAddr() + "\");";
    }


    public HashMap ip(HttpServletRequest request) {
        HashMap map = new HashMap();
        map.put("ip", request.getRemoteAddr());
        return map;
    }

    public HashMap echo(HttpServletRequest request) {
        HashMap map = new HashMap();
        String uri = request.getRequestURI();
        String[] tokenList = uri.split("/");
       for (int i = 2; i<tokenList.length; i+=2) {
           String key = tokenList[i];
           String value = "";
           if (i + 1 < tokenList.length) {
               value = tokenList[i + 1];
           }
           map.put(
                   key,
                   value);

       }


        return map;
    }


    public HashMap date() {
    Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm:ss aa");
        timeFormatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dateString = dateFormatter.format(date);
        String timeString = timeFormatter.format(date);
    HashMap map = new HashMap();

    map.put("date", dateString);
    map.put("time", timeString);
    map.put("miliseconds since epoch", Instant.now().toEpochMilli());

    return map;
    }
    // Cente
    public HashMap getRequestHeaders(@RequestHeader Map<String, String>  headers) {

        HashMap map = new HashMap();
        headers.forEach((key, value) ->{
            map.put(key, value);
        });
        return map;

    }

    public Map <String, List<String>> getResponseHeaders(HttpServletResponse response) throws IOException {
        HashMap map = new HashMap();
        URL url = new URL("http://localhost:8080/get-request-headers");
        URLConnection conn = url.openConnection();
        Map <String, List<String>> list = conn.getHeaderFields();
//        for (int i = 0; i<5; i++) {
//            list[i].toString
//        }
        System.out.println("list:" + list);
        System.out.println("map:" + map);
        return list;
    }

    public String getCookie(@CookieValue(value = "username", defaultValue = "Atta") String username) {
    return "Your username is:" + username;

    }

    public HashMap setCookie(HttpServletResponse response) {
        HashMap map = new HashMap();
        Cookie cookie = new Cookie("Jsontestdotcom","ms" + Instant.now().toEpochMilli());
        response.addCookie(cookie);
        map.put("cookie_status", "cookie set with name jsontestdotcom");
        return map;
    }

    public HashMap getHeaders(HttpServletRequest request) {
    HashMap map = new HashMap();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            map.put(name, header);
        }


    return map;
    }

    public HashMap md5(@RequestParam String text) {
    HashMap map = new HashMap();
//    HashMap textMd5 = md5(text);
//

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
            byte[] digest = md.digest();
            String md5 = DatatypeConverter.printHexBinary(digest).toLowerCase();
            map.put("Original", text);
            map.put("md5", md5);

        }
        catch(Exception err) {
            System.out.println("error" + err);
        }
        return map;
    }

}
