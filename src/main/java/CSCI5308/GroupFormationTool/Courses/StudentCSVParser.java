package CSCI5308.GroupFormationTool.Courses;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import CSCI5308.GroupFormationTool.AccessControl.IUser;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;

public class StudentCSVParser implements IStudentCSVParser {
	private MultipartFile uploadedFile;
	private List<IUser> studentList = new ArrayList<>();
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public StudentCSVParser(MultipartFile file) {
		this.uploadedFile = file;

	}

	@Override
	public List<IUser> parseCSVFile(List<String> failureResults) {
		try {
			Reader reader = new InputStreamReader(uploadedFile.getInputStream());
			CSVReader csvReader = new CSVReaderBuilder(reader).build();
			List<String[]> records = csvReader.readAll();
			Iterator<String[]> iter = records.iterator();
			while (iter.hasNext()) {
				String[] record = iter.next();
				String bannerID = record[0];
				String firstName = record[1];
				String lastName = record[2];
				String email = record[3];

				IUser u = UserAbstractFactory.instance().makeUser();
				u.setBannerID(bannerID);
				u.setFirstName(firstName);
				u.setLastName(lastName);
				u.setEmail(email);
				studentList.add(u);
			}
		} catch (IOException e) {
			logger.error("IOException while reading csv file: "+e.getMessage());
			failureResults.add("Failure reading uploaded file: " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while parsing the csv file: "+e.getMessage());
			failureResults.add("Failure parsing CSV file: " + e.getMessage());
		}
		logger.debug("Parsed csv file with first student as "+studentList.get(0).getBannerID());
		return studentList;
	}
}
