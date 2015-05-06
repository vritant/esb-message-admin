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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ESB_MESSAGE_SECRET", schema="asd")
public class EsbMessageSecretEntity implements Serializable {

    private static final long serialVersionUID = 357984147079041238L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="value")
    private String value;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="message_id")
    private EsbMessageEntity esbMessage;

    public EsbMessageSecretEntity(EsbMessageEntity esbMessage, String value ) {
        this.esbMessage = esbMessage;
        this.value = value;
    }

    public EsbMessageSecretEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public EsbMessageEntity getEsbMessage() {
        return esbMessage;
    }

    public void setEsbMessage(EsbMessageEntity esbMessage) {
        this.esbMessage = esbMessage;
    }
}
