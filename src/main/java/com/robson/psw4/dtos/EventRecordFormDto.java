package com.robson.psw4.dtos;

import com.robson.psw4.model.Ivent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EventRecordFormDto {

    @NotNull
    @NotEmpty
    private String user;
    @NotNull
    @NotEmpty
    private Ivent event;
    @NotNull
    @NotEmpty
    private String participationType;
    @NotNull
    @NotEmpty
    private String foodReference;
}
