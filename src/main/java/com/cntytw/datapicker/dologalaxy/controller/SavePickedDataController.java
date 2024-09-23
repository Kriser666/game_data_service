package com.cntytw.datapicker.dologalaxy.controller;

import com.cntytw.datapicker.common.vo.CustomResponseEntry;
import com.cntytw.datapicker.dologalaxy.service.PickedDataService;
import com.cntytw.datapicker.dologalaxy.vo.GameDataTotal;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

/**
 * @apiNote 嘟噜一笔银河数据保存控制层交互
 * @author Kriser666
 * */
@Slf4j
@RestController
@RequestMapping("/dolodatapicker/api/")
public class SavePickedDataController {

    @Resource
    private PickedDataService pickedDataService;

    @PostMapping("/saveorupdate")
    public ResponseEntity<CustomResponseEntry<String>>
    trackEvent(@RequestBody GameDataTotal gameDataTotal) {
        log.debug("参数为：\n{}", gameDataTotal.toString());
        CustomResponseEntry<String> customResponseEntry =
                new CustomResponseEntry<>(200, HttpStatus.OK, "正常", ZonedDateTime.now(), null);
        try {
            pickedDataService.saveTrackData(gameDataTotal);
            customResponseEntry.setMessage("操作成功");
            customResponseEntry.setData("操作成功");
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
