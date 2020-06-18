package CSCI5308.GroupFormationTool.QuestionsTest;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestionManagerDB;
import CSCI5308.GroupFormationTool.Questions.Question;
import CSCI5308.GroupFormationTool.Questions.QuestionOptions;

public class QuestionManagerDBMock implements IQuestionManagerDB {
	

	@Override
	public List<Question> sortByTitle(String bannerID) {
		if(bannerID.equals("B-000000")) {
			List<Question> l=new ArrayList<Question>();
			Question q=new Question();
			q.setInstructorID((long) 1);
			q.setQuestionID(1);
			q.setQuestionTitle("Java");
			q.setQuestionText("How familiar wih java?");
			q.setQuestionDateTime("2020-06-10 00:00:00");
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
			q.setInstructorID((long) 1);
			q.setQuestionID(1);
			q.setQuestionTitle("Java");
			q.setQuestionText("How familiar wih java?");
			q.setQuestionDateTime("2020-06-10 00:00:00");
			l.add(q);
			return l;
		}else {
			return null;	
		}
	}

	@Override
	public List<Question> displayQuestions(String bannerID) {
		if(bannerID.equals("B-000000")) {
			List<Question> l=new ArrayList<Question>();
			Question q=new Question();
			q.setInstructorID((long) 1);
			q.setQuestionID(1);
			q.setQuestionTitle("Java");
			q.setQuestionText("How familiar wih java?");
			q.setQuestionDateTime("2020-06-10 00:00:00");
			l.add(q);
			return l;
		}else {
			return null;	
		}
	}

	@Override
	public boolean createQuestion(Question question) {
		question.setInstructorID((long) 1);
		question.setQuestionID(1);
		question.setQuestionTitle("Java");
		question.setQuestionText("How familiar wih java?");
		question.setQuestionDateTime("2020-06-10 00:00:00");
		return true;
	}

	@Override
	public boolean createOption(QuestionOptions questionOption) {
		questionOption.setOptionTxt("intermediate");
		questionOption.setOptionScore("5");
		return true;
	}
	
	

}
