package com.personal.system.events;

import com.personal.system.models.SystemUser;
import com.personal.system.utils.AesEncrypter;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.transaction.Transactional;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class AesEntityListener {
    @Autowired
    private AesEncrypter aesEncrypter;

    @PrePersist
    public void encryptData(Object entity) {
        if (entity instanceof SystemUser) {
            SystemUser user = (SystemUser) entity;
//            user.setData(aesEncrypter.encrypt(user.getData()));
        }
    }
}