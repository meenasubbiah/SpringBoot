package com.virtusa.myapp.score;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;

	/*@Cacheable("getAllScores")*/
	@RequestMapping("/students/scores")
	public String getAllScores(Model model){
		 model.addAttribute("scores",scoreService.getAllScore());
		return "ViewAllScore";
	}
	/*@Cacheable("getSpecificStudentScores")*/
	@RequestMapping("/getScoreByStudentId")
	public String getScoreByStudentId(Model model){
		model.addAttribute("score",new Score());
		return "ViewScoreByStudentId";
	}
	@PostMapping("/getScoreByStudentIdResult")
	public String getScoreByStudentId(@ModelAttribute Score score,Model model){
		model.addAttribute("scores",scoreService.getScoreByStudentId(score.getStudent().getId()));
		return "ViewScoreByStudentIdResult";
	}
	@RequestMapping("/getScoreBySubjectName")
	public String getScoreBySubjectName(Model model){
		model.addAttribute("score",new Score());
		return "ViewScoreBySubjectName";
	}
	@PostMapping("/getScoreBySubjectNameResult")
	public String getScoreBySubjectNameResult(@ModelAttribute Score score,Model model){
		model.addAttribute("scores",scoreService.getScoreBySubjectName(score.getName()));
		return "ViewScoreBySubjectNameResult";
	}
	@RequestMapping("/getScoreByStudentIdAndSubjectName")
	public String getScoreByStudentIdAndName(Model model){
		model.addAttribute("score",new Score());
		return "ViewScoreByStudentIdAndSubjectName";
	}
	@PostMapping("/getScoreByStudentIdAndSubjectNameResult")
	public String getScoreByStudentIdAndNameResult(@ModelAttribute Score score,Model model){
		model.addAttribute("score",scoreService.findByStudentIdAndName(score.getStudent().getId(),score.getName()));
		return "ViewScoreByStudentIdAndSubjectNameResult";
	}
	/*@Cacheable("getSpecificSubjectScores")
	@RequestMapping("/students/{subjectName}/scores")
	public List<Score> getScoreBySubjectName(@PathVariable String subjectName){
		
		return scoreService.getScoreBySubjectName(subjectName);
 
	}
	@Cacheable("getSpecificStudentSubjectScores")
	@RequestMapping("/students/{studentid}/{subjectName}/scores")
	public Score findByStudentIdAndName(@PathVariable int studentid,@PathVariable String subjectName){
		
		return scoreService.findByStudentIdAndName(studentid,subjectName);
 
	}*/
	
	@GetMapping("/addScores")
	public String addScores(Model model){
		model.addAttribute("score",new Score());
		return "AddScoreByStudentId";	 
	}
	@PostMapping("/addScoreResult")
	public String addScores(@ModelAttribute Score score){
		if((score.getStudent())!=null){
			scoreService.addScores(score);
			return "AddScoreResult";
		}
		return "Error";
	}
	@PostMapping("/updateScore")
	public String updateScoresResult(@ModelAttribute Score score){
		/*model.addAttribute("scores",scoreService.findByStudentIdAndName(score.getStudent().getId(),score.getName()));
		return "ViewScoreByStudentIdAndSubjectNameResult";*/
		scoreService.updateScore(score);
		return "Index";
	}
	/*@CachePut(key="#score.id")*/
	/*@RequestMapping("/updateScore")
	public String updateScores(Model model){
		model.addAttribute("score",new Score());
		return "ViewScoreByStudentIdAndSubjectName";
	}
	@PostMapping("/updateScore")
	public String updateScoresResult(@ModelAttribute Score score,Model model){
		model.addAttribute("scores",scoreService.findByStudentIdAndName(score.getStudent().getId(),score.getName()));
		return "ViewScoreByStudentIdAndSubjectNameResult";
	}*/
	/*@CacheEvict(key="#score.id")*/
	@DeleteMapping("/student/{studentid}/scores")
	public void deleteScoreByStudentId(@PathVariable int studentid){
		scoreService.deleteScoreByStudentId(studentid);
		 
	}

}
