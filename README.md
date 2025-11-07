# Simple Interpreter

A lightweight bytecode interpreter written in Java that compiles and executes a simple programming language with basic control flow constructs.

## 🚧 Development Status

This project is currently under development.

## 📋 Features

- **Source Code Compilation**: Converts high-level commands to bytecode instructions
- **Bytecode Execution**: Executes compiled bytecode with a virtual machine
- **Control Flow Support**:
  - Conditional statements (`IF`/`ENDIF`)
  - Loop constructs (`LOOP`/`ENDLOOP`)
  - Print statements (`PRINT`)

## 🏗️ Architecture

The interpreter follows a clean architecture with separated concerns:

```
src/main/java/org/mhzd/
├── bytecode/
│   ├── model/          # Bytecode data models
│   └── service/        # Compilation services
├── execution/
│   └── service/        # Execution engine
├── sourcecode/         # Source code tokens
└── Interpreter.java    # Main entry point
```

### Core Components

- **Compiler**: Transforms source code into bytecode instructions
- **Execution Engine**: Interprets and executes bytecode
- **Instruction Model**: Represents bytecode operations with opcodes and operands
- **Token System**: Defines supported language keywords

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Building the Project

```bash
mvn clean compile
```

### Running the Interpreter

```bash
mvn exec:java -Dexec.mainClass="org.mhzd.Interpreter"
```

## 📝 Language Syntax

The interpreter supports the following commands:

| Command | Syntax | Description |
|---------|--------|-------------|
| `PRINT` | `PRINT <number>` | Prints a number to console |
| `IF` | `IF <condition>` | Starts conditional block (non-zero = true) |
| `ENDIF` | `ENDIF` | Ends conditional block |
| `LOOP` | `LOOP <count>` | Starts loop block with iteration count |
| `ENDLOOP` | `ENDLOOP` | Ends loop block |

### Example Program

```
PRINT 1
IF 1
PRINT 2
ENDIF
LOOP 3
PRINT 5
ENDLOOP
PRINT 10
```

**Output:**
```
[PRINT] : 1
[PRINT] : 2
[PRINT] : 5
[PRINT] : 5
[PRINT] : 5
[PRINT] : 10
Program Finished!
```

## 🔧 Technical Details

### Bytecode Instructions

The compiler generates the following opcodes:

- `PRINT`: Output a number
- `IF_START`: Begin conditional execution
- `IF_END`: End conditional block
- `LOOP_START`: Begin loop execution
- `LOOP_END`: End loop block
- `END_PROGRAM`: Terminate execution

### Execution Model

The interpreter uses a simple stack-based execution model where:
- Instructions are executed sequentially
- Control flow instructions modify the program counter
- Nested blocks are supported through recursive execution

## 🛠️ Dependencies

- **Lombok**: Reduces boilerplate code with annotations
- **Maven**: Build and dependency management

## 📁 Project Structure

```
interpreter/
├── src/
│   ├── main/java/org/mhzd/
│   │   ├── bytecode/model/
│   │   │   ├── Instruction.java
│   │   │   └── OpCode.java
│   │   ├── bytecode/service/
│   │   │   ├── Compiler.java
│   │   │   └── CompilerImpl.java
│   │   ├── execution/service/
│   │   │   ├── Execute.java
│   │   │   └── ExecuteImpl.java
│   │   ├── sourcecode/
│   │   │   └── Token.java
│   │   └── Interpreter.java
│   └── test/java/
├── target/
├── .gitignore
├── pom.xml
└── README.md
```

## 🔮 Future Enhancements

- [ ] Variable support
- [ ] Arithmetic operations
- [ ] Function definitions
- [ ] Error handling improvements
- [ ] Interactive REPL mode
- [ ] File-based program execution

## 👨‍💻 Author

**Morteza**
- GitHub: [@morteza363831](https://github.com/morteza363831)
- Email: morteza363831official@gmail.com
- Telegram: [@morteza_mhzd](https://t.me/morteza_mhzd)

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/morteza363831/interpreter/issues).

---

*This interpreter serves as an educational project demonstrating compiler design principles and virtual machine implementation in Java.*