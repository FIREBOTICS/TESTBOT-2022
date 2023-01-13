// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Drivetrain
    public static int leftDrivetrain = 1;
    public static int rightDrivetrain = 2;
    public static Double motorPower = 0.75;  
    
    // Controller Ports
    public static int Xbox0 = 0;
    // public static int XboxController1 = 1;

    public static int solenoidChannel = 0;
    public static int dSChannelForward = 1;
    public static int dSChannelBackward = 2;
  
}
