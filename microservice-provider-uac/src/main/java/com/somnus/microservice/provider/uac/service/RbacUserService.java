package com.somnus.microservice.provider.uac.service;

import com.somnus.microservice.commons.core.support.IService;
import com.somnus.microservice.provider.uac.model.domain.RbacUser;

import java.util.Optional;

/**
 * @author kevin.liu
 * @title: RbacUserService
 * @projectName SpringBoot
 * @description: TODO
 * @date 2021/11/22 15:47
 */
public interface RbacUserService extends IService<RbacUser> {

    Optional<RbacUser> getByUsername(String username);

    void save(String username, String password);
}
