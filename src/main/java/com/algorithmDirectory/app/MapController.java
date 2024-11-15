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
import java.util.ArrayList;

import com.alogrithmDirectory.algorithm.SelectionSort;
import com.alogrithmDirectory.algorithm.BubbleSort;
import com.alogrithmDirectory.algorithm.InsertionSort;
import com.alogrithmDirectory.types.SortAlgorithmRequest;

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
			int statusCode = 200;
			List<int[]> sortedList = new ArrayList<int[]>();
			switch(name) {
				case "SelectionSort":
					SelectionSort selectionSortObj = new SelectionSort();
					sortedList = selectionSortObj.SelectionSortSteps(request.getInputList());
					break;
				case "BubbleSort":
					BubbleSort bubbleSortObj = new BubbleSort();
					sortedList = bubbleSortObj.BubbleSortSteps(request.getInputList());
					break;
				case "InsertionSort":
					InsertionSort insertionSortObj = new InsertionSort();
					sortedList = insertionSortObj.InsertionSortSteps(request.getInputList());
					break;
				default:
					statusCode = 500;
			}

			Map<String, Object> response = new HashMap<>();
			response.put("status", statusCode);
			if(statusCode == 200) {
				response.put("output", sortedList);
			}
			else {
				response.put("message", "Error Invalid Sorting Method.");
			}
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