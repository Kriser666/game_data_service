package com.cntytw.datapicker.common.controller;

import com.cntytw.datapicker.common.vo.CustomResponseEntry;
import com.cntytw.datapicker.common.service.SensitiveService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.ZonedDateTime;

@Slf4j
@RestController
@RequestMapping("/common/api/")
public class SensitiveController {
    @Resource
    private SensitiveService sensitiveService;

    /**
     * @apiNote 查询字符串是否包含敏感词
     * @param content 字符串
     * @return 是否包含，布尔值
     * */
    @GetMapping("/hassensitive")
    public ResponseEntity<CustomResponseEntry<Boolean>> hasSensitive(@RequestParam String content) {
        log.debug("参数为：\n{}", content);
        CustomResponseEntry<Boolean> customResponseEntry
                = new CustomResponseEntry<>(200, HttpStatus.OK, "正常", ZonedDateTime.now(), true);
        try {
            Boolean hasSensitive = sensitiveService.hasSensitive(content);
            customResponseEntry.setMessage("true为包含敏感词，false为不包含敏感词");
            customResponseEntry.setData(hasSensitive);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            customResponseEntry.setCode(500);
            customResponseEntry.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            customResponseEntry.setMessage(e.getMessage());
            return new ResponseEntity<>(customResponseEntry, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(customResponseEntry, HttpStatus.OK);
    }
}
