package CSCI5308.GroupFormationTool.QuestionsTest;

import java.util.LinkedList;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.Question;

public class QuestionDBMock implements IQuestionPersistence {

	@Override
	public boolean deleteQuestion(int questionID) {
		if (questionID == -1) {
			return true;
		}
		return false;
	}

	@Override
	public long createQuestion(Question question) {
		question.setInstructorID(1);
		question.setQuestionID(1);
		question.setQuestionTitle("Java");
		question.setQuestionText("How familiar wih java?");
		question.setQuestionDateTime("2020-06-10 00:00:00");
		return question.getQuestionID();
	}

	@Override
	public List<Question> sortByTitle(String bannerID) {
		List<Question> questionList = new LinkedList<Question>();
		Question question = new Question();
		if (bannerID == "B000000") {
			questionList.add(question);
			return questionList;
		}
		return null;
	}

	@Override
	public List<Question> sortByDate(String bannerID) {
		List<Question> questionList = new LinkedList<Question>();
		Question question = new Question();
		if (bannerID == "B000000") {
			questionList.add(question);
			return questionList;
		}
		return null;
	}

	@Override
	public List<Question> displayQuestions(String bannerID) {
		List<Question> questionList = new LinkedList<Question>();
		Question question = new Question();
		if (bannerID == "B000000") {
			questionList.add(question);
			return questionList;
		}
		return null;
	}
}