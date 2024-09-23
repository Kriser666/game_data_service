package com.cntytw.datapicker.common.vo;

import com.cntytw.datapicker.common.tools.FieldDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponseEntry<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -1840831686851699943L;

    @FieldDescription("响应状态码")
    @JsonProperty("code")
    private Integer code;

    @FieldDescription("响应状态")
    @JsonProperty("status")
    private HttpStatus status;

    @FieldDescription("响应消息")
    @JsonProperty("message")
    private String message;

    @FieldDescription("响应时间")
    @JsonProperty("time")
    private ZonedDateTime time;

    @FieldDescription("响应数据")
    @JsonProperty("data")
    private T data;
}
