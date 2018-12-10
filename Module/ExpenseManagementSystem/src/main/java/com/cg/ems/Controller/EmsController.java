package com.cg.ems.Controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.Bean.ProjectCodeModule;
import com.cg.ems.Service.IProjectCodeService;

@RestController
public class EmsController {

	@Autowired
	IProjectCodeService projectService;

	// Add ProjectDetails
	@PostMapping(path = "/add")
	public String addDetails(@RequestBody @Valid ProjectCodeModule pcm) {
		projectService.addDetails(pcm);
		return "Success";
	}

	// Update ProjectDetails
	@PutMapping("/update/{projectId}/{projectStartDate}")
	public String updateDetails(@PathVariable("projectId") int projectId,
			@PathVariable("projectStartDate") Date projectStartDate) {
		ProjectCodeModule pcm = projectService.getDetail(projectId);
		pcm.setProjectStartDate(projectStartDate);
		projectService.updateDetails(pcm);
		return "Successfully Updated Details";
	}

	// ReadAll ProjectDetails
	@GetMapping("/readDetails")
	public List<ProjectCodeModule> getAllDetails() {

		return projectService.getAllDetails();
	}

	// ReadByProjectId ProjectDetails
	@GetMapping(path = "/read/{projectId}")
	public ProjectCodeModule getDetail(@PathVariable int projectId) {

		ProjectCodeModule pcm = projectService.getDetail(projectId);

		return pcm;
	}

}
