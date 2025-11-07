package org.mhzd.bytecode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Instruction {
    private OpCode opCode;
    private int operand;

    @Override
    public String toString() {
        return opCode + (operand != -1 ? " " + operand : "");
    }
}
