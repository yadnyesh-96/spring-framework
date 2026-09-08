package com.bank.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SmsNotificationService implements NotificationService {

	@Override
	public void sendNotification(String message) {

		System.out.println("SMS Notification: " + message);

	}

}
