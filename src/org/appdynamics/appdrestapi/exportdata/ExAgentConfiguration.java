/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.exportdata;

import org.appdynamics.appdrestapi.resources.AppExportS;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;


/**
 *
 * @author gilbert.solorzano
 * 
 * <agent_configuration>
            <override>true</override>
            <agent-type>APP_AGENT</agent-type>
            <propertie-definitions/>
            <properties>
                <property>
                    <property-definition>enable-json-bci-rules</property-definition>
                    <string-value>false</string-value>
                </property>

            </properties>
        </agent_configuration>
        <agent_configuration>
            <override>true</override>
            <agent-type>DOT_NET_APP_AGENT</agent-type>
            <property-definitions>
                <property-definition>
                    <name>enable-default-http-error-code-reporter</name>
                    <description>Disable/enable automatic HTTP error code reporting for error codes between 400 - 505, default TRUE.</description>
                    <type>BOOLEAN</type>
                    <required>false</required>
                    <default-string-value>true</default-string-value>
                </property-definition>
                <property-definition>
                    <name>slow-request-threshold</name>
                    <description>In flight requests taking more time than this threshold (in ms) and with a deviation greater than 'slow-request-deviation' from the current average response time will be monitored to capture hotspots. </description>
                    <type>INTEGER</type>
                    <required>false</required>
                    <default-string-value>500</default-string-value>
                    <upper-numeric-bound>3600</upper-numeric-bound>
                    <lower-numeric-bound>0</lower-numeric-bound>
                </property-definition>
                <property-definition>
                    <name>disable-custom-exit-points-for</name>
                    <description>Disable Out of the box custom exit points by specifying the type here, e.g. ehcache For multiple, use a comma separated list from the following SAP,Mail,LDAP,MongoDB</description>
                    <type>STRING</type>
                    <required>false</required>
                    <default-string-value/>
                    <string-max-length>0</string-max-length>
                    <allowed-string-values/>
                </property-definition>
            </property-definitions>
            <properties>
                <property>
                    <property-definition>leak-diagnostic-interval-in-minutes</property-definition>
                    <string-value>30</string-value>
                </property>
            </properties>
        </agent_configuration>

        * 
        * <override>true</override>
            <agent-type>APP_AGENT</agent-type>
            <propertie-definitions/>
            <properties>
 */
public class ExAgentConfiguration {
    private boolean override;
    private String agentType;
    private ExPropertyDefinitions propertyDefinitions;
    private ExProperties properties;
    
    public ExAgentConfiguration(){}

    @XmlElement(name=AppExportS.OVERRIDE)
    public boolean isOverride() {
        return override;
    }

    public void setOverride(boolean override) {
        this.override = override;
    }

    @XmlElement(name=AppExportS.AGENT_TYPE)
    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    @XmlElement(name=AppExportS.PROPERTY_DEFINITIONS)
    public ExPropertyDefinitions getPropertyDefinitions() {
        return propertyDefinitions;
    }

    public void setPropertyDefinitions(ExPropertyDefinitions propertyDefinitions) {
        this.propertyDefinitions = propertyDefinitions;
    }

    @XmlElement(name=AppExportS.PROPERTIES)
    public ExProperties getProperties() {
        return properties;
    }

    public void setProperties(ExProperties properties) {
        this.properties = properties;
    }
    
    
    
    @Override
    public String toString(){
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L1_1).append(AppExportS.AGENT_CONFIGURATION);
        bud.append(AppExportS.L2).append(AppExportS.OVERRIDE).append(AppExportS.VE).append(override);
        bud.append(AppExportS.L2).append(AppExportS.AGENT_TYPE).append(AppExportS.VE).append(agentType);
        bud.append(propertyDefinitions.toString());
        bud.append(properties.toString());
        return bud.toString();
    }
}