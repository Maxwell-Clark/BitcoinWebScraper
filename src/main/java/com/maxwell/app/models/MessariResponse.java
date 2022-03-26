package com.maxwell.app.models;

import com.maxwell.app.models.MessariData;
import com.maxwell.app.models.MessariStatus;

public class MessariResponse {
    private MessariStatus status;
    private MessariData data;

    public MessariResponse(MessariStatus status, MessariData data) {
        this.status = status;
        this.data = data;
    }

    public MessariStatus getStatus() {
        return status;
    }

    public void setStatus(MessariStatus status) {
        this.status = status;
    }

    public MessariData getData() {
        return data;
    }

    public void setData(MessariData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessariResponse{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
