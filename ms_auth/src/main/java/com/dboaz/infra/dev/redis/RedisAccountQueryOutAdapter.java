package com.dboaz.infra.dev.redis;

import com.dboaz.ms_auth.core.mappers.AccountMapper;
import com.dboaz.ms_auth.ports.out.AccountQueryOut;
import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.exceptions.GlobalException;
import com.dboaz.utils.models.CustomAlert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RedisAccountQueryOutAdapter implements AccountQueryOut {

    private static final String ACCOUNT_KEY = "MS:AUTH:ACCOUNT";

    private final RedisTemplate<String, AccountMapper> redisTemplate;

    @Autowired
    public RedisAccountQueryOutAdapter(RedisTemplate<String, AccountMapper> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public AccountMapper getAccountById(AccountMapper mapper) throws GlobalException {
        try {
            return (AccountMapper) redisTemplate.opsForHash().get(ACCOUNT_KEY, mapper.getId());
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'getAccountById': " + e.getMessage())
                .build();
        }
    }

    @Override
    public Set<AccountMapper> getAccountsByRole(AccountMapper mapper) throws GlobalException {
        try {
            return redisTemplate.opsForHash().values(ACCOUNT_KEY)
                .stream()
                .filter(acc -> ((AccountMapper) acc).getRoles().containsAll(mapper.getRoles()))
                .map(account -> (AccountMapper) account)
                .collect(Collectors.toSet());
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'getAccountsByRole': " + e.getMessage())
                .build();
        }
    }

    @Override
    public long getAccountCountByRole(AccountMapper mapper) throws GlobalException {
        try {
            return redisTemplate.opsForHash().values(ACCOUNT_KEY)
                .stream()
                .filter(acc -> ((AccountMapper) acc).getRoles().containsAll(mapper.getRoles()))
                .count();
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'getAccountCountByRole': " + e.getMessage())
                .build();
        }
    }

    @Override
    public Set<AccountMapper> getAccountsByStatus(AccountMapper mapper) throws GlobalException {
        try {
            return redisTemplate.opsForHash().values(ACCOUNT_KEY)
                .stream()
                .filter(acc -> ((AccountMapper) acc).getStatus().equals(mapper.getStatus()))
                .map(account -> (AccountMapper) account)
                .collect(Collectors.toSet());
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'getAccountsByStatus': " + e.getMessage())
                .build();
        }
    }

    @Override
    public long getAccountCountByStatus(AccountMapper mapper) throws GlobalException {
        try {
            return redisTemplate.opsForHash().values(ACCOUNT_KEY)
                .stream()
                .filter(acc -> ((AccountMapper) acc).getStatus().equals(mapper.getStatus()))
                .count();
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'getAccountCountByStatus': " + e.getMessage())
                .build();
        }
    }

    @Override
    public AccountMapper getAccountByKeysLoginEmail(AccountMapper mapper) throws GlobalException {
        try {
            return (AccountMapper) redisTemplate.opsForHash().values(ACCOUNT_KEY)
                .stream()
                .filter(acc ->
                    ((AccountMapper) acc).getLogin().equals(mapper.getLogin()) &&
                    ((AccountMapper) acc).getEmail().equals(mapper.getEmail()) &&
                    ((AccountMapper) acc).getKeys().contains(mapper.getKeys().stream().findFirst().orElse(null))
                )
                .findFirst()
                .orElse(null);
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'getAccountByKeysLoginEmail': " + e.getMessage())
                .build();
        }
    }

    @Override
    public AccountMapper getAccountByLogin(AccountMapper mapper) throws GlobalException {
        try {
            return (AccountMapper) redisTemplate.opsForHash().values(ACCOUNT_KEY)
                .stream()
                .filter(acc -> ((AccountMapper) acc).getLogin().equals(mapper.getLogin()))
                .findFirst()
                .orElse(null);
        } catch (Exception e) {
            throw GlobalException.builder()
                .status(500)
                .alert(new CustomAlert(SystemCodeEnum.C001DB))
                .details("Error Redis in 'getAccountByLogin': " + e.getMessage())
                .build();
        }
    }
}
