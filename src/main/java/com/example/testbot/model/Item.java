package com.example.testbot.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Item {
    Long id;
    String title;
    String description;
    List<String> ingredients;

}
