package com.edu.quiz_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.quiz_app.dao.QuestionDao;

import jakarta.persistence.EntityNotFoundException;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public List<Question> getAllQuestion(){
		return questionDao.findAll();
	}
	public List<Question> getQuestionByCategory(String category){
		
		return questionDao.findByCategory(category);
	}
	public Question addQuestion(Question question) {
		return questionDao.save(question);
	}
	public Question getByQuestioId(Integer id) {
		
        return questionDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));
	}
	public List<Question> getByDifficultyLevel(String difficultyLevel) {
		return questionDao.findByDifficultyLevel(difficultyLevel);
	}
	public List<Question> getQuestionByCategoryDifficultyLevel(String category, String difficultyLevel) {
		
		return questionDao.getQuestionByCategoryDifficultyLevel(category,difficultyLevel);
	}
}
