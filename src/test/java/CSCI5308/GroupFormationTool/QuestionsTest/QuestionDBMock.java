package CSCI5308.GroupFormationTool.QuestionsTest;

import java.util.LinkedList;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
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
	public long createQuestion(IQuestion question) {
		question.setInstructorID(1);
		question.setQuestionID(1);
		question.setQuestionTitle("Java");
		question.setQuestionText("How familiar wih java?");
		question.setQuestionDateTime("2020-06-10 00:00:00");
		return question.getQuestionID();
	}

	@Override
	public List<IQuestion> sortByTitle(String bannerID) {
		List<IQuestion> questionList = new LinkedList<>();
		IQuestion question = QuestionsSystemConfigTest.instance().getQuestion();
		if (bannerID == "B000000") {
			questionList.add(question);
			return questionList;
		}
		return null;
	}

	@Override
	public List<IQuestion> sortByDate(String bannerID) {
		List<IQuestion> questionList = new LinkedList<>();
		Question question = QuestionsSystemConfigTest.instance().getQuestion();
		if (bannerID == "B000000") {
			questionList.add(question);
			return questionList;
		}
		return null;
	}

	@Override
	public List<IQuestion> displayQuestions(String bannerID) {
		List<IQuestion> questionList = new LinkedList<>();
		Question question = QuestionsSystemConfigTest.instance().getQuestion();
		if (bannerID == "B000000") {
			questionList.add(question);
			return questionList;
		}
		return null;
	}

	@Override
	public void loadQuestionByID(IQuestion question, long questionID) {
		// TODO Auto-generated method stub

	}
}