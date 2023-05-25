package com.rbl.accounts.controller;


import com.rbl.accounts.dto.request.calculate.CalculateReq;
import com.rbl.accounts.service.PreferentialCalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Api(value = "CalculateController", tags = "计算比例工具")
@RequestMapping("/cal")
public class CalculateController {
    @Autowired
    PreferentialCalService calService;
    @ApiOperation("计算比例")
    @RequestMapping(value = "/dnf", method = RequestMethod.POST)
    @ResponseBody
    public String calDnf(@RequestBody @Validated CalculateReq calculateReq) {
       return calService.calculate(calculateReq);
    }

}
