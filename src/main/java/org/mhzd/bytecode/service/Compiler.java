package org.mhzd.bytecode.service;

import org.mhzd.bytecode.model.Instruction;

import java.util.List;

public interface Compiler {

    List<Instruction> compileToByteCode(List<String> lines);
}
