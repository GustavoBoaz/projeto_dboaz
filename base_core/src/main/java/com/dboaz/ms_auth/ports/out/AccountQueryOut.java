package com.dboaz.ms_auth.ports.out;

import com.dboaz.ms_auth.core.mappers.AccountMapper;
import com.dboaz.utils.exceptions.GlobalException;

import java.util.Set;

/**
 * Port for account-related query operations in a hexagonal architecture.
 * <p>
 * This interface defines the contract for reading account information
 * within a hexagonal architecture. It serves as an exit point to interact with
 * account data storage or external systems for retrieving account data.
 * </p>
 *
 * <p>
 * Example implementation using Redis and AccountMapper:
 * </p>
 * <pre>
 * {@code
 * @Component
 * public class RedisAccountQueryOutAdapter implements AccountQueryOut {
 *
 *     private final RedisTemplate<String, Object> redisTemplate;
 *
 *     @Autowired
 *     public RedisAccountQueryOutAdapter(RedisTemplate<String, Object> redisTemplate) {
 *         this.redisTemplate = redisTemplate;
 *     }
 *
 *     @Override
 *     public AccountMapper getAccountById(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             return (AccountMapper) redisTemplate.opsForHash().get("accounts", accountMapper.getId());
 *         } catch (Exception e) {
 *             throw new GlobalException("Error retrieving account by ID", e);
 *         }
 *     }
 *
 *     @Override
 *     public Set<AccountMapper> getAccountsByRole(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             // Simulate fetching accounts by role
 *             Set<AccountMapper> accounts = redisTemplate.opsForHash().values("accounts").stream()
 *                     .filter(account -> ((AccountMapper) account).getRoles().containsAll(accountMapper.getRoles()))
 *                     .map(account -> (AccountMapper) account)
 *                     .collect(Collectors.toSet());
 *             return accounts;
 *         } catch (Exception e) {
 *             throw new GlobalException("Error retrieving accounts by role", e);
 *         }
 *     }
 *
 *     @Override
 *     public long getAccountCountByRole(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             // Simulate counting accounts by role
 *             return redisTemplate.opsForHash().values("accounts").stream()
 *                     .filter(account -> ((AccountMapper) account).getRoles().containsAll(accountMapper.getRoles()))
 *                     .count();
 *         } catch (Exception e) {
 *             throw new GlobalException("Error counting accounts by role", e);
 *         }
 *     }
 *
 *     @Override
 *     public Set<AccountMapper> getAccountsByStatus(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             // Simulate fetching accounts by status
 *             Set<AccountMapper> accounts = redisTemplate.opsForHash().values("accounts").stream()
 *                     .filter(account -> ((AccountMapper) account).getStatus().equals(accountMapper.getStatus()))
 *                     .map(account -> (AccountMapper) account)
 *                     .collect(Collectors.toSet());
 *             return accounts;
 *         } catch (Exception e) {
 *             throw new GlobalException("Error retrieving accounts by status", e);
 *         }
 *     }
 *
 *     @Override
 *     public long getAccountCountByStatus(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             // Simulate counting accounts by status
 *             return redisTemplate.opsForHash().values("accounts").stream()
 *                     .filter(account -> ((AccountMapper) account).getStatus().equals(accountMapper.getStatus()))
 *                     .count();
 *         } catch (Exception e) {
 *             throw new GlobalException("Error counting accounts by status", e);
 *         }
 *     }
 *
 *     @Override
 *     public AccountMapper getAccountByKeysLoginEmail(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             return (AccountMapper) redisTemplate.opsForHash().get("accounts", accountMapper.getKeys().iterator().next());
 *         } catch (Exception e) {
 *             throw new GlobalException("Error retrieving account by keys (login/email)", e);
 *         }
 *     }
 *
 *     @Override
 *     public AccountMapper getAccountByLogin(AccountMapper accountMapper) throws GlobalException {
 *         try {
 *             return (AccountMapper) redisTemplate.opsForHash().get("accounts", accountMapper.getLogin());
 *         } catch (Exception e) {
 *             throw new GlobalException("Error retrieving account by login", e);
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
public interface AccountQueryOut {

    /**
     * Retrieves an {@code AccountMapper} by its unique identifier.
     * <p>
     * This method fetches the account details associated with the given id
     * contained within the {@code AccountMapper}. The id is expected to be a unique
     * identifier that can be used to retrieve a single account. If the account with
     * the specified {@code AccountMapper} does not exist, the behavior of this method
     * depends on the implementation, which may return {@code null} or throw an exception.
     * </p>
     *
     * @param mapper   the {@code AccountMapper} containing the id used to retrieve the account
     * @return the {@code AccountMapper} associated with the specified id, or
     *         {@code null} if no such account exists
     * @throws GlobalException if an error occurs during the operation
     */
    AccountMapper getAccountById(AccountMapper mapper) throws GlobalException;

    /**
     * Retrieves a set of {@code AccountMapper} by their roles.
     * <p>
     * This method fetches a collection of accounts that are associated with the
     * roles specified within the {@code AccountMapper}. It returns a set of {@code AccountMapper}
     * instances that match the given roles. If no accounts are found with the
     * specified roles, the behavior of this method depends on the implementation,
     * which may return an empty set or throw an exception.
     * </p>
     *
     * @param mapper   the {@code AccountMapper} containing the roles used to filter the accounts
     * @return a {@code Set<AccountMapper>} containing the accounts associated with the specified roles,
     *         or an empty set if no matching accounts are found
     * @throws GlobalException if an error occurs during the operation
     */
    Set<AccountMapper> getAccountsByRole(AccountMapper mapper) throws GlobalException;

    /**
     * Retrieves the count of accounts by their roles.
     * <p>
     * This method counts the number of accounts that are associated with the
     * roles specified within the {@code AccountMapper}. It returns the count of
     * {@code AccountMapper} instances that match the given roles. If no accounts
     * are found with the specified roles, the behavior of this method depends on
     * the implementation, which may return zero or throw an exception.
     * </p>
     *
     * @param mapper   the {@code AccountMapper} containing the roles used to filter the accounts
     * @return the count of accounts associated with the specified roles
     * @throws GlobalException if an error occurs during the operation
     */
    long getAccountCountByRole(AccountMapper mapper) throws GlobalException;

    /**
     * Retrieves a set of {@code AccountMapper} by their status.
     * <p>
     * This method fetches a collection of accounts that are associated with the
     * status specified within the {@code AccountMapper}. It returns a set of {@code AccountMapper}
     * instances that match the given status. If no accounts are found with the
     * specified status, the behavior of this method depends on the implementation,
     * which may return an empty set or throw an exception.
     * </p>
     *
     * @param mapper   the {@code AccountMapper} containing the status used to filter the accounts
     * @return a {@code Set<AccountMapper>} containing the accounts associated with the specified status,
     *         or an empty set if no matching accounts are found
     * @throws GlobalException if an error occurs during the operation
     */
    Set<AccountMapper> getAccountsByStatus(AccountMapper mapper) throws GlobalException;

    /**
     * Retrieves the count of accounts by their status.
     * <p>
     * This method counts the number of accounts that are associated with the
     * status specified within the {@code AccountMapper}. It returns the count of
     * {@code AccountMapper} instances that match the given status. If no accounts
     * are found with the specified status, the behavior of this method depends on
     * the implementation, which may return zero or throw an exception.
     * </p>
     *
     * @param mapper   the {@code AccountMapper} containing the status used to filter the accounts
     * @return the count of accounts associated with the specified status
     * @throws GlobalException if an error occurs during the operation
     */
    long getAccountCountByStatus(AccountMapper mapper) throws GlobalException;

    /**
     * Retrieves an {@code AccountMapper} by a specific key (login/email).
     * <p>
     * This method fetches the account details associated with the given key
     * contained within the {@code AccountMapper}. The key is expected to be a unique
     * identifier that can be used to retrieve a single account. If the account
     * with the specified key does not exist, the behavior of this method depends
     * on the implementation, which may return {@code null} or throw an exception.
     * </p>
     *
     * @param mapper   the {@code AccountMapper} containing the key used to retrieve the account
     * @return the {@code AccountMapper} associated with the specified key, or
     *         {@code null} if no such account exists
     * @throws GlobalException if an error occurs during the operation
     */
    AccountMapper getAccountByKeysLoginEmail(AccountMapper mapper) throws GlobalException;

    /**
     * Retrieves an {@code AccountMapper} by the account's login credentials.
     * <p>
     * This method fetches the account details associated with the login credentials
     * provided within the {@code AccountMapper}. The login is expected to be a unique
     * identifier such as a username or email that, along with the password, can be
     * used to authenticate and retrieve a single account. If the account with the
     * specified login does not exist or if the password does not match, the behavior
     * of this method depends on the implementation, which may return {@code null},
     * throw an exception, or return an {@code AccountMapper} with limited information
     * indicating an authentication failure.
     * </p>
     *
     * @param mapper   the {@code AccountMapper} containing the login and password used to authenticate
     *            and retrieve the account
     * @return the {@code AccountMapper} associated with the specified login credentials, or
     *         {@code null} if no such account exists or if authentication fails
     * @throws GlobalException if an error occurs during the operation
     */
    AccountMapper getAccountByLogin(AccountMapper mapper) throws GlobalException;
}
