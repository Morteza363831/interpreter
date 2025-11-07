package org.mhzd.execution.service;

import org.mhzd.bytecode.model.Instruction;
import org.mhzd.bytecode.model.OpCode;

import java.util.List;

public interface Execute {

    void execute(List<Instruction> instructions);

    void loopExecute(Instruction loopStart, List<Instruction> instructions);

    void ifExecute(Instruction ifStart, List<Instruction> instructions);

    void printExecute(Instruction instruction);

    void printLnExecute();

    int findMatchingEnd(List<Instruction> instructions, Integer startIndex, OpCode opEnd);
}
