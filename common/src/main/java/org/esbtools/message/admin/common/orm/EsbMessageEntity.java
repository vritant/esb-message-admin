/*
 Copyright 2015 esbtools Contributors and/or its affiliates.

 This file is part of esbtools.

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.esbtools.message.admin.common.orm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.esbtools.message.admin.model.EsbMessage.ErrorType;

@Entity
@Table(name="ESB_MESSAGE")
public class EsbMessageEntity implements Serializable {

    private static final long serialVersionUID = 357984147079041238L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="error_queue")
    private String esbErrorQueue;

    @Column(name = "jms_message_id")
    private String esbMessageId;

    @Column(name = "jms_message_timestamp")
    private Date timestamp;

    @Column(name="message_guid")
    private String esbMessageGuid;

    @Column(name = "message_type")
    private String esbMessageType;

    @Column(name="source_queue")
    private String esbSourceQueue;

    @Column(name="source_location")
    private String esbSourceLocation;

    @Column(name="source_system")
    private String esbSourceSystem;

    @Column(name="service_name")
    private String esbServiceName;

    @Column(name="error_component")
    private String esbErrorComponent;

    @Column(name="error_message")
    private String errorMessage;

    @Column(name="error_details")
    private String errorDetails;

    @Column(name = "error_system")
    private String esbErrorSystem;

    @Enumerated(EnumType.STRING)
    @Column(name = "error_type")
    private ErrorType errorType;

    @Column(name = "occurrence_count")
    private Integer occurrenceCount;

    @Lob
    @Column(columnDefinition="TEXT")
    private String payload;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, mappedBy = "esbMessage") //,fetch=FetchType.LAZY
    private List<EsbMessageHeaderEntity> errorHeaders;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, mappedBy = "esbMessage" , fetch=FetchType.LAZY)
    private List<EsbMessageSensitiveInfoEntity> errorSensitiveInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getErrorQueue() {
        return esbErrorQueue;
    }

    public void setErrorQueue(String errorQueue) {
        this.esbErrorQueue = errorQueue;
    }

    public String getMessageId() {
        return esbMessageId;
    }

    public void setMessageId(String messageId) {
        this.esbMessageId = messageId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessageGuid() {
        return esbMessageGuid;
    }

    public void setMessageGuid(String messageGuid) {
        this.esbMessageGuid = messageGuid;
    }

    public String getMessageType() {
        return esbMessageType;
    }

    public void setMessageType(String messageType) {
        this.esbMessageType = messageType;
    }

    public String getSourceQueue() {
        return esbSourceQueue;
    }

    public void setSourceQueue(String sourceQueue) {
        this.esbSourceQueue = sourceQueue;
    }

    public String getSourceLocation() {
        return esbSourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.esbSourceLocation = sourceLocation;
    }

    public String getSourceSystem() {
        return esbSourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.esbSourceSystem = sourceSystem;
    }

    public String getServiceName() {
        return esbServiceName;
    }

    public void setServiceName(String serviceName) {
        this.esbServiceName = serviceName;
    }

    public String getErrorComponent() {
        return esbErrorComponent;
    }

    public void setErrorComponent(String errorComponent) {
        this.esbErrorComponent = errorComponent;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public String getErrorSystem() {
        return esbErrorSystem;
    }

    public void setErrorSystem(String errorSystem) {
        this.esbErrorSystem = errorSystem;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public Integer getOccurrenceCount() {
        return occurrenceCount;
    }

    public void setOccurrenceCount(Integer occurrenceCount) {
        this.occurrenceCount = occurrenceCount;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public List<EsbMessageHeaderEntity> getErrorHeaders() {
        return errorHeaders;
    }

    public void setErrorHeaders(List<EsbMessageHeaderEntity> errorHeaders) {
        this.errorHeaders = errorHeaders;
    }

    public List<EsbMessageSensitiveInfoEntity> getErrorSensitiveInfo() {
        return errorSensitiveInfo;
    }

    public void setErrorSensitiveInfo(List<EsbMessageSensitiveInfoEntity> errorSensitiveInfo) {
        this.errorSensitiveInfo = errorSensitiveInfo;
    }

    public EsbMessageHeaderEntity getHeader(String headerName) {
        for (EsbMessageHeaderEntity header : getErrorHeaders()) {
            if (header.getName().equals(headerName)) {
                return header;
            }
        }
        return null;
    }
}
