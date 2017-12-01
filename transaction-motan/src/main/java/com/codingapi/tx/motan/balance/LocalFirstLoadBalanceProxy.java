package com.codingapi.tx.motan.balance;

import com.weibo.api.motan.cluster.loadbalance.LocalFirstLoadBalance;
import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.core.extension.Activation;
import com.weibo.api.motan.core.extension.SpiMeta;
import com.weibo.api.motan.rpc.Referer;
import com.weibo.api.motan.rpc.Request;

/**
 * <p>"本地服务优先" 负载均衡代理</p>
 *
 * @author 张峰 zfvip_it@163.com
 * 2017/12/1 10:46
 */
@SpiMeta(name = "localFirstLcn")
@Activation(key = {MotanConstants.NODE_TYPE_SERVICE, MotanConstants.NODE_TYPE_REFERER})
public class LocalFirstLoadBalanceProxy extends LocalFirstLoadBalance {

    private LCNBalanceProxy lcnBalanceProxy = new LCNBalanceProxy();

    @Override
    protected Referer doSelect(Request request) {
        return lcnBalanceProxy.proxy(super.doSelect(request));
    }
}
