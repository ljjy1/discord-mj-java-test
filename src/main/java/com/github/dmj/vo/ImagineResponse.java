package com.github.dmj.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ljjy1
 * @classname ImagineResponse
 * @description TODO
 * @date 2023/10/14 14:18
 */
@Schema(description = "文生图/图生图返回")
@Data
@Accessors(chain = true)
public class ImagineResponse implements Serializable {


    @Schema(description = "业务系统生成的唯一ID")
    private Integer triggerId;





}
