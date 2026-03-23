package com.example.taskmate.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taskmate.entity.TaskSummary;
import com.example.taskmate.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<TaskSummary> findListAll() {

		List<TaskSummary> list = taskRepository.selectListAll();
		
		return list;

	}

}
