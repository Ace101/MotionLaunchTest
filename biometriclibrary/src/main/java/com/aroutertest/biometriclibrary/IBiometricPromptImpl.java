package com.aroutertest.biometriclibrary;

import android.os.CancellationSignal;
import android.support.annotation.NonNull;

/**
 * @author zhangshihao
 * @date 2018/12/14 0014
 */
public interface IBiometricPromptImpl {
    void authenticate(@NonNull CancellationSignal cancel,
                      @NonNull BiometricPromptManager.OnBiometricIdentifyCallback callback);
}
