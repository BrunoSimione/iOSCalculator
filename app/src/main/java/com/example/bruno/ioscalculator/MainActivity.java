package com.example.bruno.ioscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CalculatorEngine engine;
    TextView txtNumber;
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber = (TextView) findViewById(R.id.numberText);
        txtDetail = (TextView) findViewById(R.id.detailText);
        engine = new CalculatorEngine();

    }

    public void btnClicked(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn0:
                engine.numberClicked(0) ;
                break;
            case R.id.btn1:
                engine.numberClicked(1) ;
                break;
            case R.id.btn2:
                engine.numberClicked(2) ;
                break;
            case R.id.btn3:
                engine.numberClicked(3) ;
                break;
            case R.id.btn4:
                engine.numberClicked(4) ;
                break;
            case R.id.btn5:
                engine.numberClicked(5) ;
                break;
            case R.id.btn6:
                engine.numberClicked(6) ;
                break;
            case R.id.btn7:
                engine.numberClicked(7) ;
                break;
            case R.id.btn8:
                engine.numberClicked(8) ;
                break;
            case R.id.btn9:
                engine.numberClicked(9) ;
                break;
            case R.id.btnDot:
                engine.dotClicked();
                break;
            case R.id.btnInvertSignal:
                engine.invertSignal();
                break;
            case R.id.btnPercent:
                engine.percentualClicked();
                break;
            case R.id.btnDivision:
                engine.setOperator("Division") ;
                break;
            case R.id.btnMulti:
                engine.setOperator("Multi") ;
                break;
            case R.id.btnPlus:
                engine.setOperator("Sum") ;
                break;
            case R.id.btnMinus:
                engine.setOperator("Sub") ;
                break;
            case R.id.btnEqual:
                engine.calculateTotal();
                break;
            case R.id.btnC:
                engine.clean_number() ;
                break;
            case R.id.btnC1:
                engine.clean_number() ;
                break;
            case R.id.btnMC:
                engine.cleanMemory();
                break;
            case R.id.btnMR:
                engine.recoverMemory();
                break;
            case R.id.btnMMinus:
                engine.memorySub();
                break;
            case R.id.btnMPlus:
                engine.memorySum();
                break;

        }

        txtNumber.setText(engine.getNumber());
        txtDetail.setText(engine.getDetail());
    }



    //Validation Method
    public String appendNumber(String number, String txtValue){
        String result;

        //First input will only change the text if it's different from 0 or dot
        if(txtValue.equals("0.0")){
            //If it's a dot, it won't change the text
            if(number.equals(".")){
                result = "0" + number;

            //If It's zero , it will add zeroes after the dot
            }else if(number.equals("0")){
                result = txtValue + number;

            //Anything else, remove the left zeroes and set the input number
            }else {
                result = number;
            }

        //After first input, the text will always change
        }else{
            if(number.equals(".")){
                //Checks if it's the first dot (the number showed can have only one)
                //If the number already have a dot, do not add a new one
                if(txtValue.contains(".")){
                    result = txtValue;

                //If it's the first dot, then add to the number
                }else{
                    result = txtValue + number;
                }
            //Any other number, we just append and return
            }else{
                result = txtValue + number;
            }

        }
        return result;
    }
}
