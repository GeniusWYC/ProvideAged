package com.provideaged.provideaged.controller;

import com.provideaged.provideaged.entity.ServiceObject;
import com.provideaged.provideaged.service.ServiceObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;

import java.util.List;

/**
 * @ClassName: ServiceObjectController
 * @Description: 服务对象
 * @author: 巫运辰
 * @date: 2021/08/18 20:45
 */
@RestController
@RequestMapping("/API/serviceObject")
public class ServiceObjectController {
    @Autowired
    ServiceObjectService serviceObjectService;

    @GetMapping("/queryAll")
    public List<ServiceObject> getAllData(int pageNumber,int pageSize) {
        return serviceObjectService.findAll(pageNumber,pageSize);
    }

    @GetMapping("/query")
    public ServiceObject getServiceObject(@RequestParam String id_number) {
        return serviceObjectService.queryByIdNumber(id_number);
    }

    @PostMapping("/save")
    public void saveServiceObject(@RequestBody @Valid ServiceObject serviceObject) {
        serviceObject.setTime_modify(new Timestamp(System.currentTimeMillis()));
        serviceObjectService.save(serviceObject);
    }

    @DeleteMapping("/delete")
    public void deleteServiceObject(@RequestParam String id_number) {
        serviceObjectService.deleteByIdNumber(id_number);
    }

    @PostMapping("/updateAddress")
    public void updateAddress(@RequestBody ServiceObject serviceObject) {
        serviceObjectService.updateAddress(serviceObject);
    }

    @PostMapping("/updateBaseData")
    public void updateBaseData(@RequestBody ServiceObject serviceObject) {
        serviceObject.setTime_modify(new Timestamp(System.currentTimeMillis()));
        serviceObjectService.updateBaseData(serviceObject);
    }

    @PostMapping("/updatePhoto")
    public void updatePhoto(@RequestBody ServiceObject serviceObject) {
        serviceObjectService.updatePhoto(serviceObject);
    }

    @PostMapping("/updateServiceTime")
    public void updateServiceTime(@RequestParam long id, long service_time) {
        serviceObjectService.updateServiceTime(id, service_time);
    }

    @GetMapping("/queryByObjectName")
    public List<ServiceObject> queryByObjectName(@RequestParam String object_name) {
        return serviceObjectService.queryByObjectName(object_name);
    }

    @GetMapping("/queryByDistrictName")
    public List<ServiceObject> queryByDistrictName(@RequestParam String district_name) {
        return serviceObjectService.queryByDistrictName(district_name);
    }

}