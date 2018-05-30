package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by mai on 3/14/18.
 */
@TeleOp
public class tank extends LinearOpMode{

    DcMotor left, right;
    Servo arm;

    public void runOpMode(){

        left = hardwareMap.dcMotor.get("l");
        right = hardwareMap.dcMotor.get("r");
        arm = hardwareMap.servo.get("s");


        waitForStart();


        while(opModeIsActive()) {
            left.setPower(gamepad1.left_stick_y);

            right.setPower(gamepad1.right_stick_y);

            right.setDirection(DcMotorSimple.Direction.REVERSE);

            if(gamepad1.x == true){
                arm.setPosition(1);
            }
            else{
                arm.setPosition(0);
            }



        }



    }
}
