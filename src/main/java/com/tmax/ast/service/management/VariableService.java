package com.tmax.ast.service.management;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.type.Type;
import com.tmax.ast.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VariableService {

    private final List<MemberVariableDeclarationDTO> memberVariableDeclarationDTOList;
    private final List<StmtVariableDeclarationDTO> stmtVariableDeclarationDTOList;

    public VariableService() {
        this.memberVariableDeclarationDTOList = new ArrayList<>();
        this.stmtVariableDeclarationDTOList = new ArrayList<>();
    }

    public List<MemberVariableDeclarationDTO> getMemberVariableDeclarationDTOList() {
        return this.memberVariableDeclarationDTOList;
    }

    public List<StmtVariableDeclarationDTO> getStmtVariableDeclarationDTOList() {
        return this.stmtVariableDeclarationDTOList;
    }

    public void variableDeclarationListClear() {
        this.memberVariableDeclarationDTOList.clear();
        this.stmtVariableDeclarationDTOList.clear();
    }

    public void buildVariableDeclInMemberField(Long variableId, Long blockId, Long belongedClassId, Node node) {
        MemberVariableDeclarationDTO variableDeclarationDTO = new MemberVariableDeclarationDTO();
        FieldDeclaration fieldDeclaration = (FieldDeclaration) node;

        String modifierKeyword = "";
        String accessModifierKeyword = "";
        Type variableType = null;
        String type = "";
        String name = "";
        Optional<Expression> initializer = Optional.empty();

        // 변수 제어자
        NodeList<Modifier> modifiers = fieldDeclaration.getModifiers();
        for(Modifier modifier : modifiers) {
            // 접근 제어자 분별
            if(modifier.getKeyword().equals(Modifier.Keyword.DEFAULT) ||
                    modifier.getKeyword().equals(Modifier.Keyword.PUBLIC) ||
                    modifier.getKeyword().equals(Modifier.Keyword.PROTECTED) ||
                    modifier.getKeyword().equals(Modifier.Keyword.PRIVATE) ) {
                accessModifierKeyword = modifier.getKeyword().asString();
            } else {
                modifierKeyword = modifier.getKeyword().asString();
            }
        }
        // 변수 이름, 타입
        NodeList<VariableDeclarator> variableDeclarators = fieldDeclaration.getVariables();
        for(VariableDeclarator variableDeclarator : variableDeclarators) {
            variableType = variableDeclarator.getType();
            // type = variableType.getChildNodes().stream().collect(Collectors.toList()).toString();
            type = variableDeclarator.getType().asString();
            name = variableDeclarator.getName().asString();
            initializer = variableDeclarator.getInitializer();
        }

        variableDeclarationDTO.setVariableId(variableId);
        variableDeclarationDTO.setBlockId(blockId);
        variableDeclarationDTO.setBelongedClassId(belongedClassId);
        variableDeclarationDTO.setTypeClassId(0L);
        variableDeclarationDTO.setImportId(0L);
        variableDeclarationDTO.setVariableType(variableType);
        variableDeclarationDTO.setType(type);
        variableDeclarationDTO.setName(name);
        variableDeclarationDTO.setModifier(modifierKeyword);
        variableDeclarationDTO.setAccessModifier(accessModifierKeyword);
        variableDeclarationDTO.setInitializer(initializer);
        variableDeclarationDTO.setNode(node);
        variableDeclarationDTO.setPosition(
                new Position(
                        node.getRange().get().begin.line,
                        node.getRange().get().begin.column,
                        node.getRange().get().end.line,
                        node.getRange().get().end.column
                )
        );

        memberVariableDeclarationDTOList.add(variableDeclarationDTO);
    }

    public void buildVariableDeclInMethod(Long variableId, Long blockId, Node node) {
        StmtVariableDeclarationDTO variableDeclarationDTO = new StmtVariableDeclarationDTO();
        VariableDeclarationExpr variableDeclarationExpr = (VariableDeclarationExpr) node;

        String modifierKeyword = "";
        String accessModifierKeyword = "";
        Type variableType = null;
        String type = "";
        String name = "";
        Optional<Expression> initializer = Optional.empty();

        // 변수 제어자
        NodeList<Modifier> modifiers = variableDeclarationExpr.getModifiers();
        for(Modifier modifier : modifiers) {
            // 접근 제어자 분별
            if(modifier.getKeyword().equals(Modifier.Keyword.DEFAULT) ||
                    modifier.getKeyword().equals(Modifier.Keyword.PUBLIC) ||
                    modifier.getKeyword().equals(Modifier.Keyword.PROTECTED) ||
                    modifier.getKeyword().equals(Modifier.Keyword.PRIVATE) ) {
                accessModifierKeyword = modifier.getKeyword().asString();
            } else {
                modifierKeyword = modifier.getKeyword().asString();
            }
        }
        // 변수 이름, 타입
        NodeList<VariableDeclarator> variableDeclarators = variableDeclarationExpr.getVariables();
        for(VariableDeclarator variableDeclarator : variableDeclarators) {
            variableType = variableDeclarator.getType();
            // type = variableType.getChildNodes().stream().collect(Collectors.toList()).toString();
            type = variableDeclarator.getType().asString();
            name = variableDeclarator.getName().asString();
            initializer = variableDeclarator.getInitializer();
        }

        variableDeclarationDTO.setVariableId(variableId);
        variableDeclarationDTO.setBlockId(blockId);
        variableDeclarationDTO.setTypeClassId(0L);
        variableDeclarationDTO.setImportId(0L);
        variableDeclarationDTO.setVariableType(variableType);
        variableDeclarationDTO.setType(type);
        variableDeclarationDTO.setName(name);
        variableDeclarationDTO.setModifier(modifierKeyword);
        variableDeclarationDTO.setAccessModifier(accessModifierKeyword);
        variableDeclarationDTO.setInitializer(initializer);
        variableDeclarationDTO.setNode(node);
        variableDeclarationDTO.setPosition(
                new Position(
                        node.getRange().get().begin.line,
                        node.getRange().get().begin.column,
                        node.getRange().get().end.line,
                        node.getRange().get().end.column
                )
        );

        stmtVariableDeclarationDTOList.add(variableDeclarationDTO);
    }

}
