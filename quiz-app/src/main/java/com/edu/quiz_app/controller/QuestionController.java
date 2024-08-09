package com.edu.quiz_app.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.edu.quiz_app.service.Question;
import com.edu.quiz_app.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestion")
	public List<Question> getAllQuestion() {
		return questionService.getAllQuestion();
	}
	
	@GetMapping("categorys/{category}")
	public List<Question> getQuestionByCategory(@PathVariable String category) {
		
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("new")
	public Question addQuestion(@RequestBody Question question) {
		
		return questionService.addQuestion(question);
	}
	@GetMapping("{id}")
	public Question getByQuestioId(@PathVariable Integer id) {
		 
		return questionService.getByQuestioId(id);
	}
	@GetMapping("level/{difficultyLevel}")
	public List<Question> getByDifficultyLevel(@PathVariable String difficultyLevel,@RequestParam String category) {
     if(!(category == null)){
    	 return questionService.getQuestionByCategoryDifficultyLevel(category,difficultyLevel);
    	 
     }		
		return questionService.getByDifficultyLevel(difficultyLevel);
	}
}
