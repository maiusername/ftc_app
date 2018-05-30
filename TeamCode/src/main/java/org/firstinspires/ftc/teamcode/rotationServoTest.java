package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by mai on 2/7/18.
 *
 * negative values don't work for continuous rotation servos*************************
 */

public class rotationServoTest extends LinearOpMode{


   Servo s;

    public void runOpMode(){

        s = hardwareMap.servo.get("s");

        waitForStart();

        while(opModeIsActive()) {


            if (gamepad1.a == true) {//right
                s.setPosition(1);
            } else if (gamepad1.b == true) { // to the left
                s.setPosition(-1);
            } else if (gamepad1.x == true) {
                s.setPosition(.4);
            } else if (gamepad1.y == true) { //.5!!
                s.setPosition(.5);
            }


        }

    }
}
