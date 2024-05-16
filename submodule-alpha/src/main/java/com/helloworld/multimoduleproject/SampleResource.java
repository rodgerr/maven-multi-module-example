package com.helloworld.multimoduleproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.helloworld.multimoduleproject.shared.SharedCoreClass;

@Controller
public class SampleResource {

    @GetMapping("/hello-world")
    @ResponseBody
    public String sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        SharedCoreClass.sharedSampleFunction();
        return "hello "+name;
    }

}