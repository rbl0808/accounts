package com.rbl.accounts.controller;


import com.rbl.accounts.dto.request.calculate.CalculateReq;
import com.rbl.accounts.service.PreferentialCalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Tag(description = "CalculateController", name = "计算比例工具")
@RequestMapping("/cal")
public class CalculateController {
    @Autowired
    PreferentialCalService calService;
    @Operation(summary = "计算比例")
    @RequestMapping(value = "/dnf", method = RequestMethod.POST)
    @ResponseBody
    public String calDnf(@RequestBody @Validated CalculateReq calculateReq) {
       return calService.calculate(calculateReq);
    }

}
