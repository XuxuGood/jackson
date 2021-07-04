package com.example.jackson.version1;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiaoxuxuy
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GithubRepo extends BaseCodeRepo {

    private String name;

    private String path;

    private String description;

}
