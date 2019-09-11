package com.bwie.manager.controller;

import com.bwie.entity.Product;
import com.bwie.manager.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "创建产品",notes = "根据对应业务规则添加响应的产品")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {
        log.info("创建产品，参数：{}", product);
        Product result = productService.addProduct(product);
        log.info("创建产品，结果：{}", result);
        return result;
    }

    /**
     * 查询单个产品
     *
     * @param id 产品编号
     * @return 返回对应产品或Null
     */
    @ApiOperation(value = "单个商品查询", notes = "根据ip进行查询")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findOne(@PathVariable String id) {
        log.info("查询单个产品，id={}", id);
        Product result = productService.findOne(id);
        log.info("查询单个产品，结果：{}", result);
        return result;
    }

    /**
     * 分页查询产品
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Product> query(String ids, BigDecimal minRewardRate, BigDecimal maxRewardRate,
                               String status, @RequestParam(defaultValue = "0") int pageNum,
                               @RequestParam(defaultValue = "10") int pageSize) {
        log.info("查询产品，id={}，minRewardRate={}，maxRewardRate={},status={},pageNum={},pageSize={}",
                ids, minRewardRate, maxRewardRate, status, pageNum, pageSize);

        List<String> idList = null, statusList = null;
        if (!StringUtils.isEmpty(ids)) {
            idList = Arrays.asList(ids.split(","));
        }
        if (!StringUtils.isEmpty(status)) {
            statusList = Arrays.asList(status.split(","));
        }
        Pageable pageable = new PageRequest(pageNum, pageSize);
        Page<Product> page = productService.query(idList, minRewardRate, maxRewardRate, statusList, pageable);
        log.info("查询产品，结果={}", page);
        return page;
    }
}