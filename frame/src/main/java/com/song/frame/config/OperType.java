package com.song.frame.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作类型
 *
 * @author xdc
 */
public enum OperType {
    TYPE;
    private Map<String, Object> type;

    public void setType(Map<String, Object> type) {
        this.type = type;
    }

    public Map<String, Object> getType() {
        if (type == null) {
            type = new HashMap<>();
        }
        return type;
    }
}