/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.adambots;

import java.util.HashMap;
import java.util.Map;

import com.adambots.Constants.DriveConstants;
import com.adambots.Constants.ModuleConstants;
import com.adambots.Constants.DriveConstants.ModulePosition;
import com.adambots.sensors.Gyro;
import com.adambots.subsystems.SwerveModule;

/**
 * Define all the devices here
 */
public class RobotMap {
    // PORTS Definition - This should be the only place to define all ports
    public static final int kRearLeftTurningEncoderPort = 3;
    public static final int kRearRightTurningEncoderPort = 2;
    public static final int kFrontLeftTurningEncoderPort = 0;
    public static final int kFrontRightTurningEncoderPort = 1;

    public static final int kFrontRightTurningMotorPort = 4;
    public static final int kFrontRightDriveMotorPort = 3;

    public static final int kRearRightTurningMotorPort = 6;
    public static final int kRearRightDriveMotorPort = 5;

    public static final int kRearLeftTurningMotorPort = 8;
    public static final int kRearLeftDriveMotorPort = 7;
    
    public static final int kFrontLeftTurningMotorPort = 2;
    public static final int kFrontLeftDriveMotorPort = 1;        

    // Operator Interface (Joystick and XBoxControllers)
    public static final int kJoystickControllerPort = 0;
    public static final int kPrimaryControllerPort = 1; // XBOX Controller
    public static final int kSecondaryControllerPort = 2; // XBOX Controller

    // Robot Devices and Sensors
    public static final Gyro gyro = new Gyro(0);

    // Robot Swerve Modules
    public static final HashMap<ModulePosition, SwerveModule> swerveModules = new HashMap<>(
        Map.of(
            ModulePosition.FRONT_LEFT,
            new SwerveModule(
                    ModulePosition.FRONT_LEFT,
                    RobotMap.kFrontLeftDriveMotorPort,
                    RobotMap.kFrontLeftTurningMotorPort,
                    RobotMap.kFrontLeftTurningEncoderPort,
                    DriveConstants.kFrontLeftDriveMotorReversed,
                    true,
                    ModuleConstants.kFrontLeftEncoderOffset,
                    ModuleConstants.kFrontLeftEncoderMinVal,
                    ModuleConstants.kFrontLeftEncoderMaxVal),
            ModulePosition.FRONT_RIGHT,
            new SwerveModule(
                    ModulePosition.FRONT_RIGHT,
                    RobotMap.kFrontRightDriveMotorPort,
                    RobotMap.kFrontRightTurningMotorPort,
                    RobotMap.kFrontRightTurningEncoderPort,
                    DriveConstants.kFrontRightDriveMotorReversed,
                    true,
                    ModuleConstants.kFrontRightEncoderOffset,
                    ModuleConstants.kFrontRightEncoderMinVal,
                    ModuleConstants.kFrontRightEncoderMaxVal),
            ModulePosition.REAR_LEFT,
            new SwerveModule(
                    ModulePosition.REAR_LEFT,
                    RobotMap.kRearLeftDriveMotorPort,
                    RobotMap.kRearLeftTurningMotorPort,
                    RobotMap.kRearLeftTurningEncoderPort,
                    DriveConstants.kRearLeftDriveMotorReversed,
                    true,
                    ModuleConstants.kRearLeftEncoderOffset,
                    ModuleConstants.kRearLeftEncoderMinVal,
                    ModuleConstants.kRearLeftEncoderMaxVal),
            ModulePosition.REAR_RIGHT,
            new SwerveModule(
                    ModulePosition.REAR_RIGHT,
                    RobotMap.kRearRightDriveMotorPort,
                    RobotMap.kRearRightTurningMotorPort,
                    RobotMap.kRearRightTurningEncoderPort,
                    DriveConstants.kRearRightDriveMotorReversed,
                    true,
                    ModuleConstants.kRearRightEncoderOffset,
                    ModuleConstants.kRearRightEncoderMinVal,
                    ModuleConstants.kRearRightEncoderMaxVal)   
        )
    );
}
