package com.unaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.unaj.sockets.SocketConexion;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		SocketConexion sc = new SocketConexion("SC1","25.3.149.30",8000);
        sc.SendMensaje("|LP*Ard1EOF");
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "12345";
		for (int i = 0; i < 4; i++) {
			String passwordBcrypt = this.passwordEncoder.encode(password);
			System.out.println(passwordBcrypt);
		}
		
	}

}
