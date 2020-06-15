package CSCI5308.GroupFormationTool.QuestionManagerTest;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestionManagerDB;
import CSCI5308.GroupFormationTool.QuestionManager.Question;

public class QuestionManagerDBMock implements IQuestionManagerDB {

	@Override
	public List<Question> sortByTitle(String bannerID) {
		if(bannerID.equals("B-000000")) {
			List<Question> l=new ArrayList<Question>();
			Question q=new Question();
			q.setInstructorID(1);
			q.setQuesID(1);
			q.setQuesTitle("Java");
			q.setQuesText("How familiar wih java?");
			q.setQuesDateTime("2020-06-10 00:00:00");
			l.add(q);
			return l;
		}else {
			return null;	
		}
		
	}

	@Override
	public List<Question> sortByDate(String bannerID) {
		if(bannerID.equals("B-000000")) {
			List<Question> l=new ArrayList<Question>();
			Question q=new Question();
			q.setInstructorID(1);
			q.setQuesID(1);
			q.setQuesTitle("Java");
			q.setQuesText("How familiar wih java?");
			q.setQuesDateTime("2020-06-10 00:00:00");
			l.add(q);
			return l;
		}else {
			return null;	
		}
	}

}
