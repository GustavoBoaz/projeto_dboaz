package com.dboaz.ms_auth.ports.out;

import com.dboaz.ms_auth.core.mappers.AccountMapper;
import com.dboaz.utils.exceptions.GlobalException;

/**
 * Port for account-related command operations in a hexagonal architecture.
 * <p>
 * This interface defines the contract for writing account information
 * within a hexagonal architecture. It serves as an exit point to interact with
 * account data storage or external systems for creating, updating, and deleting accounts.
 * </p>
 * <p>
 * In a hexagonal architecture, ports are used to decouple the core business logic
 * from external systems. This interface represents an outbound port (port out),
 * which is responsible for sending commands to external systems or data stores.
 * </p>
 *
 * <p>
 * Example implementation using Redis and AccountMapper:
 * </p>
 * <pre>
 * {@code
 * @Component
 * public class RedisAccountCommandOutAdapter implements AccountCommandOut {
 *
 *     private final RedisTemplate<String, Object> redisTemplate;
 *
 *     @Autowired
 *     public RedisAccountCommandOutAdapter(RedisTemplate<String, Object> redisTemplate) {
 *         this.redisTemplate = redisTemplate;
 *     }
 *
 *     @Override
 *     public void createAccount(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             redisTemplate.opsForHash().put("accounts", accountMapper.getId(), accountMapper);
 *         } catch (Exception e) {
 *             throw new GlobalException("Error creating account", e);
 *         }
 *     }
 *
 *     @Override
 *     public void updateAccountResetPassword(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             AccountMapper existingAccount = (AccountMapper) redisTemplate.opsForHash().get("accounts", accountMapper.getId());
 *             if (existingAccount != null) {
 *                 existingAccount.setPassword(accountMapper.getPassword());
 *                 redisTemplate.opsForHash().put("accounts", accountMapper.getId(), existingAccount);
 *             } else {
 *                 throw new GlobalException("Account not found");
 *             }
 *         } catch (Exception e) {
 *             throw new GlobalException("Error updating account password", e);
 *         }
 *     }
 *
 *     @Override
 *     public void deleteAccountById(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             redisTemplate.opsForHash().delete("accounts", accountMapper.getId());
 *         } catch (Exception e) {
 *             throw new GlobalException("Error deleting account", e);
 *         }
 *     }
 *
 *     @Override
 *     public void generateTokenByLogin(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             // Simulate token generation logic
 *             AccountMapper existingAccount = (AccountMapper) redisTemplate.opsForHash().get("accounts", accountMapper.getLogin());
 *             if (existingAccount != null && existingAccount.getPassword().equals(accountMapper.getPassword())) {
 *                 // Simulate token generation
 *                 String token = "generated-token-for-" + accountMapper.getLogin();
 *                 redisTemplate.opsForHash().put("tokens", accountMapper.getLogin(), token);
 *             } else {
 *                 throw new GlobalException("Invalid login or password");
 *             }
 *         } catch (Exception e) {
 *             throw new GlobalException("Error generating token", e);
 *         }
 *     }
 *
 *     @Override
 *     public void updateAccountEmail(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             AccountMapper existingAccount = (AccountMapper) redisTemplate.opsForHash().get("accounts", accountMapper.getId());
 *             if (existingAccount != null) {
 *                 existingAccount.setEmail(accountMapper.getEmail());
 *                 redisTemplate.opsForHash().put("accounts", accountMapper.getId(), existingAccount);
 *             } else {
 *                 throw new GlobalException("Account not found");
 *             }
 *         } catch (Exception e) {
 *             throw new GlobalException("Error updating account email", e);
 *         }
 *     }
 *
 *     @Override
 *     public void toggleAccountStatus(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             AccountMapper existingAccount = (AccountMapper) redisTemplate.opsForHash().get("accounts", accountMapper.getId());
 *             if (existingAccount != null) {
 *                 existingAccount.setStatus(accountMapper.getStatus());
 *                 redisTemplate.opsForHash().put("accounts", accountMapper.getId(), existingAccount);
 *             } else {
 *                 throw new GlobalException("Account not found");
 *             }
 *         } catch (Exception e) {
 *             throw new GlobalException("Error toggling account status", e);
 *         }
 *     }
 *
 *     @Override
 *     public void updateAccountRoles(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             AccountMapper existingAccount = (AccountMapper) redisTemplate.opsForHash().get("accounts", accountMapper.getId());
 *             if (existingAccount != null) {
 *                 existingAccount.setRoles(accountMapper.getRoles());
 *                 redisTemplate.opsForHash().put("accounts", accountMapper.getId(), existingAccount);
 *             } else {
 *                 throw new GlobalException("Account not found");
 *             }
 *         } catch (Exception e) {
 *             throw new GlobalException("Error updating account roles", e);
 *         }
 *     }
 *
 *     @Override
 *     public void updateAccountLogin(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             AccountMapper existingAccount = (AccountMapper) redisTemplate.opsForHash().get("accounts", accountMapper.getId());
 *             if (existingAccount != null) {
 *                 existingAccount.setLogin(accountMapper.getLogin());
 *                 redisTemplate.opsForHash().put("accounts", accountMapper.getId(), existingAccount);
 *             } else {
 *                 throw new GlobalException("Account not found");
 *             }
 *         } catch (Exception e) {
 *             throw new GlobalException("Error updating account login", e);
 *         }
 *     }
 * }
 * }
 * </pre>
 *
 * @see com.dboaz.ms_auth.core.mappers.AccountMapper
 * @see com.dboaz.utils.exceptions.GlobalException
 *
 * @since 1.0
 */
public interface AccountCommandOut {

    /**
     * Creates a new account based on the provided {@code AccountMapper}.
     *
     * @param mapper the data transfer object containing the details of the account to create
     * @throws GlobalException if an error occurs during the operation
     */
    void createAccount(AccountMapper mapper) throws GlobalException;

    /**
     * Updates the login of an existing account based on the provided {@code AccountMapper}.
     *
     * @param mapper the data transfer object containing the details of the account to update
     * @throws GlobalException if an error occurs during the operation
     */
    void updateAccountLogin(AccountMapper mapper) throws GlobalException;

    /**
     * Updates an existing account's password based on the provided {@code AccountMapper}.
     *
     * @param mapper the data transfer object containing the details of the account to update
     * @throws GlobalException if an error occurs during the operation
     */
    void updateAccountPassword(AccountMapper mapper) throws GlobalException;

    /**
     * Updates the email of an existing account based on the provided {@code AccountMapper}.
     *
     * @param mapper the data transfer object containing the details of the account to update
     * @throws GlobalException if an error occurs during the operation
     */
    void updateAccountEmail(AccountMapper mapper) throws GlobalException;

    /**
     * Toggles the status of an existing account based on the provided {@code AccountMapper}.
     *
     * @param mapper the data transfer object containing the details of the account to update
     * @throws GlobalException if an error occurs during the operation
     */
    void updateAccountStatus(AccountMapper mapper) throws GlobalException;

    /**
     * Updates the roles of an existing account based on the provided {@code AccountMapper}.
     *
     * @param mapper the data transfer object containing the details of the account to update
     * @throws GlobalException if an error occurs during the operation
     */
    void updateAccountRoles(AccountMapper mapper) throws GlobalException;

    /**
     * Deletes an existing account based on the provided {@code AccountMapper}.
     *
     * @param mapper the data transfer object containing the details of the account to delete
     * @throws GlobalException if an error occurs during the operation
     */
    void deleteAccountById(AccountMapper mapper) throws GlobalException;

}
