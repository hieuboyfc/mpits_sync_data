package com.fps.mpits.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 */

@Accessors(fluent = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SyncResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private byte type;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "ID: " + id + " - Type: " + type + " - Message: " + message;
    }

}
