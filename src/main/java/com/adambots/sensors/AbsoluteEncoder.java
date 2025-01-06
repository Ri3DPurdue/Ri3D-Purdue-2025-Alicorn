/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.adambots.sensors;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;

/**
 * Generic Absolute Encoder sensor to hide actual implementation and ensure uniform values across subsystems
 */
public class AbsoluteEncoder {
    private AnalogEncoder encoder;
    private double offset;
    private double min_val;
    private double max_val;
    
    public AbsoluteEncoder (int port, double offset, double min_val, double max_val){
        this.encoder = new AnalogEncoder(port); //Defining the encoder using the port passed in
        this.offset = offset;
        this.min_val = min_val;
        this.max_val = max_val;
    }

    public double getUnoffsetPositionDegrees() {
        return encoder.get() * 360.0;
    }

    /**
     * Returns the discrete (does not continue past 360) value of the encoder in degrees
     * @return Discrete value of encoder in degrees
     */
    public double getAbsolutePositionDegrees () {
      ///   return ((double)encoder.getAverageValue()/4096.0*360.0+offset);//-min_val)/(max_val-min_val)*360+offset;
     /// return (double) encoder.getAverageVoltage()/RobotController.getVoltage5V()*360+offset;
        return encoder.get()*360+offset;
    }

    /**
     * Returns the discrete (does not continue past 2pi) value of the encoder in radians
     * @return Discrete value of encoder in radians
     */
    public double getAbsolutePositionRadians () {
        return Units.degreesToRadians(getAbsolutePositionDegrees());
    }

    /**
     * Returns the discrete (does not continue past 2pi) value of the encoder in radians
     * @return Discrete value of encoder in radians
     */
    public Rotation2d getAbsolutePositionRotation2D () {
        return new Rotation2d(Units.degreesToRadians(getAbsolutePositionDegrees()));
    }
}
