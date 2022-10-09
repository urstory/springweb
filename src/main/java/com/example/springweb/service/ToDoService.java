package com.example.springweb.service;

import com.example.springweb.domain.ToDo;
import com.example.springweb.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // final 붙은 필드만 초기화하는 생성자가 자동으로 만들어진다.
public class ToDoService {
    private final ToDoRepository toDoRepository; // 생성자에서 초기화

    @Transactional(readOnly = true) // 해당 메소드에서는 조회만 한다.
    public List<ToDo> getToDoList() {
        return toDoRepository.findAll();
    }

    @Transactional // 트랜잭션 단위로 동작한다.
    public void addToDo(String todo){
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
    }

    @Transactional
    public void deleteToDoById(Long id) {
        toDoRepository.deleteById(id);
    }
    
    @Transactional
    public void updateToDo(ToDo todo){
        ToDo oldToDo = toDoRepository.findById(todo.getId()).orElseThrow();
        System.out.println(oldToDo.getClass().getName());
        oldToDo.setTodo(todo.getTodo());
//        toDoRepository.save(oldToDo);
    }
}
