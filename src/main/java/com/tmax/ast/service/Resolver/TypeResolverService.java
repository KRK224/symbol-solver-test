package com.tmax.ast.service.Resolver;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.UnsolvedSymbolException;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.tmax.ast.dto.ClassDTO;
import com.tmax.ast.dto.MethodCallExprDTO;
import com.tmax.ast.dto.MethodDeclarationDTO;
import com.tmax.ast.dto.ParameterDTO;
import com.tmax.ast.dto.ReturnMapperDTO;
import com.tmax.ast.dto.VariableDeclarationDTO;
import com.tmax.ast.service.Resolver.dto.HashcodeDto;

public class TypeResolverService {

  private final TypeMapper<MethodDeclarationDTO, MethodCallExprDTO> methodTypeMapper = new TypeMapper<>();
  private final TypeMapper<ClassDTO, VariableDeclarationDTO> variableTypeMapper = new TypeMapper<>();
  private final TypeMapper<ClassDTO, ReturnMapperDTO> returnTypeMapper = new TypeMapper<>();
  private final TypeMapper<ClassDTO, ParameterDTO> parameterTypeMapper = new TypeMapper<>();

  private static final TypeSolver reflectionSolver = new ReflectionTypeSolver();

  public MethodDeclarationDTO getOriginMdDTO(String hashcode) {
    try {
      return methodTypeMapper.getOriginDto(hashcode);
    } catch (Exception e) {
      return null;
    }
  }

  public ClassDTO getOriginClassDto(String hashcode, String typeName) {
    try {
      if (typeName == "MemberVariableDeclarationDTO" || typeName == "StmtVariableDeclarationDTO") {
        return variableTypeMapper.getOriginDto(hashcode);
      } else if (typeName == "ReturnMapperDTO") {
        return returnTypeMapper.getOriginDto(hashcode);
      } else if (typeName == "ParameterDTO") {
        return parameterTypeMapper.getOriginDto(hashcode);
      }
      System.out.println("타입 이름을 검증하는데 실패했습니다!!" + typeName);
      return null;
    } catch (Exception e) {
      return null;
    }
  }

  public void addMethodDeclarationDto(String hashcode, MethodDeclarationDTO md) {
    if (methodTypeMapper.setOriginDto(hashcode, md)) {
      System.out.println("addMethodDeclaration:: 성공적으로 등록되었습니다!");
    } else {
      System.out.println("addMethodDeclaration:: 에러가 발생되었습니다.");
    }
  }

  // add ClassDto to Variable Type Mapper
  public void addClassDtoToVTM(String hashcode, ClassDTO c) {
    if (variableTypeMapper.setOriginDto(hashcode, c)) {
      System.out.println("addClassDto:: 성공적으로 등록되었습니다!");
    } else {
      System.out.println("addClassDto:: 에러가 발생되었습니다.");
    }
  }

  // add ClassDto to Return Type Mapper
  public void addClassDtoToRTM(String hashcode, ClassDTO c) {
    if (returnTypeMapper.setOriginDto(hashcode, c)) {
      System.out.println("addClassDto:: 성공적으로 등록되었습니다!");
    } else {
      System.out.println("addClassDto:: 에러가 발생되었습니다.");
    }
  }

  // add ClassDto to Parameter Type Mapper
  public void addClassDtoToPTM(String hashcode, ClassDTO c) {
    if (parameterTypeMapper.setOriginDto(hashcode, c)) {
      System.out.println("addClassDto:: 성공적으로 등록되었습니다!");
    } else {
      System.out.println("addClassDto:: 에러가 발생되었습니다.");
    }
  }

  // Origin DTO가 없을때 등록하는 과정
  public void addRefMethodCallDto(String hashcode, MethodCallExprDTO mce) {
    if (methodTypeMapper.addReferenceDto(hashcode, mce)) {
      System.out.println("addRefMethodCall:: 성공적으로 등록되었습니다!");
    } else {
      System.out.println("addRefMethodCall:: 에러가 발생되었습니다.");
    }
  }

  public void addRefVariableDto(String hashcode, VariableDeclarationDTO vd) {
    if (variableTypeMapper.addReferenceDto(hashcode, vd)) {
      System.out.println("addRefVariable:: 성공적으로 등록되었습니다!");
    } else {
      System.out.println("addRefVariable:: 에러가 발생되었습니다.");
    }
  }

  public void addRefReturnDto(String hashcode, ReturnMapperDTO rmd) {
    if (returnTypeMapper.addReferenceDto(hashcode, rmd)) {
      System.out.println("addRefReturn:: 성공적으로 등록되었습니다!");
    } else {
      System.out.println("addRefReturn:: 에러가 발생되었습니다.");
    }
  }

  public void addRefParameterDto(String hashcode, ParameterDTO pd) {
    if (parameterTypeMapper.addReferenceDto(hashcode, pd)) {
      System.out.println("addRefParameter:: 성공적으로 등록되었습니다!");
    } else {
      System.out.println("addRefParameter:: 에러가 발생되었습니다.");
    }
  }

  // MethodDeclarationMapper List에 id 등록
  public void registerOriginMethodDeclarationId(String hashcode) throws Exception {
    System.out.println("register Origin MethodDeclaration Id - start");
    if (!methodTypeMapper.isOrignDtoExist(hashcode) || !methodTypeMapper.isRefDtoListExist(hashcode)) {
      String errorMessage = "등록할 DTO 또는 참조 리스트가 존재하지 않습니다.";
      System.out.println(errorMessage);
      // Exception e = new Exception(errorMessage);
      // throw e;
      return;
    }
    System.out.println("register Origin MethodDeclaration Id - (1)");
    Long registeredId = methodTypeMapper.getOriginDto(hashcode).getMethodDeclId();
    System.out.println(registeredId);

    System.out.println("register Origin MethodDeclaration Id - (2)");
    List<MethodCallExprDTO> tempList = methodTypeMapper.getRefDtoList(hashcode);
    List<MethodCallExprDTO> newList = tempList.stream().map(mce -> {
      mce.setNameExprTypeClassId(registeredId);
      return mce;
    }).toList();

    System.out.println("register Origin MethodDeclaration Id - (3)");
    methodTypeMapper.setRefDtoList(hashcode, newList);
    System.out.println("register Origin MethodDeclaration Id - end");
  }

  // VariableTypeMapper List에 id 등록
  public void registerOriginClassIdToVTM(String hashcode) throws Exception {
    System.out.println("register Origin Class Id - start");
    if (!variableTypeMapper.isOrignDtoExist(hashcode) || !variableTypeMapper.isRefDtoListExist(hashcode)) {
      String errorMessage = "등록할 DTO 또는 참조 리스트가 존재하지 않습니다.";
      System.out.println(errorMessage);
      // Exception e = new Exception(errorMessage);
      // throw e;
      return;
    }

    System.out.println("register Origin Class Id - (1)");
    Long registeredId = variableTypeMapper.getOriginDto(hashcode).getClassId();
    System.out.println(registeredId);

    System.out.println("register Origin Class Id - (2)");
    List<VariableDeclarationDTO> tempList = variableTypeMapper.getRefDtoList(hashcode);
    List<VariableDeclarationDTO> newList = tempList.stream().map(vd -> {
      vd.setTypeClassId(registeredId);
      return vd;
    }).toList();
    System.out.println("register Origin Class Id - (3)");
    variableTypeMapper.setRefDtoList(hashcode, newList);
    System.out.println("register Origin Class Id - end");
  }

  // ReturnTypeMapper List에 id 등록
  public void registerOriginClassIdToRTM(String hashcode) throws Exception {
    System.out.println("register Origin Class Id - start");
    if (!returnTypeMapper.isOrignDtoExist(hashcode) || !returnTypeMapper.isRefDtoListExist(hashcode)) {
      String errorMessage = "등록할 DTO 또는 참조 리스트가 존재하지 않습니다.";
      System.out.println(errorMessage);
      // Exception e = new Exception(errorMessage);
      // throw e;
      return;
    }

    System.out.println("register Origin Class Id - (1)");
    Long registeredId = returnTypeMapper.getOriginDto(hashcode).getClassId();
    System.out.println(registeredId);

    System.out.println("register Origin Class Id - (2)");
    List<ReturnMapperDTO> tempList = returnTypeMapper.getRefDtoList(hashcode);
    List<ReturnMapperDTO> newList = tempList.stream().map(vd -> {
      vd.setTypeClassId(registeredId);
      return vd;
    }).toList();
    System.out.println("register Origin Class Id - (3)");
    returnTypeMapper.setRefDtoList(hashcode, newList);
    System.out.println("register Origin Class Id - end");
  }

  // ParameterTypeMapper List에 id 등록
  public void registerOriginClassIdToPTM(String hashcode) throws Exception {
    System.out.println("register Origin Class Id - start");
    if (!parameterTypeMapper.isOrignDtoExist(hashcode) || !parameterTypeMapper.isRefDtoListExist(hashcode)) {
      String errorMessage = "등록할 DTO 또는 참조 리스트가 존재하지 않습니다.";
      System.out.println(errorMessage);
      // Exception e = new Exception(errorMessage);
      // throw e;
      return;
    }

    System.out.println("register Origin Class Id - (1)");
    Long registeredId = parameterTypeMapper.getOriginDto(hashcode).getClassId();
    System.out.println(registeredId);

    System.out.println("register Origin Class Id - (2)");
    List<ParameterDTO> tempList = parameterTypeMapper.getRefDtoList(hashcode);
    List<ParameterDTO> newList = tempList.stream().map(vd -> {
      vd.setTypeClassId(registeredId);
      return vd;
    }).toList();
    System.out.println("register Origin Class Id - (3)");
    parameterTypeMapper.setRefDtoList(hashcode, newList);
    System.out.println("register Origin Class Id - end");
  }

  /**
   * JDK or JRE package인지 확인
   * 
   * @param packageName
   * @return
   */

  private static boolean isJdkPackage(String packageName) {
    try {
      reflectionSolver.solveType(packageName);
      return true;
    } catch (UnsolvedSymbolException e) {
      System.out.println("우리가 정의한 레퍼런스 타입입니다:: " + packageName);
      return false;
    }
  }

  // MethodCallExpr에서 MethodDeclaration을 가져오는 작업
  public static HashcodeDto getMethodCallHashCode(MethodCallExpr mce) {
    HashcodeDto hashcodeDto = new HashcodeDto();
    try {
      String mdQualifiedName = mce.resolve().getQualifiedName();
      String hashcodeName = mdQualifiedName + "#" + mce.resolve().toAst().hashCode();

      // 임시용
      String mdQualifiedSignature = mce.resolve().getQualifiedSignature();
      String hashcodeSignature = mdQualifiedSignature + "#" + mce.resolve().toAst().hashCode();

      hashcodeDto.setHashcode(hashcodeName);
      hashcodeDto.setIsResolved(true);
      hashcodeDto.setType("md");

      return hashcodeDto;
    } catch (UnsolvedSymbolException e) {
      hashcodeDto.setIsResolved(false);
      return hashcodeDto;
    }
  }

  // Todo. 두 개 합쳐서 리팩토링 해보기
  public static HashcodeDto getClassHashcode(VariableDeclarationExpr vde) {
    HashcodeDto hashcodeDto = new HashcodeDto();
    try {
      ResolvedType varType = vde.getVariable(0).getType().resolve();
      hashcodeDto.setIsResolved(true);
      if (varType.isReference()) { // 레퍼런스 타입인지 확인

        if (varType.isArray()) { // 배열 값인지 확인
          hashcodeDto.setIsArray(true);
          return hashcodeDto;
        }

        // 배열이 아니면서 레퍼런스 타입인 변수
        String classWithPackage = varType.asReferenceType().getQualifiedName();

        // 우선 typeParameter가 존재하는지 체크
        if (!varType.asReferenceType().typeParametersValues().isEmpty()) {
          hashcodeDto.setHasTypeParameter(true);
        }

        if (isJdkPackage(classWithPackage)) { // jdk package인 경우
          hashcodeDto.setType("jdk");
          return hashcodeDto;
        } else { // 우리가 만든 패키지
          hashcodeDto.setType("reference");
          String hashcode = classWithPackage + "#"
              + varType.asReferenceType().hashCode();
          hashcodeDto.setHashcode(hashcode);
          return hashcodeDto;
        }
      } else {
        hashcodeDto.setType("primitive");
        return hashcodeDto;
      }

    } catch (UnsolvedSymbolException e) {
      return hashcodeDto;
    }
  }

  public static HashcodeDto getClassHashcode(FieldDeclaration fd) {
    HashcodeDto hashcodeDto = new HashcodeDto();
    try {
      ResolvedType fdType = fd.getVariable(0).getType().resolve();
      hashcodeDto.setIsResolved(true);
      if (fdType.isReference()) { // 레퍼런스 타입인지 확인

        if (fdType.isArray()) { // 배열 값인지 확인
          hashcodeDto.setIsArray(true);
          return hashcodeDto;
        }

        // 배열이 아니면서 레퍼런스 타입인 변수
        String classWithPackage = fdType.asReferenceType().getQualifiedName();

        // 우선 typeParameter가 존재하는지 체크
        if (!fdType.asReferenceType().typeParametersValues().isEmpty()) {
          hashcodeDto.setHasTypeParameter(true);
        }

        if (isJdkPackage(classWithPackage)) { // jdk package인 경우
          hashcodeDto.setType("jdk");
          return hashcodeDto;
        } else { // 우리가 만든 패키지
          hashcodeDto.setType("reference");
          String hashcode = classWithPackage + "#"
              + fdType.asReferenceType().hashCode();
          hashcodeDto.setHashcode(hashcode);
          return hashcodeDto;
        }
      } else {
        hashcodeDto.setType("primitive");
        return hashcodeDto;
      }

    } catch (UnsolvedSymbolException e) {
      return hashcodeDto;
    }
  }

  public static HashcodeDto getReturnTypeHashcode(MethodDeclaration md) {
    HashcodeDto hashcodeDto = new HashcodeDto();
    try {
      ResolvedType resolvedReturnType = md.resolve().getReturnType();
      hashcodeDto.setIsResolved(true);
      if (resolvedReturnType.isReference()) {
        if (resolvedReturnType.isArray()) {// 배열인지 확인
          hashcodeDto.setIsArray(true);
          return hashcodeDto;
        }
        // 배열이 아니면서 레퍼런스 타입인 변수
        String classWithPackage = resolvedReturnType.asReferenceType().getQualifiedName();

        // 우선 typeParameter가 존재하는지 체크
        if (!resolvedReturnType.asReferenceType().typeParametersValues().isEmpty()) {
          hashcodeDto.setHasTypeParameter(true);
        }

        if (isJdkPackage(classWithPackage)) { // jdk package인 경우
          hashcodeDto.setType("jdk");
          return hashcodeDto;
        } else { // 우리가 만든 패키지
          hashcodeDto.setType("reference");
          String hashcode = classWithPackage + "#"
              + resolvedReturnType.asReferenceType().hashCode();
          hashcodeDto.setHashcode(hashcode);
          return hashcodeDto;
        }

      } else {
        hashcodeDto.setType("primitive");
        return hashcodeDto;
      }
    } catch (UnsolvedSymbolException e) {
      return hashcodeDto;
    }
  }

  public static List<HashcodeDto> getParameterHashcodeList(MethodDeclaration md) {
    List<HashcodeDto> returnList = new ArrayList<HashcodeDto>();
    try {
      return returnList;
    } catch (UnsolvedSymbolException e) {
      return returnList;
    }

  }

  private static HashcodeDto getParameterHashcode(Parameter pm) {
    HashcodeDto hashcodeDto = new HashcodeDto();
    try {
      return hashcodeDto;
    } catch (UnsolvedSymbolException e) {
      return hashcodeDto;
    }
  }

  private static HashcodeDto getHashcodeByResolvedType(ResolvedType rt) {
    try {
      HashcodeDto hashcodeDto = new HashcodeDto();
      if (rt.isReference()) {
        if (rt.isArray()) {// 배열인지 확인
          hashcodeDto.setIsArray(true);
          return hashcodeDto;
        }
        // 배열이 아니면서 레퍼런스 타입인 변수
        String classWithPackage = rt.asReferenceType().getQualifiedName();

        // 우선 typeParameter가 존재하는지 체크
        if (!rt.asReferenceType().typeParametersValues().isEmpty()) {
          hashcodeDto.setHasTypeParameter(true);
        }

        if (isJdkPackage(classWithPackage)) { // jdk package인 경우
          hashcodeDto.setType("jdk");
          return hashcodeDto;
        } else { // 우리가 만든 패키지
          hashcodeDto.setType("reference");
          String hashcode = classWithPackage + "#"
              + rt.asReferenceType().hashCode();
          hashcodeDto.setHashcode(hashcode);
          return hashcodeDto;
        }

      } else {
        hashcodeDto.setType("primitive");
        return hashcodeDto;
      }

    } catch (Exception e) {
      System.out.println("HashcodeDto 생성 중에 문제가 발생했습니다:::" + e.getMessage());
      return new HashcodeDto();
    }
  }

  // 참조가 될 OriginDTO 등록 과정
  public <T> void registerOriginDto(String myOwnHashcode, T dto) {

    String typeName = dto.getClass().getTypeName();
    System.out.println("현재 들어온 typeName::: " + typeName);

    switch (typeName) {
      case "MethodDeclarationDTO":
        addMethodDeclarationDto(myOwnHashcode, (MethodDeclarationDTO) dto);
        break;
      case "ClassDTO":
        addClassDtoToPTM(myOwnHashcode, (ClassDTO) dto);
        addClassDtoToRTM(myOwnHashcode, (ClassDTO) dto);
        addClassDtoToVTM(myOwnHashcode, (ClassDTO) dto);
        break;
      default:
        System.out.println("현재 타입은 등록할 수 없는 Origin Type입니다!!!");
    }
  }

  // Ref를 리스트에 넣는 과정
  public <T> void registerRefDto(HashcodeDto hashcodeDto, T someRefDto) throws Exception {
    String typeName = someRefDto.getClass().getTypeName();
    String hashcodeType = hashcodeDto.getType();
    String hashcode = hashcodeDto.getHashcode();

    // primitive와 jdk값에 대한 검증
    if (hashcodeType == "primitive") {
      System.out.println("타입이 primitive 값입니다.");
      return;
    } else if (hashcodeType == "jdk") {
      System.out.println("타입이 jdk 레퍼런스 입니다.");
      switch (typeName) {
        case "MemberVariableDeclarationDTO":
        case "StmtVariableDeclarationDTO":
          // 주소 값 복사 후 지정
          VariableDeclarationDTO tempVd = (VariableDeclarationDTO) someRefDto;
          tempVd.setTypeClassId((long) -1);
          break;
        case "ReturnMapperDTO":
          ReturnMapperDTO tempRm = (ReturnMapperDTO) someRefDto;
          tempRm.setTypeClassId((long) -1);
          break;
        case "ParameterDTO":
          ParameterDTO tempPm = (ParameterDTO) someRefDto;
          tempPm.setTypeClassId((long) -1);
          break;
        default:
          System.out.println("RefDTO의 타입 검증에 실패했습니다.:::" + typeName);
      }
    }
    // Resolve 실패한 경우
    if (!hashcodeDto.getIsResolved()) {
      System.out.println("symbolSolver가 찾을 수 없는 값입니다!");
      switch (typeName) {
        case "MemberVariableDeclarationDTO":
        case "StmtVariableDeclarationDTO":
          // 주소 값 복사 후 지정
          VariableDeclarationDTO tempVd = (VariableDeclarationDTO) someRefDto;
          tempVd.setTypeClassId((long) -100);
          break;
        case "ReturnMapperDTO":
          ReturnMapperDTO tempRm = (ReturnMapperDTO) someRefDto;
          tempRm.setTypeClassId((long) -100);
          break;
        case "ParameterDTO":
          ParameterDTO tempPm = (ParameterDTO) someRefDto;
          tempPm.setTypeClassId((long) -100);
          break;
        default:
          System.out.println("RefDTO의 타입 검증에 실패했습니다.:::" + typeName);
      }
      return;
    }

    if (hashcodeDto.getIsArray()) {
      System.out.println("배열 타입입니다!!");
      switch (typeName) {
        case "MemberVariableDeclarationDTO":
        case "StmtVariableDeclarationDTO":
          // 주소 값 복사 후 지정
          VariableDeclarationDTO tempVd = (VariableDeclarationDTO) someRefDto;
          tempVd.setTypeClassId((long) -10);
          break;
        case "ReturnMapperDTO":
          ReturnMapperDTO tempRm = (ReturnMapperDTO) someRefDto;
          tempRm.setTypeClassId((long) -10);
          break;
        case "ParameterDTO":
          ParameterDTO tempPm = (ParameterDTO) someRefDto;
          tempPm.setTypeClassId((long) -10);
          break;
        default:
          System.out.println("RefDTO의 타입 검증에 실패했습니다.:::" + typeName);
      }
      return;
    }

    // resolve가 성공한 경우만

    // 함수 호출의 원형 찾았을 경우,
    if (hashcodeType == "md") {
      MethodDeclarationDTO originMdDto = getOriginMdDTO(hashcode);

      // 현재 등록된 MdDto가 있다.
      if (originMdDto != null) {
        Long typeClassId = originMdDto.getMethodDeclId();
        MethodCallExprDTO tempMceDto = (MethodCallExprDTO) someRefDto;
        tempMceDto.setNameExprTypeClassId(typeClassId);
      } else { // 현재 등록된 MdDto가 없는 경우, 등록 후 종료
        addRefMethodCallDto(hashcode, (MethodCallExprDTO) someRefDto);
      }
    } else { // 나머지는 모두 ClassId
      ClassDTO originClassDto = getOriginClassDto(hashcode, typeName);

      if (typeName == "MemberVariableDeclarationDTO" || typeName == "StmtVariableDeclarationDTO") {
        VariableDeclarationDTO tempVdDto = (VariableDeclarationDTO) someRefDto;
        if (originClassDto != null) {
          Long typeClassId = originClassDto.getClassId();
          tempVdDto.setTypeClassId(typeClassId);
        } else {
          addRefVariableDto(hashcode, tempVdDto);
        }
      } else if (typeName == "ReturnMapperDTO") {
        ReturnMapperDTO tempRmDto = (ReturnMapperDTO) someRefDto;
        if (originClassDto != null) {
          Long typeClassId = originClassDto.getClassId();
          tempRmDto.setTypeClassId(typeClassId);
        } else {
          addRefReturnDto(hashcode, tempRmDto);
        }

      } else if (typeName == "ParameterDTO") {
        ParameterDTO tempPmDto = (ParameterDTO) someRefDto;
        if (originClassDto != null) {
          Long typeClassId = originClassDto.getClassId();
          tempPmDto.setTypeClassId(typeClassId);
        } else {
          addRefParameterDto(hashcode, tempPmDto);
        }
      }

    }

  }

}
