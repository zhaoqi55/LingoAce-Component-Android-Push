package com.pplingo.common_push.callback;

import com.pplingo.common_push.bean.CommonPushResultBean;

/**
 * Created by ZhqoQi on 2021/2/24 17:08
 * E-Mail Address：550655294@qq.com
 */

public interface CommPushCallBack {


    /**
     * 标签检查结果
     * @param commonBean
     */
    void onTagCheckResult(CommonPushResultBean commonBean);

    /**
     * 标签操作结果
     * @param commonBean
     */
    void onTagOperateResult(CommonPushResultBean commonBean);

    /**
     * 别名操作结果
     * @param commonBean
     */
    void onAliasOperatorResult(CommonPushResultBean commonBean);

}
