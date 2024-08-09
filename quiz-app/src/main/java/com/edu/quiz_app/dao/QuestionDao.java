package com.edu.quiz_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.quiz_app.service.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
	

	List<Question> findByCategory(String category);

	List<Question> findByDifficultyLevel(String difficultyLevel);
	
	@Query(value = "SELECT * FROM question q WHERE q.category = :category AND q.difficulty_level = :difficultyLevel", nativeQuery = true)
	List<Question> getQuestionByCategoryDifficultyLevel(String category, String difficultyLevel);

}
