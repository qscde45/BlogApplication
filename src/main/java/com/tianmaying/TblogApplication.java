package com.tianmaying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootApplication
@Controller
public class TblogApplication {

    @RequestMapping("/")
    @ResponseBody
    String greeting() {
        return "Hello World";
    }

    @RequestMapping("/index.html")
    @ResponseBody
    public String index() {
        return "<html><head><title>Hello World!</title></head><body><h1>Hello World!</h1><p>This is my first web site</p></body></html>";
    }

    //你应该在这里添加一个新的方法,用于处理/time请求,返回当前时间
    //时间格式示例（年-月-日 时:分:秒）：2016-08-24 16:33:24
    @RequestMapping("/time")
    @ResponseBody
    public String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public static void main(String[] args) {
        SpringApplication.run(TblogApplication.class, args);
    }

}
