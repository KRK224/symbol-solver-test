CLASSDTO: { classId: 1, name: Main, type: class }

CLASSDTO: { classId: 2, name: Player, type: class }

CLASSDTO: { classId: 3, name: Input, type: class }

CLASSDTO: { classId: 4, name: Message, type: class }

CLASSDTO: { classId: 5, name: Game, type: class }

CLASSDTO: { classId: 6, name: RandomNumberGenerator, type: class }

CLASSDTO: { classId: 7, name: FixedNumberGenerator, type: class }

CLASSDTO: { classId: 8, name: Judgement, type: class }

CLASSDTO: { classId: 9, name: Config, type: class }

CLASSDTO: { classId: 10, name: GameStatus, type: enum }

CLASSDTO: { classId: 11, name: Output, type: class }

CLASSDTO: { classId: 12, name: Computer, type: class }

CLASSDTO: { classId: 13, name: NumberGenerator, type: interface }

CLASSDTO: { classId: 14, name: ComputerTest, type: class }

MemberVariableDeclarationDTO: { variableId: 2, name: numbers, belongedClassId: 2, type: List<Integer>, typeClassId: -1 }

MemberVariableDeclarationDTO: { variableId: 3, name: numberSet, belongedClassId: 2, type: Set<Integer>, typeClassId: -1 }

MemberVariableDeclarationDTO: { variableId: 6, name: scanner, belongedClassId: 3, type: Scanner, typeClassId: -1 }

MemberVariableDeclarationDTO: { variableId: 8, name: INPUT_NUMBER_TO_PLAY, belongedClassId: 4, type: String, typeClassId: -1 }

MemberVariableDeclarationDTO: { variableId: 9, name: NOTHING, belongedClassId: 4, type: String, typeClassId: -1 }

MemberVariableDeclarationDTO: { variableId: 10, name: BALL, belongedClassId: 4, type: String, typeClassId: -1 }

MemberVariableDeclarationDTO: { variableId: 11, name: STRIKE, belongedClassId: 4, type: String, typeClassId: -1 }

MemberVariableDeclarationDTO: { variableId: 12, name: THREE_STRIKE, belongedClassId: 4, type: String, typeClassId: -1 }

MemberVariableDeclarationDTO: { variableId: 13, name: RETRY, belongedClassId: 4, type: String, typeClassId: -1 }

MemberVariableDeclarationDTO: { variableId: 14, name: computer, belongedClassId: 5, type: Computer, typeClassId: 12 }

MemberVariableDeclarationDTO: { variableId: 15, name: player, belongedClassId: 5, type: Player, typeClassId: 2 }

MemberVariableDeclarationDTO: { variableId: 16, name: input, belongedClassId: 5, type: Input, typeClassId: 3 }

MemberVariableDeclarationDTO: { variableId: 17, name: judgement, belongedClassId: 5, type: Judgement, typeClassId: 8 }

MemberVariableDeclarationDTO: { variableId: 18, name: output, belongedClassId: 5, type: Output, typeClassId: 11 }

MemberVariableDeclarationDTO: { variableId: 19, name: gameStatus, belongedClassId: 5, type: Integer, typeClassId: -1 }

MemberVariableDeclarationDTO: { variableId: 31, name: BASEBALL_GAME_SIZE, belongedClassId: 9, type: Integer, typeClassId: -1 }

MemberVariableDeclarationDTO: { variableId: 32, name: gameStatus, belongedClassId: 10, type: int, typeClassId: 0 }

MemberVariableDeclarationDTO: { variableId: 33, name: astTest, belongedClassId: 12, type: String[], typeClassId: -10 }

MemberVariableDeclarationDTO: { variableId: 34, name: randomNumberGenerator, belongedClassId: 12, type: RandomNumberGenerator, typeClassId: 6 }

MemberVariableDeclarationDTO: { variableId: 35, name: fixedNumberGenerator, belongedClassId: 12, type: FixedNumberGenerator, typeClassId: 7 }

MemberVariableDeclarationDTO: { variableId: 36, name: answer, belongedClassId: 12, type: List<Integer>, typeClassId: -1 }

StmtVariableDeclarationDTO: { variableId: 1, name: game, type: Game, typeClassId: 5 }

StmtVariableDeclarationDTO: { variableId: 4, name: input, type: String, typeClassId: -1 }

StmtVariableDeclarationDTO: { variableId: 5, name: number, type: int, typeClassId: 0 }

StmtVariableDeclarationDTO: { variableId: 7, name: code, type: String, typeClassId: -1 }

StmtVariableDeclarationDTO: { variableId: 20, name: inputs, type: String[], typeClassId: -10 }

StmtVariableDeclarationDTO: { variableId: 21, name: strike, type: int, typeClassId: 0 }

StmtVariableDeclarationDTO: { variableId: 22, name: ball, type: int, typeClassId: 0 }

StmtVariableDeclarationDTO: { variableId: 23, name: status, type: String, typeClassId: -1 }

StmtVariableDeclarationDTO: { variableId: 24, name: randomNumberList, type: List<Integer>, typeClassId: -1 }

StmtVariableDeclarationDTO: { variableId: 25, name: random, type: Random, typeClassId: -1 }

StmtVariableDeclarationDTO: { variableId: 26, name: randomNumber, type: int, typeClassId: 0 }

StmtVariableDeclarationDTO: { variableId: 27, name: test, type: List<Integer>, typeClassId: -1 }

StmtVariableDeclarationDTO: { variableId: 28, name: result, type: int, typeClassId: 0 }

StmtVariableDeclarationDTO: { variableId: 29, name: count, type: int, typeClassId: 0 }

StmtVariableDeclarationDTO: { variableId: 30, name: i, type: int, typeClassId: 0 }

StmtVariableDeclarationDTO: { variableId: 37, name: computer, type: Computer, typeClassId: 12 }

MethodDeclarationDTO: { methodDeclarationId: 1, name: main, belongedClassId: 1 }
ReturnMapperDto: { returnMapperId: 1, methodDeclId: 1,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 2, name: Player, belongedClassId: 2 }
ReturnMapperDto: { returnMapperId: null, methodDeclId: null,type: null,typeClassId: null}

MethodDeclarationDTO: { methodDeclarationId: 3, name: getNumbers, belongedClassId: 2 }
ReturnMapperDto: { returnMapperId: 2, methodDeclId: 3,type: List<Integer>,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 4, name: generateNumbers, belongedClassId: 2 }
ReturnMapperDto: { returnMapperId: 3, methodDeclId: 4,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 5, name: isBaseballGameSize, belongedClassId: 2 }
ReturnMapperDto: { returnMapperId: 4, methodDeclId: 5,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 6, name: isMatch, belongedClassId: 2 }
ReturnMapperDto: { returnMapperId: 5, methodDeclId: 6,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 7, name: isExist, belongedClassId: 2 }
ReturnMapperDto: { returnMapperId: 6, methodDeclId: 7,type: boolean,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 8, name: buildNumbers, belongedClassId: 2 }
ReturnMapperDto: { returnMapperId: 7, methodDeclId: 8,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 9, name: clearSet, belongedClassId: 2 }
ReturnMapperDto: { returnMapperId: 8, methodDeclId: 9,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 10, name: Input, belongedClassId: 3 }
ReturnMapperDto: { returnMapperId: null, methodDeclId: null,type: null,typeClassId: null}

MethodDeclarationDTO: { methodDeclarationId: 11, name: getRetry, belongedClassId: 3 }
ReturnMapperDto: { returnMapperId: 9, methodDeclId: 11,type: int,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 12, name: getNumber, belongedClassId: 3 }
ReturnMapperDto: { returnMapperId: 10, methodDeclId: 12,type: String[],typeClassId: -10}

MethodDeclarationDTO: { methodDeclarationId: 13, name: Message, belongedClassId: 4 }
ReturnMapperDto: { returnMapperId: null, methodDeclId: null,type: null,typeClassId: null}

MethodDeclarationDTO: { methodDeclarationId: 14, name: getInputNumberToPlay, belongedClassId: 4 }
ReturnMapperDto: { returnMapperId: 11, methodDeclId: 14,type: String,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 15, name: getStatus, belongedClassId: 4 }
ReturnMapperDto: { returnMapperId: 12, methodDeclId: 15,type: String,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 16, name: getThreeStrike, belongedClassId: 4 }
ReturnMapperDto: { returnMapperId: 13, methodDeclId: 16,type: String,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 17, name: getRetry, belongedClassId: 4 }
ReturnMapperDto: { returnMapperId: 14, methodDeclId: 17,type: String,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 18, name: getNothing, belongedClassId: 4 }
ReturnMapperDto: { returnMapperId: 15, methodDeclId: 18,type: String,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 19, name: getBall, belongedClassId: 4 }
ReturnMapperDto: { returnMapperId: 16, methodDeclId: 19,type: String,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 20, name: getStrike, belongedClassId: 4 }
ReturnMapperDto: { returnMapperId: 17, methodDeclId: 20,type: String,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 21, name: Game, belongedClassId: 5 }
ReturnMapperDto: { returnMapperId: null, methodDeclId: null,type: null,typeClassId: null}

MethodDeclarationDTO: { methodDeclarationId: 22, name: testing, belongedClassId: 5 }
ReturnMapperDto: { returnMapperId: 18, methodDeclId: 22,type: Computer,typeClassId: 12}

MethodDeclarationDTO: { methodDeclarationId: 23, name: init, belongedClassId: 5 }
ReturnMapperDto: { returnMapperId: 19, methodDeclId: 23,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 24, name: play, belongedClassId: 5 }
ReturnMapperDto: { returnMapperId: 20, methodDeclId: 24,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 25, name: retry, belongedClassId: 5 }
ReturnMapperDto: { returnMapperId: 21, methodDeclId: 25,type: boolean,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 26, name: generate, belongedClassId: 6 }
ReturnMapperDto: { returnMapperId: 22, methodDeclId: 26,type: List<Integer>,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 27, name: generate, belongedClassId: 7 }
ReturnMapperDto: { returnMapperId: 23, methodDeclId: 27,type: List<Integer>,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 28, name: getTotalCount, belongedClassId: 8 }
ReturnMapperDto: { returnMapperId: 24, methodDeclId: 28,type: int,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 29, name: getStrikeCount, belongedClassId: 8 }
ReturnMapperDto: { returnMapperId: 25, methodDeclId: 29,type: int,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 30, name: getBallCount, belongedClassId: 8 }
ReturnMapperDto: { returnMapperId: 26, methodDeclId: 30,type: int,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 31, name: GameStatus, belongedClassId: 10 }
ReturnMapperDto: { returnMapperId: null, methodDeclId: null,type: null,typeClassId: null}

MethodDeclarationDTO: { methodDeclarationId: 32, name: getCode, belongedClassId: 10 }
ReturnMapperDto: { returnMapperId: 27, methodDeclId: 32,type: Integer,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 33, name: printNowLine, belongedClassId: 11 }
ReturnMapperDto: { returnMapperId: 28, methodDeclId: 33,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 34, name: printNewLine, belongedClassId: 11 }
ReturnMapperDto: { returnMapperId: 29, methodDeclId: 34,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 35, name: Computer, belongedClassId: 12 }
ReturnMapperDto: { returnMapperId: null, methodDeclId: null,type: null,typeClassId: null}

MethodDeclarationDTO: { methodDeclarationId: 36, name: createAnswerWithRandom, belongedClassId: 12 }
ReturnMapperDto: { returnMapperId: 30, methodDeclId: 36,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 37, name: createAnswerWithFixed, belongedClassId: 12 }
ReturnMapperDto: { returnMapperId: 31, methodDeclId: 37,type: void,typeClassId: 0}

MethodDeclarationDTO: { methodDeclarationId: 38, name: getAnswer, belongedClassId: 12 }
ReturnMapperDto: { returnMapperId: 32, methodDeclId: 38,type: List<Integer>,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 39, name: generate, belongedClassId: 13 }
ReturnMapperDto: { returnMapperId: 33, methodDeclId: 39,type: List<Integer>,typeClassId: -1}

MethodDeclarationDTO: { methodDeclarationId: 40, name: 고정넘버생성\_Test, belongedClassId: 14 }
ReturnMapperDto: { returnMapperId: 34, methodDeclId: 40,type: void,typeClassId: 0}

MethodCallExprDTO: { methodCallExprId: 1, name: play, NameExpr: game, NameExprDeclarationId: 24 }

MethodCallExprDTO: { methodCallExprId: 2, name: isBaseballGameSize, NameExpr: , NameExprDeclarationId: 5 }

MethodCallExprDTO: { methodCallExprId: 3, name: isMatch, NameExpr: , NameExprDeclarationId: 6 }

MethodCallExprDTO: { methodCallExprId: 4, name: buildNumbers, NameExpr: , NameExprDeclarationId: 8 }

MethodCallExprDTO: { methodCallExprId: 5, name: clearSet, NameExpr: , NameExprDeclarationId: 9 }

MethodCallExprDTO: { methodCallExprId: 6, name: matches, NameExpr: input, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 7, name: parseInt, NameExpr: Integer, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 8, name: isExist, NameExpr: , NameExprDeclarationId: 7 }

MethodCallExprDTO: { methodCallExprId: 9, name: contains, NameExpr: numberSet, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 10, name: add, NameExpr: numberSet, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 11, name: collect, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 12, name: boxed, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 13, name: mapToInt, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 14, name: stream, NameExpr: Arrays, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 15, name: toList, NameExpr: Collectors, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 16, name: clear, NameExpr: numberSet, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 17, name: next, NameExpr: scanner, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 18, name: matches, NameExpr: code, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 19, name: parseInt, NameExpr: Integer, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 20, name: split, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 21, name: next, NameExpr: scanner, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 22, name: getNothing, NameExpr: , NameExprDeclarationId: 18 }

MethodCallExprDTO: { methodCallExprId: 23, name: getThreeStrike, NameExpr: , NameExprDeclarationId: 16 }

MethodCallExprDTO: { methodCallExprId: 24, name: getBall, NameExpr: , NameExprDeclarationId: 19 }

MethodCallExprDTO: { methodCallExprId: 25, name: getStrike, NameExpr: , NameExprDeclarationId: 20 }

MethodCallExprDTO: { methodCallExprId: 26, name: createAnswerWithRandom, NameExpr: computer, NameExprDeclarationId: 36 }

MethodCallExprDTO: { methodCallExprId: 27, name: getCode, NameExpr: , NameExprDeclarationId: 32 }

MethodCallExprDTO: { methodCallExprId: 28, name: init, NameExpr: , NameExprDeclarationId: 23 }

MethodCallExprDTO: { methodCallExprId: 29, name: equals, NameExpr: gameStatus, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 30, name: getCode, NameExpr: , NameExprDeclarationId: 32 }

MethodCallExprDTO: { methodCallExprId: 31, name: printNewLine, NameExpr: output, NameExprDeclarationId: 34 }

MethodCallExprDTO: { methodCallExprId: 32, name: toString, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 33, name: getAnswer, NameExpr: computer, NameExprDeclarationId: 38 }

MethodCallExprDTO: { methodCallExprId: 34, name: printNowLine, NameExpr: output, NameExprDeclarationId: 33 }

MethodCallExprDTO: { methodCallExprId: 35, name: getInputNumberToPlay, NameExpr: Message, NameExprDeclarationId: 14 }

MethodCallExprDTO: { methodCallExprId: 36, name: getNumber, NameExpr: input, NameExprDeclarationId: 12 }

MethodCallExprDTO: { methodCallExprId: 37, name: generateNumbers, NameExpr: player, NameExprDeclarationId: 4 }

MethodCallExprDTO: { methodCallExprId: 38, name: printNewLine, NameExpr: output, NameExprDeclarationId: 34 }

MethodCallExprDTO: { methodCallExprId: 39, name: toString, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 40, name: getNumbers, NameExpr: player, NameExprDeclarationId: 3 }

MethodCallExprDTO: { methodCallExprId: 41, name: getStrikeCount, NameExpr: judgement, NameExprDeclarationId: 29 }

MethodCallExprDTO: { methodCallExprId: 42, name: getAnswer, NameExpr: computer, NameExprDeclarationId: 38 }

MethodCallExprDTO: { methodCallExprId: 43, name: getNumbers, NameExpr: player, NameExprDeclarationId: 3 }

MethodCallExprDTO: { methodCallExprId: 44, name: getBallCount, NameExpr: judgement, NameExprDeclarationId: 30 }

MethodCallExprDTO: { methodCallExprId: 45, name: getAnswer, NameExpr: computer, NameExprDeclarationId: 38 }

MethodCallExprDTO: { methodCallExprId: 46, name: getNumbers, NameExpr: player, NameExprDeclarationId: 3 }

MethodCallExprDTO: { methodCallExprId: 47, name: getStatus, NameExpr: Message, NameExprDeclarationId: 15 }

MethodCallExprDTO: { methodCallExprId: 48, name: printNewLine, NameExpr: output, NameExprDeclarationId: 34 }

MethodCallExprDTO: { methodCallExprId: 49, name: equals, NameExpr: status, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 50, name: getThreeStrike, NameExpr: Message, NameExprDeclarationId: 16 }

MethodCallExprDTO: { methodCallExprId: 51, name: retry, NameExpr: , NameExprDeclarationId: 25 }

MethodCallExprDTO: { methodCallExprId: 52, name: init, NameExpr: , NameExprDeclarationId: 23 }

MethodCallExprDTO: { methodCallExprId: 53, name: getCode, NameExpr: , NameExprDeclarationId: 32 }

MethodCallExprDTO: { methodCallExprId: 54, name: println, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 55, name: println, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 56, name: println, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 57, name: printNewLine, NameExpr: output, NameExprDeclarationId: 34 }

MethodCallExprDTO: { methodCallExprId: 58, name: getRetry, NameExpr: Message, NameExprDeclarationId: 17 }

MethodCallExprDTO: { methodCallExprId: 59, name: getRetry, NameExpr: input, NameExprDeclarationId: 11 }

MethodCallExprDTO: { methodCallExprId: 60, name: getCode, NameExpr: , NameExprDeclarationId: 32 }

MethodCallExprDTO: { methodCallExprId: 61, name: size, NameExpr: randomNumberList, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 62, name: nextInt, NameExpr: random, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 63, name: contains, NameExpr: randomNumberList, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 64, name: add, NameExpr: randomNumberList, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 65, name: asList, NameExpr: Arrays, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 66, name: collect, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 67, name: filter, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 68, name: stream, NameExpr: inputNumber, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 69, name: contains, NameExpr: computer, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 70, name: toList, NameExpr: Collectors, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 71, name: println, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 72, name: count, NameExpr: , NameExprDeclarationId: -100 }

MethodCallExprDTO: { methodCallExprId: 73, name: filter, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 74, name: stream, NameExpr: inputNumber, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 75, name: size, NameExpr: inputNumber, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 76, name: equals, NameExpr: Objects, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 77, name: get, NameExpr: computer, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 78, name: get, NameExpr: inputNumber, NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 79, name: getTotalCount, NameExpr: , NameExprDeclarationId: 28 }

MethodCallExprDTO: { methodCallExprId: 80, name: getStrikeCount, NameExpr: , NameExprDeclarationId: 29 }

MethodCallExprDTO: { methodCallExprId: 81, name: print, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 82, name: println, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 83, name: start, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 84, name: println, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 85, name: generate, NameExpr: randomNumberGenerator, NameExprDeclarationId: 26 }

MethodCallExprDTO: { methodCallExprId: 86, name: generate, NameExpr: fixedNumberGenerator, NameExprDeclarationId: 27 }

MethodCallExprDTO: { methodCallExprId: 87, name: createAnswerWithFixed, NameExpr: computer, NameExprDeclarationId: 37 }

MethodCallExprDTO: { methodCallExprId: 88, name: assertEquals, NameExpr: , NameExprDeclarationId: -100 }

MethodCallExprDTO: { methodCallExprId: 89, name: toString, NameExpr: , NameExprDeclarationId: -1 }

MethodCallExprDTO: { methodCallExprId: 90, name: getAnswer, NameExpr: computer, NameExprDeclarationId: 38 }
걸린 시간:: 630
