package com.dboaz.infra.dev.redis;

import com.dboaz.ms_auth.core.mappers.AccountMapper;
import com.dboaz.ms_auth.ports.out.AccountCommandOut;
import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.models.CustomAlert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.dboaz.utils.exceptions.GlobalException;

@Repository
public class RedisAccountCommandOutAdapter implements AccountCommandOut {
    
    private static final String ACCOUNT_KEY = "MS:AUTH:ACCOUNT";

    private final RedisTemplate<String, AccountMapper> redisTemplate;

    @Autowired
    public RedisAccountCommandOutAdapter(RedisTemplate<String, AccountMapper> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void createAccount(AccountMapper mapper) throws GlobalException {
        try {
            redisTemplate.opsForHash().put(ACCOUNT_KEY, mapper.getId(), mapper);
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'createAccount': " + e.getMessage())
                .build();
        }
    }

    @Override
    public void updateAccountLogin(AccountMapper mapper) throws GlobalException {
        try {
            redisTemplate.opsForHash().put(ACCOUNT_KEY, mapper.getId(), mapper);
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'updateAccountLogin': " + e.getMessage())
                .build();
        }
    }

    @Override
    public void updateAccountEmail(AccountMapper mapper) throws GlobalException {
        try {
            redisTemplate.opsForHash().put(ACCOUNT_KEY, mapper.getId(), mapper);
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'updateAccountEmail': " + e.getMessage())
                .build();
        }
    }

    @Override
    public void updateAccountPassword(AccountMapper mapper) throws GlobalException {
        try {
            redisTemplate.opsForHash().put(ACCOUNT_KEY, mapper.getId(), mapper);
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'updateAccountPassword': " + e.getMessage())
                .build();
        }
    }

    @Override
    public void updateAccountStatus(AccountMapper mapper) throws GlobalException {
        try {
            redisTemplate.opsForHash().put(ACCOUNT_KEY, mapper.getId(), mapper);
        } catch (GlobalException e) {
            throw e;
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'updateAccountStatus': " + e.getMessage())
                .build();
        }
    }

    @Override
    public void updateAccountRoles(AccountMapper mapper) throws GlobalException {
        try {
            redisTemplate.opsForHash().put(ACCOUNT_KEY, mapper.getId(), mapper);
        } catch (GlobalException e) {
            throw e;
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'updateAccountRoles': " + e.getMessage())
                .build();
        }
    }

    @Override
    public void deleteAccountById(AccountMapper mapper) throws GlobalException {
        try {
            redisTemplate.opsForHash().delete(ACCOUNT_KEY, mapper.getId());
        } catch (GlobalException e) {
            throw e;
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'deleteAccountById': " + e.getMessage())
                .build();
        }
    }
}
