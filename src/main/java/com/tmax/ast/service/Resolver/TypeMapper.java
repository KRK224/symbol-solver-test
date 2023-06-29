package com.tmax.ast.service.Resolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TypeMapper<T, R> {
  // Todo. 1) 하나의 hashcode에 OriginDTO, RefDTOList 등록하도록 수정
  // Todo. 2) RefDTOList또한 다양한 타입의 List를 멤버로 갖는 객체 구조 고안
  private HashMap<String, T> originDtoHashMap = new HashMap<String, T>();
  private HashMap<String, List<R>> referenceDtoListHashMap = new HashMap<String, List<R>>();

  // 생성자
  public TypeMapper() {

  }

  public T getOriginDto(String hashcode) throws Exception {
    if (!isOrignDtoExist(hashcode)) {
      Exception e = new Exception("해당 DTO가 존재하지 않습니다.");
      throw e;
    }
    return originDtoHashMap.get(hashcode);
  }

  public List<R> getRefDtoList(String hashcode) throws Exception {
    if (!isRefDtoListExist(hashcode)) {
      Exception e = new Exception("참조 DTO 리스트가 존재하지 않습니다.");
      throw e;
    }
    return referenceDtoListHashMap.get(hashcode);
  }

  public boolean setOriginDto(String hashcode, T originDto) {
    try {
      if (isOrignDtoExist(hashcode)) {
        System.out.println("중복된 OriginDto가 존재합니다:::");
        System.out.println(originDtoHashMap.get(hashcode));
        return false;
      }
      originDtoHashMap.put(hashcode, originDto);
      return true;
    } catch (Exception e) {
      System.out.println("setOriginDto error::: " + e.getMessage());
      return false;
    }
  }

  public boolean setRefDtoList(String hashcode, List<R> refDtoList) {
    try {
      referenceDtoListHashMap.put(hashcode, refDtoList);
      return true;
    } catch (Exception e) {
      System.out.println("setRefDtoList error::: " + e.getMessage());
      return false;
    }
  }

  public boolean addReferenceDto(String hashcode, R refDto) {
    try {
      // 현재 originType에 대한 refenceList 존재
      if (referenceDtoListHashMap.containsKey(hashcode)) {
        List<R> tempList = referenceDtoListHashMap.get(hashcode);
        tempList.add(refDto);
        // 참조 변수라서 put 안해도 바뀌는지 확인!
        // referenceDtoListHashMap.put(hashcode, tempList);
      } else {
        List<R> newList = new ArrayList<R>();
        newList.add(refDto);
        referenceDtoListHashMap.put(hashcode, newList);
      }
      return true;

    } catch (Exception e) {
      System.out.println("addReferenceDto" + e.getMessage());
      return false;
    }

  }

  public boolean isOrignDtoExist(String hashcode) {
    return originDtoHashMap.containsKey(hashcode);
  }

  public boolean isRefDtoListExist(String hashcode) {
    return referenceDtoListHashMap.containsKey(hashcode);
  }

}
