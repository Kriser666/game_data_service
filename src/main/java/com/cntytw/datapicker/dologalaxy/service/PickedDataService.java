package com.cntytw.datapicker.dologalaxy.service;

import com.cntytw.datapicker.dologalaxy.vo.GameDataTotal;

/**
 * @apiNote 数据跟踪接口
 * @author Kriser666
 */
public interface PickedDataService {
    void saveTrackData(final GameDataTotal gameDataTotal);
}
