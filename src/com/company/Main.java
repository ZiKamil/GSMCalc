package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] arr  = new String[] {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50",
                "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29",
                "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
        double costPerLiter = 0;
        String carMileage="";
        double firstClass = 0;
        double secondClass = 0;
        double thirthClass = 0;
        double fourthClass =0;
        int keyWithHighestVal = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i].lastIndexOf('-')==6){
                carMileage=arr[i].substring(7);
            }
            else {
                char [] mileage = new char[arr[i].lastIndexOf('-')-7];
                arr[i].getChars(7,arr[i].lastIndexOf('-'), mileage, 0);
                carMileage = String.valueOf(mileage);
            }
            switch (arr[i].charAt(1)){
                case '1':
                    costPerLiter=46.10;
                    firstClass += costPerLiter*Double.parseDouble(carMileage);
                    break;
                case '2':
                    costPerLiter=48.90;
                    secondClass += costPerLiter*Double.parseDouble(carMileage);
                    break;
                case '3':
                    costPerLiter=47.50;
                    thirthClass += costPerLiter*Double.parseDouble(carMileage);
                    break;
                case '4':
                    costPerLiter=48.90;
                    fourthClass += costPerLiter*Double.parseDouble(carMileage);
                    break;
                default:
                    costPerLiter=-1;
                    break;
            }
        }
        System.out.println("Первый класс авто: " + firstClass);
        System.out.println("Второй класс авто: " + secondClass);
        System.out.println("Третий класс авто: " + thirthClass);
        System.out.println("Четвертый класс авто: " + fourthClass);
        double totalCoast = firstClass+secondClass+thirthClass+fourthClass;
        System.out.println("Общая стоимость: " + totalCoast);

        TreeMap<Integer, Integer> list = new TreeMap<>();
        list.put(100,(int)firstClass);
        list.put(200,(int)secondClass);
        list.put(300,(int)thirthClass);
        list.put(400,(int)fourthClass);

        int maxValueInMap = (Collections.max(list.values()));
        for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                keyWithHighestVal = entry.getKey();
            }
        }
        System.out.println("Наибольшую стоимость имеет тип " + keyWithHighestVal);

        maxValueInMap = (Collections.min(list.values()));
        for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                keyWithHighestVal = entry.getKey();
            }
        }
        System.out.println("Наименьшую стоимость имеет тип " + keyWithHighestVal);

        Scanner scan = new Scanner(System.in);
        getInfoByType(arr, scan.nextInt());
    }
    public static void getInfoByType(String[] arr, int type){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if( Character.forDigit(type,16) == arr[i].charAt(1)){
                for(int j=0; j<list.size(); j++){
                    if(list.get(j).charAt(5)==arr[i].charAt(5)){
                        System.out.println("list");
                    }
                    else{

                    }
                }
                list.add(arr[i]);
            }
        }
        System.out.println(list);
    }
}
