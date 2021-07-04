package com.example.jackson.version2;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author xiaoxuxuy
 */
@Data
@JsonTypeName(value = "GITHUB")
@EqualsAndHashCode(callSuper = true)
public class GithubRepo extends BaseCodeRepo {

    private String name;

    private String path;

    private String description;

}
