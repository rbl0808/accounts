package com.rbl.accounts.service;

import com.rbl.accounts.dto.request.calculate.CalculateReq;

/**
 * @author : rbl
 * @date : 2023/5/25
 */
public interface PreferentialCalService {
    String calculate(CalculateReq calculateReq);
}
