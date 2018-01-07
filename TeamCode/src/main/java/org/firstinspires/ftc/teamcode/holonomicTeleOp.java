package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by mai on 1/6/18.
 */
@TeleOp
public class holonomicTeleOp extends LinearOpMode{

    DcMotor motor0, motor1, motor2, motor3, arm;
    Servo BL, TL, BR, TR;
    //   ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {


        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        // motor3 = hardwareMap.dcMotor.get("motor3");
        arm = hardwareMap.dcMotor.get("arm");
        BL = hardwareMap.servo.get("bl");
        TL = hardwareMap.servo.get("tl");
        BR = hardwareMap.servo.get("br");
        TR = hardwareMap.servo.get("tr");




        waitForStart();





        while (opModeIsActive()) {

            float gamepad1LeftX = gamepad1.left_stick_x;
            float gamepad1LeftY = gamepad1.left_stick_y;
            float gamepad1RightX = gamepad1.right_stick_x;

            float frontL = -gamepad1LeftX + gamepad1LeftY + gamepad1RightX;
            float frontR = gamepad1LeftX - gamepad1LeftY - gamepad1RightX;
            float backL = gamepad1LeftX + gamepad1LeftY - gamepad1RightX;
            float backR = -gamepad1LeftX - gamepad1LeftY - gamepad1RightX;

            // clip so range does not exceed +/- 1
            frontL = Range.clip(frontL, -1, 1);
            frontR = Range.clip(frontR, -1, 1);
            backL = Range.clip(backL, -1, 1);
            backR = Range.clip(backR, -1, 1);

            motor0.setPower(frontL);
            motor1.setPower(frontR);
            motor2.setPower(backL);
            // motor3.setPower(backR);


            telemetry.addData("Text", "***Debug Data***");

            telemetry.addData("Text", "Motor0" + frontL);
            telemetry.addData("Text", "Motor1" + frontR);
            telemetry.addData("Text", "Motor2" + backL);
            //Telemetry.Item text = telemetry.addData("Text", "Motor3" + backR);


            // NullPointerException(String s);


            if(gamepad1.a == true){
                arm.setPower(1);
            }
            else if(gamepad1.b == true){
                arm.setPower(-1);
            }
            else{
                arm.setPower(0);
            }

            if(gamepad1.x == true){
                BL.setPosition(1);
                TL.setPosition(1);
                BR.setPosition(-1);
                TR.setPosition(-1);
            }



        }

    }
}
