package com.cos.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.test.domain.stadium.Stadium;
import com.cos.test.domain.team.Team;
import com.cos.test.service.StadiumService;
import com.cos.test.service.TeamService;
import com.cos.test.web.dto.CommonRespDto;
import com.cos.test.web.team.dto.TeamSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {

	private final TeamService teamService;
	private final StadiumService stadiumService;
	
	@GetMapping("/team/saveForm")
	public String saveForm(Model model) {
		model.addAttribute("stadiums",stadiumService.전체찾기());
		return "team/teamSaveForm";
	}
	
	@GetMapping("/team") 
	public String findAll(Model model) {
		model.addAttribute("teams",teamService.팀찾기());
		return "team/teamList";
	}
	
	@PostMapping("/saveTeam")
	public String save(TeamSaveReqDto teamSaveReqDto) {
		Team team = teamSaveReqDto.toEntity();
		Team teamEntity = teamService.팀등록(team, teamSaveReqDto.getStadiumId());
		if (teamEntity == null) {
			return "team/teamSaveForm";
		} else {
			return "redirect:/team";
		}
		
	}
	
	@DeleteMapping("/team/{id}")
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id) {
		teamService.삭제하기(id);
		return new CommonRespDto<>(1, null);
	}
}

