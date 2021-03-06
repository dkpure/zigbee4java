package org.bubblecloud.zigbee.network.zcl.field;

import org.bubblecloud.zigbee.api.cluster.impl.api.core.ZBDeserializer;
import org.bubblecloud.zigbee.api.cluster.impl.api.core.ZBSerializer;
import org.bubblecloud.zigbee.api.cluster.impl.api.core.ZigBeeType;
import org.bubblecloud.zigbee.network.zcl.ZclListItemField;

/**
 * Read Attribute Status Record field.
 */
public class AttributeReportingConfigurationRecord implements ZclListItemField {
    /**
     * The attribute identifier.
     */
    private int attributeIdentifier;
    /**
     * The attribute data type.
     */
    private int attributeDataType;
    /**
     * The minimum reporting interval.
     */
    private int minimumReportingInterval;
    /**
     * The maximum reporting interval.
     */
    private int maximumReportingInterval;
    /**
     * The reportable change.
     */
    private Object reportableChange;
    /**
     * The maximum reporting interval.
     */
    private int timeoutPeriod;

    /**
     * Gets attribute data type.
     * @return the attribute data type
     */
    public int getAttributeDataType() {
        return attributeDataType;
    }

    /**
     * Sets attribute data type.
     * @param attributeDataType the attribute data type
     */
    public void setAttributeDataType(int attributeDataType) {
        this.attributeDataType = attributeDataType;
    }

    /**
     * Gets attribute identifier.
     * @return the attribute identifier
     */
    public int getAttributeIdentifier() {
        return attributeIdentifier;
    }

    /**
     * Sets attribute identifier.
     * @param attributeIdentifier the attribute identifier
     */
    public void setAttributeIdentifier(int attributeIdentifier) {
        this.attributeIdentifier = attributeIdentifier;
    }

    /**
     * Gets maximum reporting interval.
     * @return the maximum reporting interval
     */
    public int getMaximumReportingInterval() {
        return maximumReportingInterval;
    }

    /**
     * Sets maximum reporting interval.
     * @param maximumReportingInterval the maximum reporting interval
     */
    public void setMaximumReportingInterval(int maximumReportingInterval) {
        this.maximumReportingInterval = maximumReportingInterval;
    }

    /**
     * Gets minimum reporting interval.
     * @return the minimum reporting interval
     */
    public int getMinimumReportingInterval() {
        return minimumReportingInterval;
    }

    /**
     * Sets minimum reporting interval.
     * @param minimumReportingInterval the minimum reporting interval
     */
    public void setMinimumReportingInterval(int minimumReportingInterval) {
        this.minimumReportingInterval = minimumReportingInterval;
    }

    /**
     * Gets reportable change.
     * @return the reportable change
     */
    public Object getReportableChange() {
        return reportableChange;
    }

    /**
     * Sets reportable change.
     * @param reportableChange the reportable change
     */
    public void setReportableChange(Object reportableChange) {
        this.reportableChange = reportableChange;
    }

    /**
     * Gets timeout period.
     * @return the timeout period
     */
    public int getTimeoutPeriod() {
        return timeoutPeriod;
    }

    /**
     * Sets timeout period.
     * @param timeoutPeriod the timeout period
     */
    public void setTimeoutPeriod(int timeoutPeriod) {
        this.timeoutPeriod = timeoutPeriod;
    }

    @Override
    public void serialize(final ZBSerializer serializer) {
        serializer.appendShort((short) attributeIdentifier);
        serializer.appendByte((byte) attributeDataType);
        serializer.appendShort((short) minimumReportingInterval);
        serializer.appendShort((short) maximumReportingInterval);
        final ZigBeeType type = ZigBeeType.getType((byte) attributeDataType);
        serializer.appendZigBeeType(reportableChange, type);
        serializer.appendShort((short) timeoutPeriod);
    }

    @Override
    public void deserialize(final ZBDeserializer deserializer) {
        attributeIdentifier = deserializer.read_short() & (0xFFFF);
        attributeDataType = deserializer.read_byte() & (0xFF);
        minimumReportingInterval = deserializer.read_uint16bit() & (0xFF);
        maximumReportingInterval = deserializer.read_uint16bit() & (0xFF);
        final ZigBeeType type = ZigBeeType.getType((byte) attributeDataType);
        reportableChange = deserializer.readZigBeeType(type);
        timeoutPeriod = deserializer.read_uint16bit() & (0xFF);
    }

    @Override
    public String toString() {
        return "Attribute Reporting Configuration Record " +
                "attributeDataType=" + attributeDataType +
                ", attributeIdentifier=" + attributeIdentifier +
                ", minimumReportingInterval=" + minimumReportingInterval +
                ", maximumReportingInterval=" + maximumReportingInterval +
                ", reportableChange=" + reportableChange +
                ", timeoutPeriod=" + timeoutPeriod;
    }
}
