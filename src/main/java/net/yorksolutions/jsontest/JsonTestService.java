package net.yorksolutions.jsontest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;

@Service
public class JsonTestService {

 String test = "";

 public String getIP() throws UnknownHostException {
  try {
   InetAddress local = InetAddress.getLocalHost();
   return local.getHostAddress();
  } catch (Exception ex) {
   System.out.println(ex.getMessage());
  }
 return this.test;
 }

 public HashMap getHeaders() {
 HashMap headers = new HashMap<>();
 return headers;
 }

}
