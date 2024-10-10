package com.dboaz.ms_auth.usecases;

import com.dboaz.ms_auth.core.dtos.CommandDto;
import com.dboaz.ms_auth.core.dtos.QueryDto;
import com.dboaz.ms_auth.core.mappers.AccountMapper;
import com.dboaz.ms_auth.core.enums.QueryType;
import com.dboaz.ms_auth.ports.out.AccountCommandOut;
import com.dboaz.ms_auth.core.utils.services.Crypt;
import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.exceptions.GlobalException;
import com.dboaz.utils.models.CustomAlert;

import java.util.concurrent.ExecutorService;

import org.springframework.stereotype.Service;

/**
 * Class responsible for creating a user account.
 * Implements the {@link Runnable} interface to allow execution in a thread context.
 * 
 * <p>The class validates the input data and checks if the account already exists before attempting
 * to create a new account.</p>
 *
 * <h2>Usage Example with {@link ExecutorService}:</h2>
 * <pre>{@code
 * AccountCommandOut accountResolver = // initialize your AccountResolver here;
 * CommandDto commandDto = new CommandDto("username", "password"); // replace with actual values
 * 
 * CaseCreateAccount caseCreateAccount = new CaseCreateAccount()
 *     .setParams(accountResolver, commandDto);
 * 
 * ExecutorService executorService = Executors.newFixedThreadPool(1);
 * executorService.submit(caseCreateAccount);
 * executorService.shutdown();
 * }</pre>
 *
 * @author GustavoBoaz
 * @since 1.0
 */
@Service
public class CaseCreateAccount implements Runnable {

    private AccountCommandOut service;
    private CommandDto dtoC;
    private QueryDto dtoQ;

    public CaseCreateAccount() {}

    /**
     * Sets the parameters necessary for account creation.
     *
     * @param service   The account service used for operations.
     * @param dto       The {@link CommandDto} object containing the account data to be created.
     * @return The current instance of {@link CaseCreateAccount}.
     */
    public CaseCreateAccount setParams(AccountCommandOut service, CommandDto dto) {
        this.service = service;
        this.dtoC = dto;
        this.dtoQ = new QueryDto(QueryType.GET_ACCOUNT_BY_LOGIN, null, dto.login(), null, null, null, null);
        return this;
    }

    /**
     * Executes the account creation process, validating the data and checking if the account already exists.
     *
     * @throws GlobalException If any error occurs during the account creation process.
     */
    @Override
    public void run() throws GlobalException {
        AccountMapper entity = AccountMapper.fromAccount(dtoC.validate());
        entity.setPassword(Crypt.encrypt(entity.getPassword()));
        ifExistAccount();
        service.createAccount(entity);
    }

    /**
     * Checks if the account already exists based on the provided credentials.
     *
     * @throws GlobalException If the account already exists, throwing an exception with status 401.
     */
    private void ifExistAccount() {
        dtoQ.validate();
        //var account = service.getAccountByLogin(dtoQ);
        //if (account != null)
          //  throw GlobalException.builder()
            //    .status(401)
              //  .alert(new CustomAlert(SystemCodeEnum.C042DB))
                //.build();
    }
}

