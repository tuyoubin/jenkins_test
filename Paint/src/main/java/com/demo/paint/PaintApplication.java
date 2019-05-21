package com.demo.paint;

import com.demo.paint.data.fileHelper.FileSystemInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaintApplication {

	public static void main(String[] args) {
		FileSystemInitializer f = new FileSystemInitializer();
		f.initFileSystem();
		SpringApplication.run(PaintApplication.class, args);
	}
}
