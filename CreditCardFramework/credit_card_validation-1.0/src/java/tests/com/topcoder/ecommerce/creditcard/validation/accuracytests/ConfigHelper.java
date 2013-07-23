/*
 * ComponentName: CreditCardWallet
 * FileName: ConfigHelper.java
 * Version: 1.0
 * Date: 08/28/2004
 *
 * <p>Copyright (c) 2004, TopCoder, Inc. All rights reserved</p>
 */
package com.topcoder.ecommerce.creditcard.validation.accuracytests;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;

/**
 * <p>
 * This package private class is used to get the configured 
 * ConfigManger, only contains one static method. Please see the 
 * doc of  the method for more details.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
 
class ConfigHelper {
    
    /**
     * <p>
     * Represents the location of the configuration file
     * </p>
     */
    public static String LOCATION_CONFIG = 
        "test_files/accuracytests/CreditCardValidatorRegistryConfig.xml";
    
    /**
     * <p>
     * Represents the namespace of the configuration file 
     * </p>
     */
    public static String NAMESPACE = 
        "com.topcoder.ecommerce.creditcard.validation.CreditCardValidatorRegistry";
    
    /**
     * <p>
     * Initial the ConfigManager with the configuration files in the test_files. 
     * </p>
     * 
     */
    public static ConfigManager initialConfigManager() throws ConfigManagerException {
        ConfigManager cm = ConfigManager.getInstance();
        if (cm.existsNamespace(NAMESPACE)) {
            cm.removeNamespace(NAMESPACE);  
        } 
        
        
        cm.add(NAMESPACE, LOCATION_CONFIG, ConfigManager.CONFIG_MULTIPLE_XML_FORMAT);
       
        return cm;
    }
}