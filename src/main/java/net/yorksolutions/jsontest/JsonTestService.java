package net.yorksolutions.jsontest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Service
public class JsonTestService {

 String test = "";

 public String getIP() {
  try {
   InetAddress local = InetAddress.getLocalHost();
   return local.getHostAddress();
  } catch (Exception ex) {
   System.out.println(ex.getMessage());
  }
 return this.test;
 }





}
