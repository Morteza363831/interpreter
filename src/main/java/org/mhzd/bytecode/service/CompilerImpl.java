package org.mhzd.bytecode.service;

import org.mhzd.bytecode.model.Instruction;
import org.mhzd.bytecode.model.OpCode;
import org.mhzd.sourcecode.Token;

import java.util.List;

public class CompilerImpl implements Compiler {

    @Override
    public List<Instruction> compileToByteCode(List<String> lines) {

        List<Instruction> instructions = new java.util.ArrayList<>();

        lines.forEach(line -> {

            if (line.isBlank()) {
                return;
            }

            String[] parts = line.split(" "); // separate line parts -> PRINT 2 => PRINT and 2
            // make Instruction base on parts
            Instruction instruction = new Instruction();

            // Set OpCode
            switch (Token.valueOf(parts[0].toUpperCase())) {
                case PRINT:
                    instruction.setOpCode(OpCode.PRINT);
                    instruction.setOperand(Integer.parseInt(parts[1]));
                    break;
                case IF:
                    instruction.setOpCode(OpCode.IF_START);
                    instruction.setOperand(Integer.parseInt(parts[1]));
                    break;
                case ENDIF:
                    instruction.setOpCode(OpCode.IF_END);
                    break;
                case LOOP:
                    instruction.setOpCode(OpCode.LOOP_START);
                    instruction.setOperand(Integer.parseInt(parts[1]));
                    break;
                case ENDLOOP:
                    instruction.setOpCode(OpCode.LOOP_END);
                    break;
                case UNKNOWN:
                    System.out.println("Unknown command!");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction: " + parts[0]);
            }

            // Set Operand
            if (parts.length > 1) {
                instruction.setOperand(Integer.parseInt(parts[1]));
            } else {
                instruction.setOperand(-1);
            }

            instructions.add(instruction);
        });

        // add END_PROGRAM instruction
        Instruction endProgramInstruction = new Instruction(OpCode.END_PROGRAM, -1);
        instructions.add(endProgramInstruction);

        return instructions;
    }
}
