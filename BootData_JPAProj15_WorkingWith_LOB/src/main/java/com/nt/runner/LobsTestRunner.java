package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.PersonInfo;
import com.nt.service.IPersonMgmtService;

@Component
public class LobsTestRunner implements CommandLineRunner {
	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*=========================Logic to save objects===================================================
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter name : ");
				String name = sc.next();
				System.out.print("Is married : ");
				boolean married = sc.nextBoolean();
				System.out.print("Enter photoPath : ");
				String photoPath = sc.next();
				System.out.println(photoPath);
				System.out.print("Enter ResumePath : ");
				String resumePath = sc.next();
				System.out.println(resumePath);
		
				// create byte[] representing photo file content
				InputStream is = new FileInputStream(photoPath);
				byte[] photoContent = new byte[is.available()];
				photoContent = is.readAllBytes();
		
				// create char[] representing resume file content
				FileReader reader = new FileReader(resumePath);
				File file = new File(resumePath);
				char[] resumeContent = new char[(int) file.length()];
				reader.read(resumeContent);
		
				// prepare with Entity object with data
				PersonInfo info = new PersonInfo(null, name, LocalDateTime.of(1999, 8, 30, 10, 30), married, photoContent,
						resumeContent);
		
				try (sc; is; reader) {
					System.out.println(service.registerPerson(info));
		
				} catch (Exception e) {
					e.printStackTrace();
				}
				*/
		// ====================================Logic to retrieve the
		// objects================================
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

		try {
			PersonInfo info = service.fetchPersonDetailsById(102);
			if (info != null) {
				System.out.println(info.getPid() + " " + info.getPname() + " " + info.getDob());
				byte[] photoContent = info.getPhoto();
				OutputStream os = new FileOutputStream("retrieve photo.gif");
				os.write(photoContent);
				os.close();
               os.flush();
				System.out.println("photo retrived from db table object");
				char[] resumeContent = info.getResume();
				Writer writer = new FileWriter("retrieve resume.txt");
				writer.write(resumeContent);
				writer.close();
			//	writer.flush(); if you  close that then IOException thrown by Stream closed
				System.out.println("Resume retrieved from db table col");

			} // if
			else {
				System.out.println("record not found");
			} // else
		} // try
		catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} // catch
	}// method

}// class
