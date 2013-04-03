// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.erlang.ErlangTypes.*;
import org.intellij.erlang.psi.*;

public class ErlangImportFunctionsImpl extends ErlangCompositeElementImpl implements ErlangImportFunctions {

  public ErlangImportFunctionsImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<ErlangImportFunction> getImportFunctionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangImportFunction.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitImportFunctions(this);
    else super.accept(visitor);
  }

}