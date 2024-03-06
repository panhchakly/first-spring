package com.panhchakly.firstspring.TestController;

import com.panhchakly.firstspring.dto.TestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class TestController {
    // response Entity
    @RequestMapping("/response-entity")
    public ResponseEntity<Map<String, Object>> responseEntity(){
        TestDto testDto = new TestDto();
        testDto.setName("Chheng Panhchakly");
        testDto.setPassword("1233434");
        // setup hashmap response entity
        Map<String, Object> map = new HashMap<>();
        map.put("STATUS", true);
        map.put("DATA", testDto);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    // response Body
    @RequestMapping("/response-body")
    @ResponseBody
    public TestDto responseBody(){
        TestDto testDto = new TestDto();
        testDto.setName("Chheng Panhchakly");
        testDto.setPassword("1233434");
        return testDto;

    }

    //RequestBody
    @PostMapping("/post")
    @ResponseBody
    public TestDto postName(@RequestBody TestDto dto){
        System.out.println(dto.getName());
        return dto;
    }
    //PathVariable
    @RequestMapping("/path-variable/{name}") // used to map requests to controllers methods
    public String path_variable(Model model, @PathVariable("name") String name){
        model.addAttribute("name", name);
        return "hi";
    }
    // RequestParam
    @RequestMapping("/hi") // used to map requests to controllers methods
    public String Hi(Model model, @RequestParam(value = "name", defaultValue = "Chheng Panhchakly") String name){
        model.addAttribute("name", name);
        return "hi";
    }
    @ResponseBody // response body through an HttpMessageWriter.
    @RequestMapping("/hello") // used to map requests to controllers methods
    public String Hello(){
        return "String return hello";
    }
}
