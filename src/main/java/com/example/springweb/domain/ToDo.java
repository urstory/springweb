package com.example.springweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Objects;

@Entity(name = "ToDo")
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ToDo {
    @Id // 유일성을 보장하기 위해 @Id를 지정 - Table의 Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID가 자동생성
    private Long id;

    private String todo;

}
