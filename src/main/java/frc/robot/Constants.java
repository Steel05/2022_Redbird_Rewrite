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
    /* Controllers */
        // IDs
    //public static final int CONTROLLER_DRIVER = 0;
    public static final int CONTROLLER_OPERATOR = 0;
        // Operator
            // Axis IDs
    public static final int OPERATOR_REVAXIS = 2;

    /* Shooter */
        // Motor IDs
    public static final int SHOOTER_MASTERMOTOR = 7;
    public static final int SHOOTER_FOLLOWERMOTOR = 8;

        // RPM
    public static final int SHOOTER_IDLERPM = 500;
    public static final int SHOOTER_SHOOTRPM_LOW = 5000;
    public static final int SHOOTER_SHOOTRPM_MID = 4400;
    public static final int SHOOTER_SHOOTRPM_HIGH = 5100;

        //PID values
    public static final double SHOOTER_kP = 0.2;
    public static final double SHOOTER_kI = 0;
    public static final double SHOOTER_kD = 0;
    public static final double SHOOTER_kF = 0;
}