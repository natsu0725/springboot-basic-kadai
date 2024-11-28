package com.example.springkadaitodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.repository.ToDoRepository;

@Service
public class ToDoService {
	
	private final ToDoRepository toDoRepository;
	
	//コンストラクタインジェクション（DIを行う）
	public ToDoService(ToDoRepository toDoRepository) {
		this.toDoRepository = toDoRepository;
	}
	
	//ToDoリスト一括取得
	public List<ToDo> getAllToDos(){
		return toDoRepository.findAll();
	}

}
