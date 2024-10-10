package com.dboaz.resources;

import com.dboaz.ms_auth.core.domain.Token;
import com.dboaz.ms_auth.core.dtos.CommandDto;
import com.dboaz.ms_auth.core.utils.constants.Route;
import com.dboaz.ms_auth.ports.in.AccountCommandIn;
import com.dboaz.utils.exceptions.GlobalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dboaz.infra.dev.redis.RedisAccountCommandOutAdapter;

@RestController
public class AuthControllerCommandInAdapter implements AccountCommandIn {

    private static final Logger LOG = LoggerFactory.getLogger(AuthControllerCommandInAdapter.class);

    @Autowired RedisAccountCommandOutAdapter repository;

    @PostMapping(path = Route.POST_ACCOUNT_NEW)
    @Override
    public ResponseEntity<Void> createAccount(CommandDto commandDto) throws GlobalException {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateAccountLogin(CommandDto commandDto) throws GlobalException {
        return null;
    }

    @PutMapping(path = Route.PUT_ACCOUNT_RESET_PASSWORD)
    @Override
    public ResponseEntity<Void> resetAccountPassword(CommandDto commandDto) throws GlobalException {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateAccountEmail(CommandDto commandDto) throws GlobalException {
        return null;
    }

    @PutMapping(path = Route.PUT_ACCOUNT_TOGGLE_STATUS)
    @Override
    public ResponseEntity<Void> toggleAccountStatus(CommandDto commandDto) throws GlobalException {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateAccountRoles(CommandDto commandDto) throws GlobalException {
        return null;
    }

    @DeleteMapping(path = Route.DELETE_ACCOUNT_BY_ID)
    @Override
    public ResponseEntity<Void> deleteAccountById(CommandDto commandDto) throws GlobalException {
        return null;
    }

    @PostMapping(path = Route.POST_ACCOUNT_TOKEN_BY_LOGIN)
    @Override
    public ResponseEntity<Token> generateTokenByLogin(CommandDto commandDto) throws GlobalException {
        return null;
    }
}
