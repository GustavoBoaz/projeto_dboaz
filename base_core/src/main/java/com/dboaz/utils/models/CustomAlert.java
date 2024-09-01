package com.dboaz.utils.models;

import java.io.Serializable;

import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.exceptions.GlobalException;

/**
 * Model Class for handling custom alerts within the system.
 *
 * <p>
 * The {@code CustomAlert} class is designed to encapsulate detailed information about 
 * system alerts or errors, making it easier to standardize error handling across the 
 * application. Each alert is associated with a specific {@link SystemCodeEnum} code, 
 * which provides both a problem description and a recommended action.
 *
 * Example usage:
 *
 * <pre>
 * {@code
 *   CustomAlert alert = new CustomAlert(SystemCodeEnum.C0001DB);
 *   System.out.println(alert.getCode().getProblem());  // Outputs: "Internal server error"
 *   System.out.println(alert.getAction());            // Outputs: "Try a connection at another time"
 * }
 * </pre>
 * 
 * This class is typically used in conjunction with {@link GlobalException} to provide 
 * a comprehensive error reporting mechanism.
 * 
 * <b>Important:</b> Always ensure that the correct {@link SystemCodeEnum} is passed 
 * to the constructor to maintain consistency in how errors and alerts are managed 
 * within the system.
 * </p>
 *
 * @author GustavoBoaz
 * @version 1.0.0
 **/
public class CustomAlert implements Serializable {
    private static final long serialVersionUID = 1L;

    private SystemCodeEnum code;
    private String action;

    /**
     * Constructs a new {@code CustomAlert} with the specified system code.
     *
     * @param code the {@link SystemCodeEnum} representing the error or alert
     */
    public CustomAlert(SystemCodeEnum code) {
        this.code = code;
        this.action = code.getAction();
    }

    /**
     * Returns the system code associated with this alert.
     *
     * @return the {@link SystemCodeEnum} for this alert
     */
    public SystemCodeEnum getCode() { return this.code; }
    
    /**
     * Returns the recommended action associated with this alert.
     *
     * @return the action string for this alert
     */
    public String getAction() { return this.action; }
}