package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    public Drivetrain() {}
    
    private final VictorSPX leftVictors = new VictorSPX(Constants.leftDrivetrain);
    private final VictorSPX rightVictors = new VictorSPX(Constants.rightDrivetrain);

    
    public void drive(Double leftY, Double rightY) {
        // newVictor.set(ControlMode.PercentOutput, leftY*Constants.motorPower);
        // newVictor1.set(ControlMode.PercentOutput, leftY*Constants.motorPower);
        // newVictor2.set(ControlMode.PercentOutput, rightY*Constants.motorPower);
        // newVictor3.set(ControlMode.PercentOutput, rightY*Constants.motorPower);

        leftVictors.set(ControlMode.PercentOutput, leftY*Constants.motorPower);
        rightVictors.set(ControlMode.PercentOutput, -rightY*Constants.motorPower);
    
    }
 
    
    @Override
    public void periodic() {
        
    }
    
}