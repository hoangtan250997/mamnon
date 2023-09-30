package com.assignment.model;

import com.assignment.entity.congdoan.CongDoan;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(targets = {CongDoan.class, CongDoanDTO.class})
public class MyReflectionConfiguration {

}
