package com.latam.isyourbirthday.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Poem {

   private String title;
   private String content;
   private String url;
   private Poet poet;
}
