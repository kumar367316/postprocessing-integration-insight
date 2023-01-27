package com.custom.postprocessing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.custom.postprocessing.entity.PostProcessingJsonEntity;
import com.custom.postprocessing.scheduler.PostProcessingScheduler;

/**
 * @author kumar.charanswain
 *
 */
@RequestMapping("postprocessing")
@RestController
public class PostProcessingController {

	public static final Logger logger = LoggerFactory.getLogger(PostProcessingController.class);
	
    @Autowired
    private PostProcessingScheduler postProcessingScheduler;

    @GetMapping("formoperation")
    public PostProcessingJsonEntity manualPostProcessBatch() {

    	logger.info("manualPostProcessBatch method info");
    	logger.warn("manualPostProcessBatch method warn");
    	logger.debug("manualPostProcessBatch method info");
    	PostProcessingJsonEntity postProcessingJsonEntity = postProcessingScheduler.smartCommPostProcessing();
    	
    	return postProcessingJsonEntity;
    }
    
    @GetMapping("test")
    public String apiTest() {
 
    	logger.info("apiTest method info");
    	logger.warn("apiTest method warn");
    	logger.debug("apiTest method info");
    	logger.error("apiTest method info");
    	logger.trace("apiTest method trace");
    	return "api testing in azure app services";
    }
    
}
