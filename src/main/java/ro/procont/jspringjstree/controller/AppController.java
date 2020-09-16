package ro.procont.jspringjstree.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ro.procont.jspringjstree.model.Asset;

import ro.procont.jspringjstree.service.AssetService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private AssetService assetService;
    
    @RequestMapping("/")
    public String getIndex(ModelMap model) {
        model.addAttribute("message", "Hello world from controller!");
        return "index";
    }
    
    
    @RequestMapping("/jstree")
    public String getJsTree(ModelMap model) {
        model.addAttribute("message", "Hello world from controller!");
        return "jsTree";
    }
    
    
    @RequestMapping("/jstree1")
    public String getJsTree1(ModelMap model) {
        model.addAttribute("message", "Hello world from controller!");
        return "jsTree1";
    }
 
    
    
    @RequestMapping("/complex")
    public String about() {
        return "jsTreeComplex";
    }
    
    
    //return json data/called from js using ajax
    @RequestMapping("/assets")
    @ResponseBody
    public List<Asset> getAssets(){
    	return assetService.findAll();
    }
    
 
}