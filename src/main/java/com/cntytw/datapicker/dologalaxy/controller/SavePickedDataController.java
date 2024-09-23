package com.cntytw.datapicker.dologalaxy.controller;

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
    public ResponseEntity<String> trackEvent(@RequestBody GameDataTotal gameDataTotal) {
        log.debug("参数为：\n{}", gameDataTotal.toString());
        try {
            pickedDataService.saveTrackData(gameDataTotal);
        }
        catch (Exception e) {
            return new ResponseEntity<>("数据保存失败，请联系管理员：" + e.getClass().getName(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("数据保存成功", HttpStatus.OK);
    }
}
