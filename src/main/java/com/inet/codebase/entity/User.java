package com.inet.codebase.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author HCY
 * @since 2020-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户序号
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date userBirthday;

    /**
     * 用户爱好
     */
    private String userHabby;

    /**
     * 用户身份证
     */
    private String userIdentity;

    /**
     * 用户住址
     */
    private String userAddress;



}
