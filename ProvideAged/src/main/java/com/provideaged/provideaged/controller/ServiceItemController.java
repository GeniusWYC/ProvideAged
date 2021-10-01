package com.provideaged.provideaged.controller;

import com.provideaged.provideaged.entity.ServiceItem;
import com.provideaged.provideaged.service.ServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName: ServiceItemController
 * @Description: 服务项目
 * @author: 巫运辰
 * @date: 2021/08/19 19:27
 */
@RestController
@RequestMapping("/API/serviceItem")
public class ServiceItemController {
    @Autowired
    ServiceItemService serviceItemService;

    @GetMapping("/findByYear")
    public List<ServiceItem> findByYear(@RequestParam int service_year, int pageNumber, int pageSize) {
        return serviceItemService.findByYear(service_year, pageNumber, pageSize);
    }

    @GetMapping("/findByMonth")
    public List<ServiceItem> findByMonth(@RequestParam int service_year, int service_month, int pageNumber, int pageSize) {
        return serviceItemService.findByMonth(service_year, service_month, pageNumber, pageSize);
    }

    @GetMapping("/findByDay")
    public List<ServiceItem> findByDay(@RequestParam int service_year, int service_month, int service_day, int pageNumber, int pageSize) {
        return serviceItemService.findByDay(service_year, service_month, service_day, pageNumber, pageSize);
    }

    @GetMapping("/findByYearAndPersonnel")
    public List<ServiceItem> findByYearAndPersonnel(@RequestParam int service_year, long service_personnel_id, int pageNumber, int pageSize) {
        return serviceItemService.findByYearAndPersonnel(service_year, service_personnel_id, pageNumber, pageSize);
    }

    @GetMapping("/findByMonthAndPersonnel")
    public List<ServiceItem> findByMonthAndPersonnel(@RequestParam int service_year, int service_month, long service_personnel_id, int pageNumber, int pageSize) {
        return serviceItemService.findByMonthAndPersonnel(service_year, service_month, service_personnel_id, pageNumber, pageSize);
    }

    @GetMapping("/findByDayAndPersonnel")
    public List<ServiceItem> findByDayAndPersonnel(@RequestParam int service_year, int service_month, int service_day, long service_personnel_id, int pageNumber, int pageSize) {
        return serviceItemService.findByDayAndPersonnel(service_year, service_month, service_day, service_personnel_id, pageNumber, pageSize);
    }

    @GetMapping("/findByServiceType")
    public List<Object[]> findByServiceType(@RequestParam long service_type_id, int pageNumber, int pageSize) {
        return serviceItemService.findByServiceType(service_type_id, pageNumber, pageSize);
    }

    @GetMapping("/findByServiceTypeAndPersonnelId")
    List<Object[]> findByServiceTypeAndPersonnelId(@RequestParam long service_type_id, long service_personnel_id, int pageNumber, int pageSize) {
        return serviceItemService.findByServiceTypeAndPersonnelId(service_type_id, service_personnel_id, pageNumber, pageSize);
    }

    @GetMapping("/findByState")
    List<ServiceItem> findByState(@RequestParam String service_state, int pageNumber, int pageSize) {
        return serviceItemService.findByState(service_state, pageNumber, pageSize);
    }

    @GetMapping("/findByStateAndPersonnelId")
    List<Object[]> findByStateAndPersonnelId(@RequestParam String service_state, long service_personnel_id, int pageNumber, int pageSize) {
        return serviceItemService.findByStateAndPersonnelId(service_state, service_personnel_id, pageNumber, pageSize);
    }

    @PostMapping("/updateIntervalLength")
    void updateIntervalLength(@RequestParam long id, long interval_length) {
        serviceItemService.updateIntervalLength(id, interval_length);
    }

    @PostMapping("/updateStartTime")
    void updateStartTime(@RequestParam long id, String start_address) {
        serviceItemService.updateStartService(id, start_address);
    }

    @PostMapping("/updateStopTime")
    void updateStopTime(@RequestParam long id, String stop_address) {
        serviceItemService.updateStopService(id, stop_address);
    }

    @PostMapping("/updateServiceState")
    void updateServiceState(@RequestParam long id, String service_state) {
        serviceItemService.updateServiceState(id, service_state);
    }

    @PostMapping("/save")
    void save(@RequestBody ServiceItem serviceItem) {
        serviceItemService.save(serviceItem);
    }
}