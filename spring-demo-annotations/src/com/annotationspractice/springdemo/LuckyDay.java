package com.annotationspractice.springdemo;

import org.springframework.stereotype.Component;

@Component
public class LuckyDay implements FortuneService {
	public String getFortune() {
		return "Today is a lucky day";
	}
}
