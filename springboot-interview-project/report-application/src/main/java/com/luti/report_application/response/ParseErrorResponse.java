package com.luti.report_application.response;

import lombok.Data;

@Data
public class ParseErrorResponse {
    private Boolean success = false;
    private String msg;
}
