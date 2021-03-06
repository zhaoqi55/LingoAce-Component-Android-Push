package com.pplingo.common_push.bean;

import java.util.Set;

/**
 * Created by ZhqoQi on 2021/2/24 17:17
 * E-Mail Address：550655294@qq.com
 */

/**
 * 推送相关返回值的bean
 */
public class CommonPushResultBean {


    ///别名
    public String alias;

    ///标签
    public Set<String> tags;

    ///错误码
    public int errorCode;

    ///当前操作id
    public int sequence;

    public boolean isTagCheckStateResult;

    public boolean isTagCheckOperator;

    public String mobileNumber;


    public int getErrorCode() {
        return this.errorCode;
    }

    public String getAlias() {
        return alias;
    }

    public Set<String> getTags() {
        return tags;
    }

    public int getSequence() {
        return sequence;
    }

    public boolean isTagCheckStateResult() {
        return isTagCheckStateResult;
    }

    public boolean isTagCheckOperator() {
        return isTagCheckOperator;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
