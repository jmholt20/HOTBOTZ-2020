/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.auto.*;
import frc.robot.commands.pneumatics.*;
import frc.robot.commands.swerve.*;
import frc.robot.triggers.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    
    public static Joystick joy1 = new Joystick(0);
        Trigger lowSpeed = new JoystickButton(joy1, RobotMap.Controller.LEFT_TRIGGER);
        Trigger highSpeed = new JoystickButton(joy1, RobotMap.Controller.RIGHT_TRIGGER);
        Button lockSwerve = new JoystickButton(joy1, RobotMap.Controller.A);
        Button fieldOrient = new JoystickButton(joy1, RobotMap.Controller.RIGHT_BUMPER);
        Button gyroReset = new JoystickButton(joy1, RobotMap.Controller.LEFT_BUMPER);
        Button tilt = new JoystickButton(joy1,RobotMap.Controller.tilt);
        // Button runAuto = new JoystickButton(joy1, RobotMap.Controller.B);
        Button controllerAutoLift = new JoystickButton(joy1, RobotMap.Controller.Y);


        public static Joystick joy2 = new Joystick(1);
        Trigger endClimb = new EndAuto();
        Button lowLift = new JoystickButton(joy2, RobotMap.Logitech.low);
        Button highLift = new JoystickButton(joy2, RobotMap.Logitech.high);
        // Button midposition = new JoystickButton(joy2, RobotMap.Logitech.mid);
        // Button tilt = new JoystickButton(joy2,RobotMap.Logitech.tilt);
        Button balltilt = new JoystickButton(joy2,RobotMap.Logitech.balltilt);
        Button legs = new JoystickButton(joy2, RobotMap.Logitech.leg);
        // Button liftup = new JoystickButton(joy2, RobotMap.Logitech.up);
        // Button liftdown = new JoystickButton(joy2, RobotMap.Logitech.down);
        Button autolift = new JoystickButton(joy2, RobotMap.Logitech.autolift);

    public OI() {
        lowSpeed.whenActive(new SwerveSetLowSpeed());
        highSpeed.whenActive(new SwerveSetHighSpeed());
        lockSwerve.whenPressed(new SwerveLock());
        fieldOrient.whenPressed(new SwerveSetField());
        gyroReset.whenPressed(new SwerveGyroReset());
        //lowLift.whenReleased(new lowliftsolenoidreverse());
        
        lowLift.whenActive(new lowliftsolenoid());
        highLift.whenActive(new highliftsolenoid());
        // midposition.whenPressed(new LiftMid());
        tilt.toggleWhenPressed(new tiltsolenoid());
        legs.whenPressed(new LEG());
        // legs.whenPressed(new autoLift());
        balltilt.whenPressed(new balltiltsolenoid());

        //legs.whenReleased(new LEGsolenoidreverse());
        // liftup.whenActive(new up());
        // liftdown.whenActive(new down());

    }

    public boolean getClimbButton() {
        return joy2.getRawButtonReleased(2);
    }
}