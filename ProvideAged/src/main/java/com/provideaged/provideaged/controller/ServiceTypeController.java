package com.provideaged.provideaged.controller;

import com.provideaged.provideaged.entity.ServiceType;
import com.provideaged.provideaged.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName: ServiceTypeController
 * @Description: 服务类型
 * @author: 巫运辰
 * @date: 2021/09/22 14:17
 */
@RestController
@RequestMapping("API/ServiceType")
public class ServiceTypeController {
    @Autowired
    ServiceTypeService serviceTypeService;

    @PostMapping("/createType")
    public void createType(@RequestBody @Valid ServiceType serviceType){
        serviceTypeService.createServiceType(serviceType);
    }

    @GetMapping("/queryAllType")
    public List<ServiceType> queryAllType(int pageNumber,int pageSize){
        return serviceTypeService.queryAll(pageNumber,pageSize);
    }
}