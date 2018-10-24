package com.example.bruno.ioscalculator;

public class CalculatorEngine {

    private String number;
    private String detail;
    public double operand1;
    public double operand2;
    private String operationType = "";
    private boolean operationIsSelected = false;
    private double memoryNumber = 0.0;

    public CalculatorEngine(){
        this.number = "0";
        this.operand1 = 0;
        this.operand2 = 0;
        this.detail = "Enter a number";
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

    public void invertSignal(){
        this.number = removeZeroes(Double.parseDouble(this.number) * (-1));
    }

    public void setOperator(String operator){
        this.operationIsSelected = true;
        this.operationType = operator;

        this.operand1 = Double.parseDouble(this.number);

        this.number = "";
    }

    public void calculateTotal(){
        if(this.operationIsSelected){
            this.operand2 = Double.parseDouble(this.number);
            this.operationIsSelected = false;
        }else{
            if(this.operationType != ""){
                this.operand1 = Double.parseDouble(this.number);
            }else{
                return;
            }
        }
        this.number = removeZeroes(calculateAux());
    }

    public double calculateAux(){
        double result = 0.0;
        String operator = "";

        switch (this.operationType){
            case "Multi":
                result = operand1 * operand2;
                operator = removeZeroes(operand1) + " * " + removeZeroes(operand2);
                break;
            case "Division":
                result = operand1 / operand2;
                operator = removeZeroes(operand1) + " / " + removeZeroes(operand2);
                break;
            case "Sum":
                result = operand1 + operand2;
                operator = removeZeroes(operand1) + " + " + removeZeroes(operand2);
                break;
            case "Sub":
                result = operand1 - operand2;
                operator = removeZeroes(operand1) + " - " + removeZeroes(operand2);
                break;
        }
        this.detail = operator;
        return result;
    }

    public void percentualClicked(){
        if(operationIsSelected){
            switch (this.operationType){
                case "Multi":
                    this.number = removeZeroes((Double.parseDouble(this.number))/100);
                    break;
                case "Division":
                    this.number = removeZeroes((Double.parseDouble(this.number))/100);
                    break;
                case "Sum":
                    this.number = removeZeroes((operand1/100) * Double.parseDouble(this.number));
                    break;
                case "Sub":
                    this.number = removeZeroes((operand1/100) * Double.parseDouble(this.number));
                    break;
            }
            calculateTotal();
        }else{
            this.number = String.valueOf((Double.parseDouble(this.number))/100);
        }
    }

    public String getNumber(){
        return this.number;
    }

    public String getDetail(){
        return this.detail;
    }

    public void clean_number(){
        this.number = "0";
        this.operationIsSelected = false;
        this.operationType = "";
        this.operand1 = 0;
        this.operand2 = 0;
        this.detail = "Enter a number";
    }

    public void recoverMemory(){
        this.number = removeZeroes(memoryNumber);
    }

    public void cleanMemory(){
        this.memoryNumber = 0.0;
    }

    public void memorySum(){
        double number = Double.parseDouble(this.number);
        this.memoryNumber += number;
    }

    public void memorySub(){
        double number = Double.parseDouble(this.number);
        this.memoryNumber -= number;
    }

    public String removeZeroes(double value){
        String s = String.valueOf(value);
        s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
        return s;
    }
}
