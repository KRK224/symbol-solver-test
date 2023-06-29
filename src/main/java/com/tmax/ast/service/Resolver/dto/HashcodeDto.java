package com.tmax.ast.service.Resolver.dto;

public class HashcodeDto {
  private String hashcode; // 찾은 origin의 구분값
  private boolean isResolved = false; // symbol solver로 찾았는지 확인
  private String type; // primitive, reference, jdk, md
  private boolean isArray = false; // 배열 값인지 확인 -> 배열이 가지고 있는 타입 추후에 넣을 수도
  private boolean hasTypeParameter = false; // <T> 값을 가지고 있는지 확인 -> 추후에 넣을 수도

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getHashcode() {
    return hashcode;
  }

  public void setHashcode(String hashcode) {
    this.hashcode = hashcode;
  }

  public boolean getIsResolved() {
    return isResolved;
  }

  public void setIsResolved(boolean isResolved) {
    this.isResolved = isResolved;
  }

  public boolean getIsArray() {
    return isArray;
  }

  public void setIsArray(boolean isArray) {
    this.isArray = isArray;
  }

  public boolean getHasTypeParameter() {
    return hasTypeParameter;
  }

  public void setHasTypeParameter(boolean hasTypeParameter) {
    this.hasTypeParameter = hasTypeParameter;
  }
}
