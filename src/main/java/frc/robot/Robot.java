package frc.robot;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
import frc.robot.commands.auto.PathTesting;
import frc.robot.profiling.PathFollower;
import frc.robot.profiling.PathTracking;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;


public class Robot extends TimedRobot {
    public static SwerveDrive swerve;
    public static Gyro navxGyro;
    public static PathTracking path;
    public static PathFollower follower;
    public static Command autoCommand;
    public static OI oi;
    public static Pneumatics pneumatics;
   
    
    // public static PowerDistributionPanel pdp;

    public void robotInit() {

        navxGyro = new Gyro();
        swerve = new SwerveDrive(navxGyro); 
        // path = new PathTracking(swerve, navxGyro);
        pneumatics = new Pneumatics();
        
        follower = new PathFollower();
        autoCommand = new PathTesting();
        oi = new OI();
    
    }

    @Override
    public void robotPeriodic() {
        //path.update();
        swerve.smartDash(); 
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Pitch", navxGyro.getRoll() - .9);
        SmartDashboard.putNumber("Pressure", navxGyro.getPressure());
        SmartDashboard.putNumber("PressureVoltage", navxGyro.getPressureVoltage());


        // SmartDashboard.putBoolean("topSwitch", );
    }

    @Override
    public void autonomousInit() {
        // path.reset();

        // autoCommand.start();
        // pneumatics.lowIn();
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        //swerve.smartDash();
        
        // swerve.targetAngle = navxGyro.getPitch();

        // pneumatics.lowOut();
    }

    @Override
    public void teleopPeriodic() {
        
        Scheduler.getInstance().run();
    
    }

    @Override
    public void disabledInit() {
        
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }
}
