package net.yorksolutions.jsontest;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

@RestController
public class JsonTestController {

    //    @ResponseBody
//    @GetMapping ("/geturl")
//    public String getURLValue(HttpServletRequest request){
//        //get URL value here which should be in this case, for instance if urlid
//        //is 1 in request then  "/my/absolute/url/1/tests"
//        String test = request.getRequestURI();
//        return test;
//    }

    private JsonTestService jsonTestService;

    public JsonTestController(JsonTestService jsonTestService) {
        this.jsonTestService = jsonTestService;
    }

    @GetMapping("/IP")
    public HashMap getIP() throws UnknownHostException {
        HashMap IP = new HashMap();
        IP.put("IP",this.jsonTestService.getIP());
        return IP;
    }

    @GetMapping("/get_headers")
    public HashMap getHeader() {
        return this.jsonTestService.getHeaders();
    }
}
