package com.bwie.manager.rpc;

import com.bawei.api.ProductRpc;
import com.bawei.api.domain.ProductRpcReq;
import com.bwie.entity.Product;
import com.bwie.manager.service.ProductService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @program:financial
 * @description: rpc服务实现类
 * @author:Mr.WeiLa
 * @create:2019-09-1109:58
 **/
@AutoJsonRpcServiceImpl
@Slf4j
public class ProductRpcImpl implements ProductRpc {

    @Autowired
    private ProductService productService;

    @Override
    public List<Product> query(ProductRpcReq req) {
        log.info("查询多个产品，请求：{}", req);
        Pageable pageable = new PageRequest(0, 1000, Sort.Direction.DESC, "rewardRate");
        Page<Product> result = productService.query(req.getIdList(), req.getMinRewardRate(), req.getMaxRewardRate(),
                req.getStatusList(), pageable);
        log.info("查询多个产品，结果：{}", result);
        return result.getContent();
    }

    @Override
    public Product findOne(String id) {


        return null;
    }
}
