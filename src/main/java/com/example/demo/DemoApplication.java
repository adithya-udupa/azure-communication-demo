package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.azure.communication.common.CommunicationUserIdentifier;
import com.azure.communication.identity.CommunicationIdentityClient;
import com.azure.communication.identity.CommunicationIdentityClientBuilder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		createAzureUser();
	}

	public static void createAzureUser() {
		try {
			//Please add a valid Azure ConnectionString below. Sample connectionString 'endpoint=https://azure-communication-service1.communication.azure.com/;accesskey=<accessKey>'
			String connectionString = "";
			CommunicationIdentityClient communicationIdentityClient = new CommunicationIdentityClientBuilder()
					.connectionString(connectionString).buildClient();
			CommunicationUserIdentifier result = communicationIdentityClient.createUser();
			System.out.println("User id: " + result.getId());
		} catch (RuntimeException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}
	}

}
