package org.robot;
import com.diozero.devices.motor.CamJamKitDualMotor;
import com.diozero.util.SleepUtil;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
/**
 * Robot control
 *
 */
public class App implements NativeKeyListener
{
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        try(CamJamKitDualMotor torvalds = new CamJamKitDualMotor()) {
            if (e.getKeyCode() == NativeKeyEvent.VC_UP) {
                torvalds.rotateRight(1); // Forward
               SleepUtil.sleepSeconds(1);
               torvalds.stop();
               SleepUtil.sleepSeconds(1);
            }
            if (e.getKeyCode() == NativeKeyEvent.VC_DOWN) {

                torvalds.rotateLeft(1); // Backward
                SleepUtil.sleepSeconds(1);
                torvalds.stop();
                SleepUtil.sleepSeconds(1);

            }
            if (e.getKeyCode() == NativeKeyEvent.VC_LEFT) {

                torvalds.forward(1); // Left
                SleepUtil.sleepSeconds(0.3);
                torvalds.stop();
                SleepUtil.sleepSeconds(1);
            }
            if (e.getKeyCode() == NativeKeyEvent.VC_RIGHT) {
                torvalds.backward(1); // Right
                SleepUtil.sleepSeconds(0.5);
                torvalds.stop();
                SleepUtil.sleepSeconds(1);
            }
            if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
                try {
                    GlobalScreen.unregisterNativeHook();
                } catch (NativeHookException nativeHookException) {
                    nativeHookException.printStackTrace();
                }
            }
        }


    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new App());
    }
}
