package org.bubblecloud.zigbee.network.zcl.protocol.command.general;

import org.bubblecloud.zigbee.network.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.network.zcl.ZclCommand;
import org.bubblecloud.zigbee.network.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.network.zcl.protocol.ZclFieldType;
import org.bubblecloud.zigbee.network.zcl.field.*;

import java.util.List;

/**
 * Code generated Read Attributes Response Command value object class.
 */
public class ReadAttributesResponseCommand extends ZclCommand {
    /**
     * Records command message field.
     */
    private List<ReadAttributeStatusRecord> records;

    /**
     * Default constructor setting the command type field.
     */
    public ReadAttributesResponseCommand() {
        this.setType(ZclCommandType.READ_ATTRIBUTES_RESPONSE_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public ReadAttributesResponseCommand(final ZclCommandMessage message) {
        super(message);
        this.records = (List<ReadAttributeStatusRecord>) message.getFields().get(ZclFieldType.READ_ATTRIBUTES_RESPONSE_COMMAND_RECORDS);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.READ_ATTRIBUTES_RESPONSE_COMMAND_RECORDS,records);
        return message;
    }

    /**
     * Gets Records.
     * @return the Records
     */
    public List<ReadAttributeStatusRecord> getRecords() {
        return records;
    }

    /**
     * Sets Records.
     * @param records the Records
     */
    public void setRecords(final List<ReadAttributeStatusRecord> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("records");
        builder.append('=');
        builder.append(records);
        return builder.toString();
    }

}
