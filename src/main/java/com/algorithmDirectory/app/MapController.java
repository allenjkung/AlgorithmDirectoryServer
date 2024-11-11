package com.example.springboot;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.alogrithmDirectory.algorithm.SelectionSort;
import com.alogrithmDirectory.types.SortAlgorithmRequest;

//TODO:: set initial git push
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MapController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/api")
	public Map<String, String> api() {
		Map<String, String> response = new HashMap<>();
		response.put("message", "Mission Success!!!");
		return response;
	}

	@GetMapping("/getAlgorithm/{name}")
	public Map<String, Object> getAlgorithm(@PathVariable String name) {
		try {
			Map<String, Object> response = new HashMap<>();
			Map<String, String> sourceCode = new HashMap<>();
			String[] directories = {"pseudo", "java", "python", "php"};
			int directorysLength = directories.length;

			for(int i = 0; i < directorysLength; i += 1) {
				String directoryName = directories[i];
				String filePath = "src/main/resources/static/txtFile/" + directoryName + "/" + name + ".txt";
				String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
				sourceCode.put(directoryName, content);
			}
			response.put("status", 200);
			response.put("sourceCode", sourceCode);
            return response;
        }
		catch(Exception err) {
			Map<String, Object> response = new HashMap<>();
			response.put("status", 500);
			response.put("message", "Error reading the file: " + err.getMessage());
			return response;
		}
	}

	@PostMapping("/runAlgorithm/{name}")
	public Map<String, Object> sortAlgorithm(@PathVariable String name, @RequestBody SortAlgorithmRequest request) {
		try {
			SelectionSort selectionSortObj = new SelectionSort();
			List<int[]> sortedList = selectionSortObj.SelectionSortSteps(request.getInputList());
			Map<String, Object> response = new HashMap<>();
			response.put("status", 200);
			response.put("output", sortedList);
            return response;
		}
		catch(Exception err) {
			Map<String, Object> response = new HashMap<>();
			response.put("status", 500);
			response.put("message", "Error sorting input list: " + err.getMessage());
			return response;
		}
	}
}