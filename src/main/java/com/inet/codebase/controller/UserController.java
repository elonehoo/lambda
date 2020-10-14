package com.inet.codebase.controller;


import com.inet.codebase.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HCY
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;


}
