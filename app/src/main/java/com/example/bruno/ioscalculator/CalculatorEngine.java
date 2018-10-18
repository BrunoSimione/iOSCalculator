package com.example.bruno.ioscalculator;

public class CalculatorEngine {

    private String number;
    private double detail;
    public double operand1;
    public double operand2;
    private String operationType;
    private boolean operationIsSelected;


    public CalculatorEngine(){
        this.number = "0";
        this.operand1 = 0;
        this.operand2 = 0;
    }

    public void numberClicked(int number){
        if(this.number.equals("0")){
            this.number = String.valueOf(number);
        }else{
            this.number = this.number + String.valueOf(number);
        }
    }

    public void dotClicked(){
        if(!this.number.contains(".")){
            this.number += ".";
        }
    }

    public void setOperator(String operator){
        this.operationIsSelected = true;
        this.operationType = operator;

        this.operand1 = Double.parseDouble(this.number);
        this.number = "";
    }

    public void calculateTotal(){
        if(this.operationIsSelected){
            double result = 0.0;
            this.operand2 = Double.parseDouble(this.number);

            switch (this.operationType){
                case "Multi":
                    result = operand1 * operand2;
                    break;
                case "Division":
                    result = operand1 / operand2;
                    break;
                case "Sum":
                    result = operand1 + operand2;
                    break;
                case "Sub":
                    result = operand1 - operand2;
                    break;
                default:
                    return;
            }
            this.number = String.valueOf(result);
            this.operationIsSelected = false;
        }else{
            double result = 0.0;
            this.operand1 = Double.parseDouble(this.number);

            switch (this.operationType) {
                case "Multi":
                    result = operand1 * operand2;
                    break;
                case "Division":
                    result = operand1 / operand2;
                    break;
                case "Sum":
                    result = operand1 + operand2;
                    break;
                case "Sub":
                    result = operand1 - operand2;
                    break;
                default:
                    return;
            }
            this.number = String.valueOf(result);
        }
    }

    public String getNumber(){

        return this.number;
        /*
        double d = Double.parseDouble(this.number);
        int i = (int) d;
        return d == i ? String.valueOf(i) : String.valueOf(d);
        */
    }

    public void clean_number(){
        this.number = "0";
        this.operationIsSelected = false;
        this.operationType = "";
        this.operand1 = 0;
        this.operand2 = 0;
    }
}
