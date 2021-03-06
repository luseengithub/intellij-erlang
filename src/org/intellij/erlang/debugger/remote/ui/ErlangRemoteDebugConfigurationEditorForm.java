/*
 * Copyright 2012-2015 Sergey Ignatov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.erlang.debugger.remote.ui;

import com.intellij.application.options.ModulesComboBox;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.ui.HideableTitledPanel;
import org.intellij.erlang.debugger.remote.ErlangRemoteDebugRunConfiguration;
import org.intellij.erlang.module.ErlangModuleType;
import org.intellij.erlang.runconfig.ui.ErlangDebuggableRunConfigurationEditor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ErlangRemoteDebugConfigurationEditorForm extends ErlangDebuggableRunConfigurationEditor<ErlangRemoteDebugRunConfiguration> {
  private JPanel myComponent;
  private ModulesComboBox myModuleComboBox;
  private JTextField myNodeTextField;
  private JTextField myCookieTextField;
  private JCheckBox myUseShortNamesCheckBox;
  private HideableTitledPanel myDebugOptionsPanel;
  private JTextField myHostTextField;
  private JLabel myHostLabel;
  private JTextField myDebugNodeArgsTextField;

  public ErlangRemoteDebugConfigurationEditorForm() {
    myUseShortNamesCheckBox.addItemListener(e -> setUseShortNames(myUseShortNamesCheckBox.isSelected()));
  }

  @Override
  protected void doResetEditorFrom(ErlangRemoteDebugRunConfiguration configuration) {
    myModuleComboBox.fillModules(configuration.getProject(), ErlangModuleType.getInstance());
    myModuleComboBox.setSelectedModule(configuration.getConfigurationModule().getModule());
    myNodeTextField.setText(configuration.getRemoteErlangNodeName());
    myCookieTextField.setText(configuration.getCookie());
    myUseShortNamesCheckBox.setSelected(configuration.isUseShortNames());
    myHostTextField.setText(configuration.getHost());
    myDebugNodeArgsTextField.setText(configuration.getDebugNodeArgs());
    setUseShortNames(myUseShortNamesCheckBox.isSelected());
  }

  @Override
  protected void doApplyEditorTo(ErlangRemoteDebugRunConfiguration configuration) throws ConfigurationException {
    configuration.setModule(myModuleComboBox.getSelectedModule());
    configuration.setRemoteErlangNodeName(myNodeTextField.getText());
    configuration.setCookie(myCookieTextField.getText());
    configuration.setUseShortNames(myUseShortNamesCheckBox.isSelected());
    configuration.setHost(myHostTextField.getText());
    configuration.setDebugNodeArgs(myDebugNodeArgsTextField.getText());
  }

  @NotNull
  @Override
  protected JComponent createEditor() {
    return myComponent;
  }

  private void createUIComponents() {
    myDebugOptionsPanel = createDebugOptionsHideablePanel();
    myDebugOptionsPanel.setOn(true);
  }

  private void setUseShortNames(boolean b) {
    myHostLabel.setVisible(!b);
    myHostTextField.setVisible(!b);
  }
}
