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
import com.alogrithmDirectory.algorithm.IterativeMergeSort;
import com.alogrithmDirectory.algorithm.IterativeQuicksort;
import com.alogrithmDirectory.algorithm.IterativeHeapsort;
import com.alogrithmDirectory.algorithm.CountingSort;
import com.alogrithmDirectory.algorithm.RadixSort;
import com.alogrithmDirectory.algorithm.BucketSort;
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
			String[] subNames = {"Iterative", "Recursive"};
			int directorysLength = directories.length;
			int subNamesLength = subNames.length;

			if(name.equals("MergeSort") || name.equals("Quicksort") || name.equals("Heapsort")) {
				for(int i = 0; i < directorysLength; i += 1) {
					String directoryName = directories[i];
					for(int j = 0; j < subNamesLength; j += 1) {
						String subName = subNames[j];
						String filePath = "src/main/resources/static/txtFile/" + directoryName + "/" + subName + name + ".txt";
						String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
						sourceCode.put((directoryName + subName), content);
					}
				}
				response.put("multiSourceCode", sourceCode);
			}
			else {
				for(int i = 0; i < directorysLength; i += 1) {
					String directoryName = directories[i];
					String filePath = "src/main/resources/static/txtFile/" + directoryName + "/" + name + ".txt";
					String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
					sourceCode.put(directoryName, content);
				}
				response.put("sourceCode", sourceCode);
			}
			response.put("status", 200);
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
				case "MergeSort":
					IterativeMergeSort mergeSortObj = new IterativeMergeSort();
					sortedList = mergeSortObj.IterativeMergeSortSteps(request.getInputList());
					break;
				case "Quicksort":
					IterativeQuicksort quicksortObj = new IterativeQuicksort();
					sortedList = quicksortObj.IterativeQuicksortSteps(request.getInputList());
					break;
				case "Heapsort":
					IterativeHeapsort heapsortObj = new IterativeHeapsort();
					sortedList = heapsortObj.IterativeHeapsortSteps(request.getInputList());
					break;
				case "CountingSort":
					CountingSort countingSortObj = new CountingSort();
					sortedList = countingSortObj.CountingSortSteps(request.getInputList());
					break;
				case "RadixSort":
					RadixSort radixSortObj = new RadixSort();
					sortedList = radixSortObj.RadixSortSteps(request.getInputList());
					break;
				case "BucketSort":
					BucketSort bucketSortObj = new BucketSort();
					sortedList = bucketSortObj.BucketSortSteps(request.getInputList());
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