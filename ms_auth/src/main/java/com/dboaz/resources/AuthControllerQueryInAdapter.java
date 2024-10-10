package com.dboaz.resources;

import com.dboaz.infra.dev.redis.RedisAccountQueryOutAdapter;
import com.dboaz.ms_auth.core.domain.Account;
import com.dboaz.ms_auth.core.dtos.QueryDto;
import com.dboaz.ms_auth.core.mappers.AccountMapper;
import com.dboaz.ms_auth.core.utils.constants.Route;
import com.dboaz.ms_auth.ports.in.AccountQueryIn;
import com.dboaz.utils.exceptions.GlobalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class AuthControllerQueryInAdapter implements AccountQueryIn {

    private static final Logger LOG = LoggerFactory.getLogger(AuthControllerQueryInAdapter.class);

    @Autowired RedisAccountQueryOutAdapter repository;

    @GetMapping(path = Route.GET_ACCOUNT_BY_ID)
    @Override
    public ResponseEntity<AccountMapper> getAccountById(QueryDto queryDto) throws GlobalException {
        return null;
    }

    @GetMapping(path = Route.GET_ACCOUNT_ALL_BY_ROLE)
    @Override
    public ResponseEntity<Set<AccountMapper>> getAccountsByRole(QueryDto queryDto) throws GlobalException {
        return null;
    }

    @Override
    public ResponseEntity<Long> getAccountCountByRole(QueryDto queryDto) throws GlobalException {
        return null;
    }

    @GetMapping(path = Route.GET_ACCOUNT_ALL_BY_STATUS)
    @Override
    public ResponseEntity<Set<AccountMapper>> getAccountsByStatus(QueryDto queryDto) throws GlobalException {
        return null;
    }

    @Override
    public ResponseEntity<Long> getAccountCountByStatus(QueryDto queryDto) throws GlobalException {
        return null;
    }

    @Override
    public ResponseEntity<AccountMapper> getAccountByKeysLoginEmail(QueryDto queryDto) throws GlobalException {
        return null;
    }

    @Override
    public ResponseEntity<AccountMapper> getAccountByLogin(QueryDto queryDto) throws GlobalException {
        return null;
    }
}
