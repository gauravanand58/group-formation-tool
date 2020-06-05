package com.advsdc.group4.CourseAdminPage.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.advsdc.group4.CourseAdminPage.dao.EnrollStudentDao;
import com.advsdc.group4.CourseAdminPage.dao.EnrollStudentDaoImpl;
import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.User;
import com.advsdc.group4.util.PasswordEncoder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public class EnrollStudentServiceImpl implements EnrollStudentService{

	EnrollStudentDao enrollstudentdao;
	EmailService emailservice;
	IUser user;
	public EnrollStudentServiceImpl() {
		enrollstudentdao=new EnrollStudentDaoImpl();
		emailservice=new EmailServiceImpl();
		user= new User();
	}
	@Override
	public Boolean readCSV(MultipartFile file, int courseID) {
		Boolean successfullInsert=true; 
		List<String> existedUsers=new ArrayList<String>();
		List<String> sendMailUsersBannerID=new ArrayList<String>();
		List<String> sendMailUsersEmail=new ArrayList<String>();
		String subject="Credentials for your newly created account";
		String commonMessage="Given are the credentials to access your account:\n";
		String[] record;
        if (file.isEmpty()) {
          successfullInsert= false;
        }else {
      try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            	CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            	existedUsers=enrollstudentdao.getUser();
            	
            	
                while ((record = csvReader.readNext()) != null) {
                	if(!existedUsers.contains(record[0])) {
                		sendMailUsersBannerID.add(record[0]);		
                		sendMailUsersEmail.add(record[3]);
                	}
                	user.setBannerID(record[0]);
                	user.setFirstName(record[1]);
                	user.setLastName(record[2]);
                	user.setEmail(record[3]);
                	PasswordEncoder passwordEncoder = new PasswordEncoder();
            		user.setPassword(passwordEncoder.encode(record[0]));
                	successfullInsert=enrollstudentdao.insertStudentsInDB(user, courseID);
                    if(!successfullInsert) {
                    	break;
                    }
                    for(int counter=0;counter<sendMailUsersBannerID.size();counter++) {
                    	String tempMessage=commonMessage+"Username:"+sendMailUsersBannerID.get(counter)+"\nPassword:"+sendMailUsersBannerID.get(counter);
                    	emailservice.sendEmail(sendMailUsersEmail.get(counter), subject, tempMessage);
                    }
                  
                }
                

            } catch (Exception ex) {
            	ex.printStackTrace();
            }
        }
		return successfullInsert;
    }

}
