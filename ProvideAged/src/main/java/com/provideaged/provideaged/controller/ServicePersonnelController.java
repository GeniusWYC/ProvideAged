package com.provideaged.provideaged.controller;

import com.provideaged.provideaged.entity.ServicePersonnel;
import com.provideaged.provideaged.service.ServicePersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName: ServicePersonnelController
 * @Description: 服务人员
 * @author: 巫运辰
 * @date: 2021/08/19 17:18
 */
@RestController
@RequestMapping("/API/servicePersonnel")
public class ServicePersonnelController {
    @Autowired
    ServicePersonnelService servicePersonnelService;
    @GetMapping("/queryAll")
    public List<ServicePersonnel> getAllData(int pageNumber,int pageSize) {
        return servicePersonnelService.findAll(pageNumber,pageSize);
    }

    @GetMapping("/query")
    public ServicePersonnel getServicePersonnel(@RequestParam String username) {
        return servicePersonnelService.queryByUsername(username);
    }

    @PostMapping("/save")
    public void saveServicePersonnel(@RequestBody @Valid ServicePersonnel servicePersonnel){
        servicePersonnel.setTime_modify(new Timestamp(System.currentTimeMillis()));
        servicePersonnelService.save(servicePersonnel);
    }

    @DeleteMapping("/delete")
    public void deleteServicePersonnel(@RequestParam String username){
        servicePersonnelService.deleteByUsername(username);
    }

    @PostMapping("/updateBaseData")
    public void updateBaseData(@RequestBody ServicePersonnel servicePersonnel){
        servicePersonnel.setTime_modify(new Timestamp(System.currentTimeMillis()));
        servicePersonnelService.updateBaseData(servicePersonnel);
    }

    @PostMapping("/updateServiceTime")
    public void updateServiceTime(@RequestBody ServicePersonnel servicePersonnel){
        servicePersonnelService.updateServiceTime(servicePersonnel);
    }

    @PostMapping("/updateServiceTimes")
    public void updateServiceTimes(@RequestBody ServicePersonnel servicePersonnel){
        servicePersonnelService.updateServiceTimes(servicePersonnel);
    }

    @PostMapping("/updatePhoto")
    public void updatePhoto(@RequestBody ServicePersonnel servicePersonnel){
        servicePersonnelService.updatePhoto(servicePersonnel);
    }

}