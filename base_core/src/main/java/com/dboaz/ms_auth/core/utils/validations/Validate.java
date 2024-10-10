package com.dboaz.ms_auth.core.utils.validations;

import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

import com.dboaz.ms_auth.core.mappers.AccountMapper;
import com.dboaz.ms_auth.core.enums.RoleType;
import com.dboaz.ms_auth.core.enums.StatusType;
import com.dboaz.ms_auth.core.utils.constants.Regex;
import com.dboaz.ms_auth.core.utils.services.Crypt;
import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.exceptions.GlobalException;
import com.dboaz.utils.models.CustomAlert;

/**
 * The {@code Validate} class provides methods for validating login, email, password, status and roles fields.
 * <p>
 * Each method throws a {@code GlobalException} if the validation fails.
 * </p>
 * 
 * @author GustavoBoaz
 * @since 1.0
 */
public class Validate {

    /**
     * Validates the command field, ensuring it is not null or brank.
     * 
     * @throws GlobalException if the validation fails
     */
    public static void command(String command) {
        if (command == null || command.isBlank()) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C030DB)).build();
        }
    }

    /**
     * Validates the query field, ensuring it is not null or brank.
     * 
     * @throws GlobalException if the validation fails
     */
    public static void query(String query) {
        if (query == null || query.isBlank()) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C030DB)).build();
        }
    }
    
    /**
     * Validates the login field, ensuring it is not null or blank and matches the required pattern.
     * 
     * @throws GlobalException if the login is invalid.
     */
    public static void login(String login) {
        if (login == null || login.isBlank()) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C030DB)).build();
        }

        if (!Pattern.matches(Regex.LOGIN, login)) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C031DB)).build();
        }
    }

    /**
     * Validates the email field, ensuring it is not null or blank and matches the required pattern.
     * 
     * @throws GlobalException if the email is invalid.
     */
    public static void email(String email) {
        if (email == null || email.isBlank()) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C030DB)).build();
        }

        if (!Pattern.matches(Regex.EMAIL, email)) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C031DB)).build();
        }
    }

    /**
     * Validates the password field, ensuring it is not null or blank and matches the required security pattern.
     * 
     * @throws GlobalException if the password is invalid.
     */
    public static void password(String password) {
        if (password == null || password.isBlank()) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C030DB)).build();
        }

        if (!Pattern.matches(Regex.PASSWORD, password)) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C032DB)).build();
        }
    }

    /**
     * Validates the status field, ensuring it is not null, not empty.
     * 
     * @throws GlobalException if the status is invalid.
     */
    public static void status(StatusType status) {
        if (status == null) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C033DB)).build();
        }
    }

    /**
     * Validate the uuid field, ensuring it is not null or blank.
     * 
     * @throws GlobalException if the uuid is invalid.
     */
    public static void uuid(String uuid) {
        if (uuid == null || uuid.isBlank()) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C030DB)).build();
        }

        try {
            UUID.fromString(uuid);
        } catch(Exception e){
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C035DB)).build();
        }
    }

    /**
     * Validate the keys field, ensuring it is not null or blank.
     *
     * @throws GlobalException if the keys is invalid.
     */
    public static void keys(Set<String> keys) {
        if (keys == null || keys.isEmpty()) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C030DB)).build();
        }
    }

    /**
     * Validates the roles field, ensuring it is not null, not empty, and that all roles are valid.
     * 
     * @throws GlobalException if the roles set is invalid or contains null or invalid roles.
     */
    public static void roles(Set<RoleType> roles) {
        if (roles == null || roles.isEmpty()) {
            throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C030DB)).build();
        }

        for (RoleType role : roles) {
            if (role == null) {
                throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C033DB)).build();
            }

            boolean isValidRole = false;
            for (RoleType validRole : RoleType.values()) {
                if (role.equals(validRole)) {
                    isValidRole = true;
                    break;
                }
            }

            if (!isValidRole) {
                throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C034DB)).build();
            }
        }
    }

    /**
     * Validates the user's credentials by comparing the provided password with the stored password.
     * <p>
     * If validation fails, a {@link GlobalException} is thrown with an appropriate error message.
     * </p>
     *
     * @param entity            the user's account details fetched from the service.
     * @param rawPassword       the raw password provided in the request.
     * @throws GlobalException  if the account is null or the passwords do not match.
     */
    public static void credentials(AccountMapper entity, String rawPassword) {
        if (entity == null || !Crypt.isMatch(rawPassword, entity.getPassword())) {
            throw GlobalException.builder().status(401).alert(new CustomAlert(SystemCodeEnum.C040DB)).build();
        }
    }
}
