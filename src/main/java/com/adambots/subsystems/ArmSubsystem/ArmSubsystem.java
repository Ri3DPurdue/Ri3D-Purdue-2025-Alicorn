// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.adambots.subsystems.ArmSubsystem;

import com.adambots.Constants;
import com.adambots.Gamepad.Buttons;
import com.adambots.utils.Dash;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  SparkMax armMotor = new SparkMax(Constants.ArmConstants.armMotorID, MotorType.kBrushless);
  SparkMax wristMotor =  new SparkMax(Constants.ArmConstants.wristMotorID, MotorType.kBrushless);
  SparkMax intakeMotor = new SparkMax(Constants.ArmConstants.intakeMotorID, MotorType.kBrushless);
  SparkMax climberMotor = new SparkMax(Constants.ArmConstants.climberMotorID, MotorType.kBrushed);
  private SparkClosedLoopController armController, wristController;
  private RelativeEncoder armEncoder, wristEncoder;

  

  
  public ArmSubsystem() {

    armController = armMotor.getClosedLoopController();
    wristController = wristMotor.getClosedLoopController();
    
    armEncoder = armMotor.getEncoder();
    wristEncoder = wristMotor.getEncoder();

    SparkMaxConfig armMotorConfig = new SparkMaxConfig();

    armMotorConfig.encoder.positionConversionFactor(1).velocityConversionFactor(1);
    armMotorConfig.closedLoop
      .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
      .p(Constants.ArmConstants.ARM_CONTROLLER_P)
      .i(Constants.ArmConstants.ARM_CONTROLLER_I)
      .d(Constants.ArmConstants.ARM_CONTROLLER_D)
      .outputRange(-1, 1);

    armMotor.configure(armMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    
    SparkMaxConfig wristMotorConfig = new SparkMaxConfig();

    wristMotorConfig.encoder.positionConversionFactor(1).velocityConversionFactor(1);
    wristMotorConfig.closedLoop
      .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
      .p(Constants.ArmConstants.WRIST_CONTROLLER_P)
      .i(Constants.ArmConstants.WRIST_CONTROLLER_I)
      .d(Constants.ArmConstants.WRIST_CONTROLLER_D)
      .outputRange(-1, 1);

    wristMotor.configure(wristMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);  
    Dash.add("arm encoder", ()-> armEncoder.getPosition());
  }

  public void setPosition(double armPosition, double wristPosition){
    setArmPosition(armPosition);
    setWristPosition(wristPosition);
  }

  public void setArmPosition(double armPosition){
    armController.setReference(armPosition, ControlType.kPosition);
  }

  public void setWristPosition(double wristPosition){
    wristController.setReference(wristPosition, ControlType.kPosition);
  }

  public void setIntakePower(double power){
    intakeMotor.set(power);
  }

  public void setClimberPower(double power){
    climberMotor.set(power);
  }
  @Override
  public void periodic() {
System.out.println(armEncoder.getPosition());
    SmartDashboard.putNumber("Wrist Position", wristEncoder.getPosition());
  }
}
