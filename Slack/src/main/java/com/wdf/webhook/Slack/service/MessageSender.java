package com.wdf.webhook.Slack.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.wdf.webhook.Slack.model.Message;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

@Service
public class MessageSender {
	
private static final String HOOKS_URL = "https://hooks.slack.com/services/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";
	
	
	public void sendMessageService(String userName, Message message) throws JsonProcessingException {
		
		System.out.println("User Name is "+userName);
		System.out.println("Message is "+message);
		
		RestTemplate restTemplate = new RestTemplate();
		
		//Set content type -header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		
		//POJO - JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String messageJson = objectMapper.writeValueAsString(message);
		
		//Prepare HTTP request
		HttpEntity<String> entity = new HttpEntity<>(messageJson, headers);
		
		//Executing
		restTemplate.exchange(HOOKS_URL, HttpMethod.POST, entity, String.class);
		
	}
}
