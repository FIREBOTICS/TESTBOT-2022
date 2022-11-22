package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    public Drivetrain() {}
    
    private final VictorSPX newVictor = new VictorSPX(2);
    private final VictorSPX newVictor2 = new VictorSPX(0);
  
    private final VictorSPX newVictor1 = new VictorSPX(1);
    private final VictorSPX newVictor3 = new VictorSPX(3);
  
    public void drive(Double leftY, Double rightY) {
        newVictor.set(ControlMode.PercentOutput, leftY*Constants.motorPower);
        newVictor1.set(ControlMode.PercentOutput, leftY*Constants.motorPower);
        newVictor2.set(ControlMode.PercentOutput, rightY*Constants.motorPower);
        newVictor3.set(ControlMode.PercentOutput, rightY*Constants.motorPower);
    
    }
 
    
    @Override
    public void periodic() {
        
    }
    
}