package com.example.springweb.controller;

import com.example.springweb.domain.ToDo;
import com.example.springweb.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// 결과를 만들어서 view(jsp)에게 전달한다.
// http://localhost:8080/todos
@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor // final 필드만 초기화하는 생성자가 자동으로 만들어진다. Spring이 생성자 주입을 한다.
public class ToDoController {
    private final ToDoService toDoService;

    //  http://localhost:8080/todos/list
    @GetMapping("/list")
    public String list(Model model){ // Model에 값을 담으면 view(jsp)에서 사용할 수 있다.
        List<ToDo> toDoList = toDoService.getToDoList();
        model.addAttribute("todos", toDoList);
        return "list";
    }

    @PostMapping("/addToDo")
    public String addToDo(@RequestParam("todo") String todo){
        toDoService.addToDo(todo);
        return "redirect:/todos/list"; // 자동 이동.
    }
}
