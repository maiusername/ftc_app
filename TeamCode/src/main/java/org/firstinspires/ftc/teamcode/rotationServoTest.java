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
@TeleOp
public class rotationServoTest extends LinearOpMode{


   CRServo s;

    public void runOpMode(){

        s = hardwareMap.crservo.get("s");

        waitForStart();

        while(opModeIsActive()) {


            if (gamepad1.a == true) {
              
            } else if (gamepad1.b == true) { // to the right
                s.setPower(1);
            } else if (gamepad1.x == true) { //
                s.setPower(-1);
            } else if (gamepad1.y == true) {
                s.setPower(-2);
            }


        }

    }
}
