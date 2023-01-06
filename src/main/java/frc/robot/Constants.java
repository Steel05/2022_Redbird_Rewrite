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
    public static final int CONTROLLER_DRIVER = 0;
    public static final int CONTROLLER_OPERATOR = 1;

    /* Drivetrain */
        // IDs
    public static final int DRIVETRAIN_LEFTMOTOR_ONE = 1;
    public static final int DRIVETRAIN_LEFTMOTOR_TWO = 2;
    public static final int DRIVETRAIN_LEFTMOTOR_THREE = 3;
    public static final int DRIVETRAIN_RIGHTMOTOR_ONE = 4;
    public static final int DRIVETRAIN_RIGHTMOTOR_TWO = 5;
    public static final int DRIVETRAIN_RIGHTMOTOR_THREE = 6;
    public static final int DRIVETRAIN_GYRO_ID = 0;
        
        // Chassis Values
    public static final double DRIVETRAIN_CHASSIS_WIDTHINCHES = 24;
    public static final double DRIVETRAIN_CHASSIS_GEARING_MOTORTOWHEEL = 6.81;
    public static final double DRIVETRAIN_CHASSIS_WHEEL_RADIUSINCHES = 3;
    public static final double DRIVETRAIN_CHASSIS_WHEEL_CIRCUMFRENCEINCHES = DRIVETRAIN_CHASSIS_WHEEL_RADIUSINCHES * 3.141592653589;

        // Control Values
    public static final double DRIVETRAIN_RAMPTIME_SECONDS = 0.5;
    public static final double DRIVETRAIN_AUTO_PERCENTSPEED = 0.5;

    /* Shooter */
        // Motor IDs
    public static final int SHOOTER_MASTERMOTOR = 7;
    public static final int SHOOTER_FOLLOWERMOTOR = 8;

        // Piston IDs
    public static final int SHOOTER_HOODPISTON_ID = 14;
    public static final int SHOOTER_HOODPISTON_CHANNEL_FORWARD = 2;
    public static final int SHOOTER_HOODPISTON_CHANNEL_REVERSE = 3;

    // RPM
    public static final int SHOOTER_IDLERPM = 500;
    public static final int SHOOTER_SHOOTRPM_LOW = 5000;
    public static final int SHOOTER_SHOOTRPM_MID = 4400;
    public static final int SHOOTER_SHOOTRPM_HIGH = 5100;
    public static final int SHOOTER_SHOOTRPM_VERYHIGH = 6250;

        //PID values
    public static final double SHOOTER_kP = 0.2;
    public static final double SHOOTER_kI = 0;
    public static final double SHOOTER_kD = 0;
    public static final double SHOOTER_kF = 0;

    /* Collector */
        // Motor IDs
    public static final int COLLECTOR_MOTOR = 11;

        // Piston IDs
    public static final int COLLECTOR_EXTENDPISTON_ID = 14;
    public static final int COLLECTOR_EXTENDPISTON_CHANNEL_FORWARD = 0;
    public static final int COLLECTOR_EXTENDPISTON_CHANNEL_REVERSE = 1;

        // Control Values
    public static final double COLLECTOR_MOTOR_PERCENTSPEED = 0.4;

    /* Indexer */
        // Motor IDs
    public static final int INDEXER_MOTOR_INDEXER = 13;
    public static final int INDEXER_MOTOR_FEEDER = 12;

        // Control Values
    public static final double INDEXER_MOTOR_PERCENTSPEED = 0.7;

    /* Compressor */
        // IDs
    public static final int COMPRESSOR_ID = 14;
        // Control Values
    public static final double COMPRESSOR_RANGE_MIN = 60;
    public static final double COMPRESSOR_RANGE_MAX = 120;
}
