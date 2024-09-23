package com.cntytw.datapicker.common.service.impl;

import com.cntytw.datapicker.common.service.SensitiveService;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import com.github.houbb.sensitive.word.exception.SensitiveWordException;
import org.springframework.stereotype.Service;

@Service
public class SensitiveServiceImpl implements SensitiveService {
    @Override
    public Boolean hasSensitive(String words) throws SensitiveWordException {
        return SensitiveWordHelper.contains(words);
    }
}
