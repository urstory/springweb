package com.example.springweb.repository;

import com.example.springweb.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository  extends JpaRepository<ToDo, Long> {
}
