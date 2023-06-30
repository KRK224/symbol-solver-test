package com.tmax.ast.service.Resolver;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.resolution.TypeSolver;
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

  private static TypeResolverService trs = new TypeResolverService();
  private static final TypeSolver reflectionSolver = new ReflectionTypeSolver();

  // hide Constructor
  private TypeResolverService() {
  }

  // singletonregister 'Origin' Dto to TypeMapper Service 시작!:::::::
  public static TypeResolverService getInstance() {
    return trs;
  }

  // clear all the TypeMapper
  public static void clear() {
    // System.out.println("Clear 전의 TypeResolverService Instance:: " + trs);
    trs = new TypeResolverService();
    // System.out.println("Clear 후의 TypeResolverService Instance:: " + trs);
  }

  public static <T> String getMyHashcode(T node) {
    String[] typeNameList = node.getClass().getTypeName().split("\\.");
    String typeName = typeNameList[typeNameList.length - 1];
    if (typeName.equals("MethodDeclaration")) {
      MethodDeclaration tempMd = (MethodDeclaration) node;
      String hashcode = tempMd.resolve().getQualifiedSignature();
      // String classWithPackage = tempMd.resolve().getQualifiedName();
      // String hashcode = classWithPackage + "#" + tempMd.hashCode();
      return hashcode;
    } else if (typeName.equals("ClassOrInterfaceDeclaration")) {
      ClassOrInterfaceDeclaration tempCID = (ClassOrInterfaceDeclaration) node;
      // String classWithPackage = tempCID.resolve().getQualifiedName();
      // String hashcode = classWithPackage + "#" + tempCID.hashCode();
      String hashcode = tempCID.resolve().getQualifiedName();
      System.out.println("Class type 자기 자신 등록할 때 생성한 hashcode::getQualifiedName() " + hashcode);
      return hashcode;
    }
    return "";
  }

  public MethodDeclarationDTO getOriginMdDTO(String hashcode) {
    try {
      return methodTypeMapper.getOriginDto(hashcode);
    } catch (Exception e) {
      return null;
    }
  }

  public ClassDTO getOriginClassDto(String hashcode, String typeName) {
    try {
      if (typeName.equals("MemberVariableDeclarationDTO") || typeName.equals("StmtVariableDeclarationDTO")) {
        return variableTypeMapper.getOriginDto(hashcode);
      } else if (typeName.equals("ReturnMapperDTO")) {
        return returnTypeMapper.getOriginDto(hashcode);
      } else if (typeName.equals("ParameterDTO")) {
        return parameterTypeMapper.getOriginDto(hashcode);
      }
      System.out.println("타입 이름을 검증하는데 실패했습니다!! typeName:: " + typeName);
      System.out.println("타입 이름을 검증하는데 실패했습니다!! hashCode::" + hashcode);
      return null;
    } catch (Exception e) {
      return null;
    }
  }

  private void addMethodDeclarationDto(String hashcode, MethodDeclarationDTO md) {
    if (methodTypeMapper.setOriginDto(hashcode, md)) {
      System.out.println("set Origin MethodDeclarationDto to Method TypeMapper, 성공적으로 등록되었습니다!:: " + hashcode);
    } else {
      System.out.println("set Origin MethodDeclarationDto to Method TypeMapper, 에러가 발생되었습니다.::" + hashcode);
    }
  }

  // add ClassDto to Variable Type Mapper
  private void addClassDtoToVTM(String hashcode, ClassDTO c) {
    if (variableTypeMapper.setOriginDto(hashcode, c)) {
      System.out.println("set Origin ClassDto to Variable TypeMapper, 성공적으로 등록되었습니다!:: " + hashcode);
    } else {
      System.out.println("set Origin ClassDto to Variable TypeMapper:: 에러가 발생되었습니다:: " + hashcode);
    }
  }

  // add ClassDto to Return Type Mapper
  private void addClassDtoToRTM(String hashcode, ClassDTO c) {
    if (returnTypeMapper.setOriginDto(hashcode, c)) {
      System.out.println("set Origin ClassDto to Return TypeMapper, 성공적으로 등록되었습니다!:: " + hashcode);
    } else {
      System.out.println("set Origin ClassDto to Return TypeMapper:: 에러가 발생되었습니다:: " + hashcode);
    }
  }

  // add ClassDto to Parameter Type Mapper
  private void addClassDtoToPTM(String hashcode, ClassDTO c) {
    if (parameterTypeMapper.setOriginDto(hashcode, c)) {
      System.out.println("set Origin ClassDto to Parameter TypeMapper, 성공적으로 등록되었습니다!:: " + hashcode);
    } else {
      System.out.println("set Origin ClassDto to Parameter TypeMapper:: 에러가 발생되었습니다:: " + hashcode);
    }
  }

  // ----------------------------------------------------------------

  // Origin DTO가 없을때 등록하는 과정
  private void addRefMethodCallDto(String hashcode, MethodCallExprDTO mce) {
    if (methodTypeMapper.addReferenceDto(hashcode, mce)) {
      System.out.println("add Reference 'MethodCallExprDto' to Method TypeMapper, 성공적으로 등록되었습니다!:: " + hashcode);
    } else {
      System.out.println("add Reference 'MethodCallExprDto' to Method TypeMapper, 에러가 발생되었습니다!:: " + hashcode);
    }
  }

  private void addRefVariableDto(String hashcode, VariableDeclarationDTO vd) {
    if (variableTypeMapper.addReferenceDto(hashcode, vd)) {
      System.out.println("add Reference 'VariableDeclartionDto' to Variable TypeMapper, 성공적으로 등록되었습니다!:: " + hashcode);
    } else {
      System.out.println("add Reference 'VariableDeclartionDto' to Variable TypeMapper, 에러가 발생되었습니다!!:: " + hashcode);
    }
  }

  private void addRefReturnDto(String hashcode, ReturnMapperDTO rmd) {
    if (returnTypeMapper.addReferenceDto(hashcode, rmd)) {
      System.out.println("add Reference 'ReturnMapperDto' to Return TypeMapper, 성공적으로 등록되었습니다!:: " + hashcode);
    } else {
      System.out.println("add Reference 'ReturnMapperDto' to Return TypeMapper, 에러가 발생되었습니다!!:: " + hashcode);
    }
  }

  private void addRefParameterDto(String hashcode, ParameterDTO pd) {
    if (parameterTypeMapper.addReferenceDto(hashcode, pd)) {
      System.out.println("add Reference 'ParameterDto' to Parameter TypeMapper, 성공적으로 등록되었습니다!:: " + hashcode);
    } else {
      System.out.println("add Reference 'ParameterDto' to Parameter TypeMapper, 에러가 발생되었습니다!!:: " + hashcode);
    }
  }

  // MethodDeclarationMapper의 Ref List에 Origin id 등록
  public void registerOriginMethodDeclarationId(String hashcode) {
    try {
      System.out.println();
      System.out.println("register Origin MethodDeclaration Id - start:: " + hashcode);
      if (!methodTypeMapper.isOrignDtoExist(hashcode) || !methodTypeMapper.isRefDtoListExist(hashcode)) {
        String errorMessage = "등록할 DTO 또는 참조 리스트가 존재하지 않습니다.";
        System.out.println(errorMessage);
        // Exception e = new Exception(errorMessage);
        // throw e;
        return;
      }
      Long registeredId = methodTypeMapper.getOriginDto(hashcode).getMethodDeclId();
      System.out.println("register Origin MethodDeclaration Id - (1) registeredId:: " + registeredId);

      System.out.println("register Origin MethodDeclaration Id - (2) setNameExprTypeClassId");
      List<MethodCallExprDTO> tempList = methodTypeMapper.getRefDtoList(hashcode);
      List<MethodCallExprDTO> newList = tempList.stream().map(mce -> {
        mce.setNameExprTypeClassId(registeredId);
        System.out.println("iterator안에서 확인 " + mce);
        System.out.println("iterator안에서 확인 " + mce.getNameExprTypeClassId());
        return mce;
      }).toList();

      System.out.println("register Origin MethodDeclaration Id - (3) newList methodTypeMapper에 등록:: " + newList);
      methodTypeMapper.setRefDtoList(hashcode, newList);
      System.out.println("register Origin MethodDeclaration Id - end");
    } catch (Exception e) {
      System.out.println("메소드 선언 Id를 List에 저장 중 에러 발생::: " + e.getMessage());
    }
  }

  // VariableTypeMapper List에 id 등록
  public void registerOriginClassIdToVTM(String hashcode) {
    try {
      System.out.println();
      System.out.println("register Origin Class Id to VTM- start:: " + hashcode);
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
    } catch (Exception e) {
      System.out.println("ClassId를 멤버&지역 변수 List에 저장 중 에러 발생::: " + e.getMessage());
    }
  }

  // ReturnTypeMapper List에 id 등록
  public void registerOriginClassIdToRTM(String hashcode) {
    try {
      System.out.println();
      System.out.println("register Origin Class Id to RTM- start:: " + hashcode);
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
    } catch (Exception e) {
      System.out.println("ClassId를 리턴타입 List에 저장 중 에러 발생::: " + e.getMessage());
    }
  }

  // ParameterTypeMapper List에 id 등록
  public void registerOriginClassIdToPTM(String hashcode) {
    try {
      System.out.println();
      System.out.println("register Origin Class Id to PTM- start:: " + hashcode);
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
      System.out.println("register Origin Class Id - end:: " + hashcode);
    } catch (Exception e) {
      System.out.println("ClassId를 파라미터 List에 저장 중 에러 발생::: " + e.getMessage());
    }
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
    } catch (Exception e) {
      System.out.println("우리가 정의한 레퍼런스 타입입니다:: " + packageName);
      return false;
    }
  }

  // MethodCallExpr에서 MethodDeclaration을 가져오는 작업
  public static HashcodeDto generateMethodDeclarationHashCode(MethodCallExpr mce) {

    try {
      // 임시로 Signature인 것도 추출
      String mdQualifiedSignature = mce.resolve().getQualifiedSignature();
      // hashcode int와 함께 생성
      // String hashcodeSignature = mdQualifiedSignature + "#" +
      // mce.resolve().toAst().hashCode();

      // resolve된 정보 추출
      String mdQualifiedName = mce.resolve().getQualifiedName();
      String packageClassName = mce.resolve().getPackageName() + "." + mce.resolve().getClassName();
      // hashcode int와 함께 생성
      // String hashcodeName = mdQualifiedName + "#" +
      // mce.resolve().toAst().hashCode();

      // return hashcode dto 생성
      HashcodeDto hashcodeDto = new HashcodeDto();
      hashcodeDto.setType("md");
      hashcodeDto.setIsResolved(true);

      // Jdk Package인 경우, 타입 변경후 종료
      if (isJdkPackage(packageClassName)) {
        hashcodeDto.setType("jdk");
        return hashcodeDto;
      }

      // hashcodeDto.setHashcode(hashcodeName);
      hashcodeDto.setHashcode(mdQualifiedSignature);
      return hashcodeDto;
    } catch (Exception e) {
      return new HashcodeDto();
    }
  }

  public static HashcodeDto generateClassHashcode(VariableDeclarationExpr vde) {

    try {
      ResolvedType varType = vde.getVariable(0).getType().resolve();
      return generateHashcodeByResolvedType(varType);

    } catch (Exception e) {
      return new HashcodeDto();
    }
  }

  public static HashcodeDto generateClassHashcode(FieldDeclaration fd) {

    try {
      ResolvedType fdType = fd.getVariable(0).getType().resolve();
      return generateHashcodeByResolvedType(fdType);

    } catch (Exception e) {
      return new HashcodeDto();
    }
  }

  public static HashcodeDto generateReturnTypeHashcode(MethodDeclaration md) {
    try {
      ResolvedType resolvedReturnType = md.resolve().getReturnType();
      return generateHashcodeByResolvedType(resolvedReturnType);
    } catch (Exception e) {
      // 에러 발생 시 null DTO 전달
      return new HashcodeDto();
    }
  }

  public static List<HashcodeDto> generateParameterHashcodeList(MethodDeclaration md) {
    List<HashcodeDto> returnList = new ArrayList<HashcodeDto>();
    try {
      NodeList<Parameter> paramList = md.getParameters();
      for (Parameter param : paramList) {
        HashcodeDto currentHashcodeDto = generateParameterHashcode(param);
        returnList.add(currentHashcodeDto);
      }
      return returnList;
    } catch (Exception e) {
      return returnList;
    }

  }

  private static HashcodeDto generateParameterHashcode(Parameter pm) {
    try {
      ResolvedType resolvedParameterType = pm.resolve().getType();
      return generateHashcodeByResolvedType(resolvedParameterType);
    } catch (Exception e) {
      return new HashcodeDto();
    }
  }

  // 각 유형별 Node타입에서 관심있는 타입의 resolvedType 추출 후 수행
  private static HashcodeDto generateHashcodeByResolvedType(ResolvedType rt) {
    try {
      HashcodeDto hashcodeDto = new HashcodeDto();
      hashcodeDto.setIsResolved(true);
      if (rt.isReference()) { // 레퍼런스 타입인지 확인
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
          // String hashcode = classWithPackage + "#"
          // + rt.asReferenceType().hashCode();
          String hashcode = rt.asReferenceType().getQualifiedName();
          System.out.println("Class Type의 Origin Hashcode 생성 ::: getQualifiedName " + hashcode);
          hashcodeDto.setHashcode(hashcode);
          return hashcodeDto;
        }

      } else { // primitive 타입으로 종료
        hashcodeDto.setType("primitive");
        return hashcodeDto;
      }

    } catch (Exception e) {
      System.out.println("HashcodeDto 생성 중에 문제가 발생했습니다:::" + e.getMessage());
      return new HashcodeDto();
    }
  }

  // 참조가 될 OriginDTO 등록 과정
  public <T> void registerOriginDtoService(String myOwnHashcode, T dto) {
    System.out.println();
    System.out.println("register 'Origin' Dto to TypeMapper Service 시작!::::::: " + myOwnHashcode);
    String[] typeNameList = dto.getClass().getTypeName().split("\\.");
    String typeName = typeNameList[typeNameList.length - 1];
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

  // Ref DTO를 리스트에 넣는 과정
  public <T> void registerRefDtoService(HashcodeDto hashcodeDto, T someRefDto) {
    System.out.println();
    System.out.println("add 'Reference' Dto to TypeMapper Service 시작!::::::: " + hashcodeDto + hashcodeDto.getType());
    String[] typeNameList = someRefDto.getClass().getTypeName().split("\\.");
    String typeName = typeNameList[typeNameList.length - 1];
    String hashcodeType = hashcodeDto.getType();
    String hashcode = hashcodeDto.getHashcode();

    // Resolve 실패한 경우 -100
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
        case "MethodCallExprDTO":
          MethodCallExprDTO tempMce = (MethodCallExprDTO) someRefDto;
          tempMce.setNameExprTypeClassId((long) -100);
          break;
        default:
          System.out.println("GetIsResolved - RefDTO의 타입 검증에 실패했습니다.:::" + typeName);
      }
      return;
    }

    // 배열인 경우 -10
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
          System.out.println("GetIsArray - RefDTO의 타입 검증에 실패했습니다.:::" + typeName);
      }
      return;
    }

    // resolve가 성공한 경우만

    // primitive와 jdk값에 대한 검증
    if (hashcodeType.equals("primitive")) {
      System.out.println("타입이 primitive 값입니다.");
      return;
    } else if (hashcodeType.equals("jdk")) { // -1
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
        case "MethodCallExprDTO":
          MethodCallExprDTO tempMce = (MethodCallExprDTO) someRefDto;
          tempMce.setNameExprTypeClassId((long) -1);
          break;
        default:
          System.out.println("RefDTO의 타입 검증에 실패했습니다.:::" + typeName);
      }
      return;
    }

    // 함수 호출의 원형을 찾았을 경우,
    if (hashcodeType.equals("md")) {
      MethodDeclarationDTO originMdDto = getOriginMdDTO(hashcode);

      // 현재 등록된 MdDto가 있다.
      if (originMdDto != null) {
        Long typeClassId = originMdDto.getMethodDeclId();
        MethodCallExprDTO tempMceDto = (MethodCallExprDTO) someRefDto;
        tempMceDto.setNameExprTypeClassId(typeClassId);
        System.out
            .println("함수 호출의 Origin DTO가 존재하여 등록합니다!:: \n" + typeClassId + "\n" + originMdDto.getName());
      } else { // 현재 등록된 MdDto가 없는 경우, 등록 후 종료
        addRefMethodCallDto(hashcode, (MethodCallExprDTO) someRefDto);
      }
      return;
    } else { // 나머지는 모두 ClassId
      System.out.println("origin id to ref start::: hashcodeDto Type::: " + hashcodeType);
      ClassDTO originClassDto = getOriginClassDto(hashcode, typeName);

      if (typeName.equals("MemberVariableDeclarationDTO") || typeName.equals("StmtVariableDeclarationDTO")) {
        VariableDeclarationDTO tempVdDto = (VariableDeclarationDTO) someRefDto;
        if (originClassDto != null) {
          Long typeClassId = originClassDto.getClassId();
          tempVdDto.setTypeClassId(typeClassId);
          System.out
              .println("멤버 변수 or 지역 변수의 Origin DTO가 존재하여 등록합니다!:: \n" + typeClassId + "\n" + originClassDto.getName());
        } else {
          addRefVariableDto(hashcode, tempVdDto);
        }
      } else if (typeName.equals("ReturnMapperDTO")) {
        ReturnMapperDTO tempRmDto = (ReturnMapperDTO) someRefDto;
        if (originClassDto != null) {
          Long typeClassId = originClassDto.getClassId();
          tempRmDto.setTypeClassId(typeClassId);
          System.out
              .println(" Origin DTO가 존재하여 등록합니다!:: \n" + typeClassId + "\n" + originClassDto.getName());
        } else {
          addRefReturnDto(hashcode, tempRmDto);
        }

      } else if (typeName.equals("ParameterDTO")) {
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
