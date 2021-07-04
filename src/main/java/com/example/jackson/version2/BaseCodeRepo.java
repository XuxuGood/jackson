package com.example.jackson.version2;

import com.example.jackson.common.RepoType;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;

/**
 * @author xiaoxuxuy
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
public class BaseCodeRepo {

    private Long id;

    private RepoType type;

}

