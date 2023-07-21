package com.wdf.webhook.Slack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wdf.webhook.Slack.model.Message;
import com.wdf.webhook.Slack.service.MessageSender;

@CrossOrigin(origins = "*")
@RestController
public class MessageInterceptorController {
	@Autowired
	MessageSender ms_service;
	
	
	@PostMapping("/messages/{userName}")
	public void sendMessage(@PathVariable String userName, @RequestBody Message message) throws JsonProcessingException {
		ms_service.sendMessageService(userName, message);
		
	}

}
