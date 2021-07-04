package com.example.jackson.version2;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author xiaoxuxuy
 */
@Data
@JsonTypeName(value = "GITLAB")
@EqualsAndHashCode(callSuper = true)
public class GitlabRepo extends BaseCodeRepo {

    private String name;

    private String path;

    private String description;

}
