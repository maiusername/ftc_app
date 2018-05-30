package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by mai on 1/6/18.
 *
 * *******Encoders for claw, increment each one revolution
 */
@TeleOp
public class holonomicTeleOp extends LinearOpMode{


    /*
    creates object through constructor to access all of the bot's hardware
     declares the variables
     */
    botHardware robot = new botHardware();



    @Override
    public void runOpMode() {


        /**
         * initialize the hardware (This is not done in botHardware!
         */
        robot.init(hardwareMap);


        /**
         * required - waits for the start button to be pressed.
         */
        waitForStart();

        /**
         * Runs the code while the opMode is still active - stop button is not pressed
         * Loop
         */
        while (opModeIsActive()) {



            /**
             * Assign variables to controller
             * LEFT - X and Y AXIS
             * RIGHT - X AXIS ONLY
             */
            float gamepad1LeftX = gamepad1.left_stick_x;
            float gamepad1LeftY = gamepad1.left_stick_y;
            float gamepad1RightX = gamepad1.right_stick_x;

            /**
             *
             */

            double frontL = -gamepad1LeftX + gamepad1LeftY - gamepad1RightX;
            double frontR = -gamepad1LeftX - gamepad1LeftY - gamepad1RightX;
            double backL = gamepad1LeftX + gamepad1LeftY - gamepad1RightX;
            double backR = gamepad1LeftX - gamepad1LeftY - gamepad1RightX;

            // clip so range does not exceed +/- 1
            frontL = Range.clip(frontL, -.6, .6);
            frontR = Range.clip(frontR, -.6, .6);
            backL = Range.clip(backL, -.6, .6);
            backR = Range.clip(backR, -.6, .6);

            robot.motor0.setPower(frontL);
            robot.motor1.setPower(frontR);
            robot.motor2.setPower(backL);
            robot.motor3.setPower(backR);






            telemetry.update();


            telemetry.addData("Text", "***Debug Data***");

            telemetry.addData("Text", "Motor0" + frontL);
            telemetry.addData("Text", "Motor1" + frontR);
            telemetry.addData("Text", "Motor2" + backL);
            telemetry.addData("Text", "Motor3" + backR);


            // NullPointerException(String s);


            if(gamepad1.a == true){


                robot.arm.setPower(0);

            }
            else if(gamepad1.b == true){
                robot.arm.setPower(0.6);
            }
            else{

                robot.arm.setPower(.1);
            }

            if(gamepad1.x == true){
                robot.BL.setPosition(1);
                robot.TL.setPosition(-1);
                robot.BR.setPosition(-1);
                robot.TR.setPosition(1);
            }
            else if(gamepad1.y == true){
                robot.BL.setPosition(-1);
                robot.TL.setPosition(1);
                robot.BR.setPosition(1);
                robot.TR.setPosition(-1);
            }

            telemetry.addData("Servo Position:", robot.jewelServo.getPosition());



        }

    }
}
