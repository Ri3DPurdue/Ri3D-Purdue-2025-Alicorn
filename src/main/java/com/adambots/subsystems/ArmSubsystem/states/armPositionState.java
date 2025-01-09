// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.adambots.subsystems.ArmSubsystem.states;

import com.adambots.subsystems.ArmSubsystem.ArmSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class armPositionState extends Command {
  /** Creates a new armPositionState. */
  ArmSubsystem arm;
  double armPosition, wristPosition;

  public armPositionState(ArmSubsystem arm, double armPosition, double wristPosition) {
    this.arm = arm;
    this.armPosition = armPosition;
    this.wristPosition = wristPosition;
    addRequirements(arm);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.setPosition(armPosition, wristPosition);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
