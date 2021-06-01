package com.gfg.jbdl14restfulapi.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieRequest {

    private String name;
    private String genre;
    private String language;

}
