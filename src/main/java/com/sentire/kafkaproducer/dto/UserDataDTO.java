package com.sentire.kafkaproducer.dto;

import java.util.List;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDataDTO {

    private RequestType requestType;
    private String deviceId;
    private List<DataDetailDTO> dataDetailList;
    private List<CountingDataDetailDTO> countingDataDetailList;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private String ram;
    private String cpu;
    private String gpu;
    private String battery;
    
}
