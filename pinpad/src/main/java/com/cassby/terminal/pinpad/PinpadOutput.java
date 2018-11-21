package com.cassby.terminal.pinpad;

public interface PinpadOutput {
    void didSubmitCode(String code);
    void didPressBack();
}
