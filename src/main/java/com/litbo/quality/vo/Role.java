package com.litbo.quality.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-29 11:33
 */
@Data
public class Role {

    private String userId;

    private List<String> roleString = new ArrayList<>();
}
