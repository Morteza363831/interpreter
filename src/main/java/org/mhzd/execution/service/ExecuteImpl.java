package org.mhzd.execution.service;

import org.mhzd.bytecode.model.Instruction;
import org.mhzd.bytecode.model.OpCode;

import java.util.List;

public class ExecuteImpl implements Execute{

    // Execute ByteCode Using Switch Case

    @Override
    public void execute(List<Instruction> instructions) {

        for (int i = 0; i < instructions.size(); i++) {

            Instruction instr = instructions.get(i);

            OpCode op = instr.getOpCode();

            switch (op) {

                case PRINT -> printExecute(instr);

                case IF_START -> {
                    int ifEnd = findMatchingEnd(instructions, i, OpCode.IF_END);
                    List<Instruction> block = instructions.subList(i + 1, ifEnd);
                    ifExecute(instr, block);
                    i = ifEnd; // jump to after ENDIF
                }

                case LOOP_START -> {
                    int loopEnd = findMatchingEnd(instructions, i, OpCode.LOOP_END);
                    List<Instruction> block = instructions.subList(i + 1, loopEnd);
                    loopExecute(instr, block);
                    i = loopEnd; // jump to after ENDLOOP
                }

                case END_PROGRAM -> System.out.println("Program Finished!");

                default -> throw new IllegalStateException("Unexpected value: " + op);
            }
        }
    }

    @Override
    public void loopExecute(Instruction loopStart, List<Instruction> instructions) {

        for (int i = 0; i < loopStart.getOperand(); i++) {
            execute(instructions); // send inner Instructions to execute() function
        }

    }


    @Override
    public void ifExecute(Instruction ifStart, List<Instruction> instructions) {
        if (ifStart.getOperand() != 0) {
            execute(instructions); // run inner Instructions
            return;
        }
        //skipped
    }

    @Override
    public void printExecute(Instruction instruction) {
        System.out.println("[PRINT] : " + instruction.getOperand());
    }

    @Override
    public void printLnExecute() {
        System.out.println();
    }

    @Override
    public int findMatchingEnd(List<Instruction> instructions, Integer startIndex, OpCode opEnd) {

        for (int i = startIndex+1 ; i < instructions.size(); i++) {
            if (instructions.get(i).getOpCode() == opEnd) {
                return i;
            }
        }

        throw new IllegalStateException("End instruction not found");
    }
}
