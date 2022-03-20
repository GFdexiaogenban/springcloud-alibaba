package com.ckj.service.impl;

import com.ckj.mapper.StorageMapper;
import com.ckj.pojo.Storage;
import com.ckj.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;


    @Override
    @Transactional
    public boolean updateUseNum(long productId, int used) {
        int index = storageMapper.updateUsed(productId,used);
        return index > 0;
    }
}
