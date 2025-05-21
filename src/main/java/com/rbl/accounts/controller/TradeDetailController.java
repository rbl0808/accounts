package com.rbl.accounts.controller;


import com.rbl.accounts.dto.request.trade.TradeAddReq;
import com.rbl.accounts.dto.request.trade.TradeDeleteReq;
import com.rbl.accounts.dto.request.trade.TradeInfoReq;
import com.rbl.accounts.dto.request.trade.TradeUpdateReq;
import com.rbl.accounts.dto.response.TradeOperateRes;
import com.rbl.accounts.dto.response.trade.TradeInfoRes;
import com.rbl.accounts.service.TradeService;
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
@Tag(description = "TradeDetailController", name = "交易记录接口")
@RequestMapping("/trade")
public class TradeDetailController {
    @Autowired
    TradeService tradeService;

    @Operation(summary = "查询所有交易记录")
    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    @ResponseBody
    public TradeInfoRes getAll(@RequestBody @Validated TradeInfoReq tradeInfoReq) {
       return tradeService.find(tradeInfoReq);
    }

    @Operation(summary = "新增交易记录")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public TradeOperateRes add(@RequestBody @Validated TradeAddReq tradeAddReq) {
        return tradeService.add(tradeAddReq);
    }

    @Operation(summary = "修改交易记录")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public TradeOperateRes update(@RequestBody @Validated TradeUpdateReq tradeUpdateReq) {
        return tradeService.update(tradeUpdateReq);
    }

    @Operation(summary = "删除交易记录")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public TradeOperateRes delete(@RequestBody @Validated TradeDeleteReq tradeDeleteReq) {
        return tradeService.delete(tradeDeleteReq);
    }
}
