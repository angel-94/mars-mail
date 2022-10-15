package com.mars.mail;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Angel Ruiz
 * @version 1.0.0
 * date 14/10/22
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "/mail/api/v1")
public class SenderController {

	private final EmailSenderService emailSenderService;

	@GetMapping
	public void sender(@RequestParam(name = "to") String to) throws Exception {
		var subject = "Mars mail test";
		var body = """
				<!doctype html>
				<html lang="en">
				<head>
				    <meta charset="UTF-8">
				    <meta name="viewport"
				          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
				    <meta http-equiv="X-UA-Compatible" content="ie=edge">
				    <title>Document</title>
				</head>
				<body>
				    <h1>Este es un mensaje de prueba desde mars</h1>
				</body>
				</html>
				""";
		emailSenderService.sendMail(to, body, subject);
	}

}
