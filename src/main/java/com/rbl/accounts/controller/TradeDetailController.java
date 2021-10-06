package com.rbl.accounts.controller;


import com.rbl.accounts.dto.request.trade.TradeAddReq;
import com.rbl.accounts.dto.request.trade.TradeDeleteReq;
import com.rbl.accounts.dto.request.trade.TradeInfoReq;
import com.rbl.accounts.dto.request.trade.TradeUpdateReq;
import com.rbl.accounts.dto.response.TradeOperateRes;
import com.rbl.accounts.dto.response.trade.TradeInfoRes;
import com.rbl.accounts.service.TradeService;
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
@Api(value = "TradeDetailController", tags = "交易记录接口")
@RequestMapping("/trade")
public class TradeDetailController {
    @Autowired
    TradeService tradeService;

    @ApiOperation("查询所有交易记录")
    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    @ResponseBody
    public TradeInfoRes listAll(@RequestBody @Validated TradeInfoReq tradeInfoReq) {
       return tradeService.find(tradeInfoReq);
    }

    @ApiOperation("新增交易记录")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public TradeOperateRes add(@RequestBody @Validated TradeAddReq tradeAddReq) {
        return tradeService.add(tradeAddReq);
    }

    @ApiOperation("修改交易记录")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public TradeOperateRes update(@RequestBody @Validated TradeUpdateReq tradeUpdateReq) {
        return tradeService.update(tradeUpdateReq);
    }

    @ApiOperation("删除交易记录")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public TradeOperateRes update(@RequestBody @Validated TradeDeleteReq tradeDeleteReq) {
        return tradeService.delete(tradeDeleteReq);
    }
}
